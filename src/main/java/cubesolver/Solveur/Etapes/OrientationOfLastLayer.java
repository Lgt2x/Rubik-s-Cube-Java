package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * Etape de résolution #4
 * Résout la face jaune, sans placer correctement les pièces
 */
public class OrientationOfLastLayer extends EtapeResolution {

    // String utilisé pour trouver les voisins d'une face dans l'ordre donné
    String voisins = "RBLFR";

    // Correspondance entre face et chiffre associé pour la représentation
    HashMap<Character, Integer> correspondance;

    @Override
    public String effectuerEtape() {
        StringBuilder mouvements = new StringBuilder();

        correspondance = new HashMap<>();
        correspondance.put('U', 0);
        correspondance.put('R', 1);
        correspondance.put('B', 4);
        correspondance.put('L', 7);
        correspondance.put('F', 10);

        int compteur = 0;
        int cas = conversionLastLayer(); // Conversion de la position courante pour identifier le cas à traiter
        // Lire dans le fichier pour ajouter les oll
        HashMap<Integer, String> oll = chargementOLL("Formules/positions.oll");

        /*Pour placer comme il faut la face du dessus pour trouver une configuration connue
        par analyse des symétrie, il est possible de diviser par 4 le nombre de cas
        Pour cela, si un cas n'est pas connu, nous effectuerons une rotation de la face du haut
         */

        for (int i = 0; i < 5; i++) {
            compteur++;
            // Si notre cas est connu : resoudre, sinon faire tourner la face du haut jusqu'à tomber dessus
            if (oll.containsKey(cas)) {
                Cube.formule(oll.get(cas));
                mouvements.append(oll.get(cas));
                break;
            } else if (i < 4) {
                Cube.mouvement('U');
                mouvements.append('U');
                cas = conversionLastLayer();
            } else {
                Cube.formule("FURurf");
                mouvements.append("FURurf");
                i = 0;
            }
        }
        if (compteur == 5) {
            return "erreur";
        } else {
            return mouvements.toString();

        }
    }

    /**
     * L'objectif de cette methode est de convertir le cube en un int afin de connaitre
     * l'orientation des pieces du dernier etage our resoudre la face avec une unique formule
     * Cette methode étudie la dernière couronne du cube, elle en crée un int composé de 0 et de 1
     * un 1 signifie que la facelette est  jaune, un 0 signifie que cette dernière ne l'est pas
     * Il en resulte une combinaison unique que l'on peut identifier à l'aide du fichier positions.oll
     * @return la configuration sous forme d'int
     */
    public int conversionLastLayer() {
        int configuration = 0;

        // Les aretes jaunes vont de 0 à 3
        for (int i = 0; i < 4; i++) {
            configuration += 0b01 << correspondance.get(Cube.aretes[i].facelettes[0].face);
            if (Cube.aretes[i].facelettes[0].face == 'U') {
                configuration -= 0b01; // On ne veut rien ajouter quand c'est U
            }
        }

        int coef;
        for (int i = 0; i < 4; i++) {
            if (Cube.angles[i].facelettes[0].face != 'U') {
                int j = 0;
                while (Cube.angles[i].facelettes[0].face != voisins.charAt(j)) {
                    j++;
                }

                coef = 1 << (3 * j);
                if (Cube.angles[i].appartientFace(voisins.charAt(j + 1)))
                    coef = coef << 2; // Décalage de 2 bits vers la gauche dans ce cas
                configuration += coef;
            }
        }
        return configuration;
    }

    /**
     * Chargement des OLL depuis un fichier externe dans le dossier ressources
     * <p>
     * Format .oll avec la spécification suivante:
     * // Commentaire
     * <configuration> <formule>
     * Configuration : correspondance de la configuration donnée suivant le format retourné par ConversionLastLayer
     * Formule : la formule résolvant la configuration (à chaque configuration correspond une unique formule qui resoud le cube)
     *
     * @param fichier chemin relatif du fichier ressource .oll, à partir du dossier ressources
     * @return la table de correspondance des OLL utilisée plus tard
     */
    public HashMap<Integer, String> chargementOLL(String fichier) {
        HashMap<Integer, String> oll = new HashMap<>();
        try {
            // Recherche du chemin de la classe courante
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();

            // Chargement d'une ressource à partir du dossier concerné
            InputStream is = classloader.getResourceAsStream(fichier);

            // Initialisation de la lecture du fichier comme stream
            assert is != null;
            InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);

            String st;
            String[] separateur;

            // Lire la ligne tant qu'on n'est pas arrivés au bout du fichier
            while ((st = reader.readLine()) != null) {
                if (st.charAt(0) != '/' && st.charAt(1) != '/') {

                    // Séparation de la chaine de caractère en deux, d'un côté le long, de l'autre la formule associée
                    separateur = st.split(" ");

                    // Remplissage de la table de correspondance à partir des données du fichier
                    oll.put(
                            Integer.parseInt(separateur[0], 2),
                            separateur[1]
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur de chargement des oll");
        }

        return oll;
    }
}
