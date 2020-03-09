package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import java.io.IOException;

public class OrientationOfLastLayer extends EtapeResolution {
    Long cas;

    @Override
    public String effectuerEtape() {

        StringBuilder mouvements = new StringBuilder();
        cas = conversionLastLayer(); // Conversion de la position courante pour identifier le casà traiter
        boolean estResolu = false;

        // Lire dans le fichier pour ajouter les oll
        HashMap<Long, String> oll = chargementOLL("Formules/positions.oll");

        do {
            // Si notre cas est connu : resoudre, sinon faire tourner la face du haut jusqu'à tomber dessus
            if(oll.containsKey(cas)) {
                Cube.formule(oll.get(cas));
                mouvements.append(oll.get(cas));
                estResolu = true;
            }else{
                Cube.mouvement('U');
                mouvements.append('U');
                cas = conversionLastLayer();
            }
        } while(!estResolu);

        return mouvements.toString();
    }

    public Long conversionLastLayer() {
        // l'objectif de cette methode est de convertir le cube en un long afin de connaitre l'orientation des pieces du dernier etage our resoudre la face avec une unique formule
        long a = 0L;
        long coef;
        String voisins = "RBLFR";

        HashMap<Character, Integer> correspondance = new HashMap<>();
        correspondance.put('U', 0);
        correspondance.put('R', 1);
        correspondance.put('B', 4);
        correspondance.put('L', 7);
        correspondance.put('D', 10);
        correspondance.put('F', 10);

        // Les aretes jaune vont de 0 à 3
        for(int i = 0; i<4; i++){
            a+=(long)(Math.pow(10,correspondance.get(Cube.aretes[i].facelettes[0].face)));
            if(Cube.aretes[i].facelettes[0].face == 'U'){
                a-=1; // On ne veut rien ajouter quand c'est U
            }
        }

        for(int i = 0; i<4; i++){
            if(Cube.angles[i].facelettes[0].face != 'U'){
                int j = 0;
                while(Cube.angles[i].facelettes[0].face != voisins.charAt(j)){
                    j++;
                }

                coef = (long)(Math.pow(10,3*j));

                if(Cube.angles[i].appartientFace(voisins.charAt(j+1))){
                    coef *=100L;
                }
                a+=coef;
            }
        }
        return a;
    }

    public HashMap<Long, String> chargementOLL(String fichier) {
        HashMap<Long, String> oll = new HashMap<>();
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
                    oll.put(Long.parseLong(separateur[0]), separateur[1]);
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur de chargement des oll");
        }

        return oll;
    }
}
