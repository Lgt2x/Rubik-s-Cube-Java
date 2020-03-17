package cubesolver.Cube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Random;

/**
 * Classe décrivant le cube, avec ses faces, ses pièces physiques
 * Traite les mouvements, les formules, et s'exporte sous forme de tableau 3D
 * Comportement passif/esclave : réagit aux appels mais ne réfléchit pas à sa solution
 * Doit être utilisé en static, pour éviter les problèmes dus à l'instanciation
 */
public class Cube {

    // Correspondance entre l'objet face et son caractère correspondant
    public static HashMap<String, Face> faces;

    // Correspondance entre le nom d'une face et ses faces voisines, dans le sens horaire
    public static HashMap<String, String> facesVoisines;

    // Nom des faces sous fome de tableau de chaines de caractère
    public static String[] nomFaces = new String[]{"U", "L", "B", "D", "R", "F"};

    // Tableau référençant tous les différents mouvement, pour éviter d'itérer sur nomFaces en maj et en minuscule
    public static String[] mouvements = {"R", "U", "L", "D", "F", "B", "r", "u", "l", "d", "f", "b"};

    // Tableau décrivant l'ordre logique des faces pour une itération
    public static String[] ordreFace = {"U", "F", "L", "B", "R", "D"};

    // Tableau utilisé pour l'export du cube pour l'affichage
    public static int[][][] export = new int[6][3][3];

    // TODO : Générer automatiquement les angles et arêtes
    public static Piece[] angles = {
            new Piece("UFL"),
            new Piece("UBL"),
            new Piece("UBR"),
            new Piece("UFR"),
            new Piece("DFR"),
            new Piece("DFL"),
            new Piece("DBL"),
            new Piece("DBR")
    };

    public static Piece[] aretes = {
            new Piece("UF"),
            new Piece("UL"),
            new Piece("UB"),
            new Piece("UR"),
            new Piece("DF"),
            new Piece("DR"),
            new Piece("DB"),
            new Piece("DL"),
            new Piece("FR"),
            new Piece("FL"),
            new Piece("BL"),
            new Piece("BR")
    };

    public Cube() {
        facesVoisines = new HashMap<>();
        facesVoisines.put("U", "LBRFL");
        facesVoisines.put("F", "LURDL");
        facesVoisines.put("L", "DBUFD");
        facesVoisines.put("B", "LDRUL");
        facesVoisines.put("D", "RBLFR");
        facesVoisines.put("R", "UBDFU");

        // Association des faces à leur nom
        faces = new HashMap<>();
        for (String nom : nomFaces) {
            faces.put(nom, new Face(nom.charAt(0), facesVoisines.get(nom)));
        }
    }

    /**
     * Effectue un mouvement donné en changeant les pièces de place
     *
     * @param nom la face concernée, en majuscule si le mouvement est fait dans le sens horaire, en minuscule le cas contraire
     */
    public static void mouvement(char nom) {
        boolean direction = Character.isUpperCase(nom);
        String nomFace = String.valueOf(Character.toUpperCase(nom));
        Face face = faces.get(nomFace);

        /* Pour les angles */
        for (Piece angle : angles) {
            angle.mouvement(face, direction);
        }

        /* Pour les arêtes */
        for (Piece arete : aretes) {
            arete.mouvement(face, direction);
        }
    }

    /**
     * Effecute les mouvements d'une formule en décomposant la formule
     *
     * @param formule chaine de caractère composée de noms de mouvement concaténés
     */
    public static void formule(String formule) {
        for (int i = 0; i < formule.length(); i++) {
            mouvement(formule.charAt(i));
        }
    }

    /**
     * Effectue la formule inverse de la chaine de caractère donnée
     * i.e. en faisant formule(chaine) puis formuleSymetrique(chaine)
     * on retrouve la position initiale
     *
     * @param formule la chaine de caractère correspondant à la formule que l'on veut inverser
     */
    public static void formuleSymetrique(String formule) {
        char mouvement;

        for (int i = formule.length() - 1; i >= 0; i--) {
            mouvement = formule.charAt(i);
            if (Character.isUpperCase(mouvement))
                mouvement = Character.toLowerCase(mouvement);
            else
                mouvement = Character.toUpperCase(mouvement);

            mouvement(mouvement);
        }
    }

    /**
     * Mélange le cube avec un nombre de mouvements aléatoires donnés
     *
     * @param longueur le nombre de mouvements aléatoire à faire
     * @return la formule de mélange utilisée
     */
    public static String melange(int longueur) {
        StringBuilder combi = new StringBuilder();
        for (int i = 0; i < longueur; i++) {
            combi.append(mouvements[new Random().nextInt(mouvements.length)]);
        }

        formule(combi.toString());
        return combi.toString();
    }

    // TODO : Optimiser cette horreur

    /**
     * Exporte le cube sous forme de tableau à trois dimensions avec les faces dans l'ordre donné par ordreFace
     * C'est un tableau d'int avec l'encodage suivant:
     * 0 = U = jaune
     * 1 = F = bleu
     * 2 = L = orange
     * 3 = B = vert
     * 4 = R = rouge
     * 5 = D = blanc
     *
     * @return le tableau 3d de int
     */
    public static int[][][] exportCube() {
        for (int i = 0; i < 6; i++) {
            char couleur = correspondanceNombreFace(i);
            int chiffre = i;

            int[] compteurLigneAngle = {0, 0, 2, 2};
            int[] compteurColoneAngle = {0, 2, 2, 0};
            int[] compteurLigneArete = {1, 0, 1, 2};
            int[] compteurColoneArete = {0, 1, 2, 1};
            Face test = faces.get(ordreFace[i]);
            export[i][1][1] = i;

            // Renvoyer les angles
            for (int j = 0; j < 4; j++) {
                for (Piece angle : angles) {
                    if (angle.appartientFace(couleur) && angle.appartientFace(test.voisins.charAt(j)) && angle.appartientFace(test.voisins.charAt(j + 1))) {
                        for (int l = 0; l < angle.facelettes.length; l++) {
                            if (angle.facelettes[l].face == couleur) {
                                chiffre = correspondanceFaceNombre(angle.facelettes[l].color);
                            }
                        }
                        export[i][compteurLigneAngle[j]][compteurColoneAngle[j]] = chiffre;
                    }
                }
            }
            // Renvoyer les aretes
            for (int j = 0; j < 4; j++) {
                for (Piece arete : aretes) {
                    if (arete.appartientFace(couleur) && arete.appartientFace(test.voisins.charAt(j))) {
                        for (int l = 0; l < arete.facelettes.length; l++) {
                            if (arete.facelettes[l].face == couleur) {
                                chiffre = correspondanceFaceNombre(arete.facelettes[l].color);
                            }
                        }
                        export[i][compteurLigneArete[j]][compteurColoneArete[j]] = chiffre;
                    }
                }
            }
        } //EndFor, pour une face
        return export;
    }

    public static void importCube(int[][][] cubeImporte) {
        String piece = "";
        int i1;
        int i2;
        int i3;

        int j1;
        int j2;
        int j3;

        int k1;
        int k2;
        int k3;

        char face;

        try {
            // Recherche du chemin de la classe courante
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();

            // Chargement d'une ressource à partir du dossier concerné
            InputStream is = classloader.getResourceAsStream("Formules/import.angles");

            // Initialisation de la lecture du fichier comme stream
            assert is != null;
            InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);

            String st;

            // Lire la ligne tant qu'on n'est pas arrivés au bout du fichier
            while ((st = reader.readLine()) != null) {
                piece = "";
                i1 = st.charAt(0);
                i2 = st.charAt(1);
                i3 = st.charAt(2);

                j1 = st.charAt(3);
                j2 = st.charAt(4);
                j3 = st.charAt(5);

                k1 = st.charAt(6);
                k2 = st.charAt(7);
                k3 = st.charAt(8);


                piece += correspondanceNombreFace(cubeImporte[i1][j1][k1]);
                piece += "" + correspondanceNombreFace(cubeImporte[i2][j2][k2]);
                piece += "" + correspondanceNombreFace(cubeImporte[i3][j3][k3]);
                for (Piece angle : angles) {
                    //si les deux pieces correspondent
                    if (angle.correspondA(piece)) {
                        for (int j = 0; j < 3; j++) {
                            //définit la face sur laquelle on se trouve
                            if (j == 0) {
                                face = correspondanceNombreFace(i1);
                            } else if (j == 1) {
                                face = correspondanceNombreFace(i2);
                            } else {
                                face = correspondanceNombreFace(i3);
                            }
                            // si la couleur présente correspond à la couleur de notre pièce, la placer
                            if (angle.facelettes[0].color == piece.charAt(j)) {
                                angle.facelettes[0].face = face;
                            } else if (angle.facelettes[1].color == piece.charAt(j)) {
                                angle.facelettes[1].face = face;
                            } else if (angle.facelettes[2].color == piece.charAt(j)) {
                                angle.facelettes[2].face = face;
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur de l'import des angles");
        }

        try {
            // Recherche du chemin de la classe courante
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();

            // Chargement d'une ressource à partir du dossier concerné
            InputStream is = classloader.getResourceAsStream("Formules/import.aretes");

            // Initialisation de la lecture du fichier comme stream
            assert is != null;
            InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);

            String st;

            // Lire la ligne tant qu'on n'est pas arrivés au bout du fichier
            while ((st = reader.readLine()) != null) {
                piece = "";
                i1 = st.charAt(0);
                i2 = st.charAt(1);
                i3 = st.charAt(2);

                j1 = st.charAt(3);
                j2 = st.charAt(4);
                j3 = st.charAt(5);

                k1 = st.charAt(6);
                k2 = st.charAt(7);
                k3 = st.charAt(8);
                piece += "" + correspondanceNombreFace(cubeImporte[i1][j1][k1]);
                piece += "" + correspondanceNombreFace(cubeImporte[i2][j2][k2]);

                for (Piece arete : aretes) {
                    //si les deux pieces correspondent
                    if (arete.correspondA(piece)) {
                        for (int j = 0; j < 2; j++) {
                            //définit la face sur laquelle on se trouve
                            if (j == 0) {
                                face = correspondanceNombreFace(i1);
                            } else {
                                face = correspondanceNombreFace(i2);
                            }
                            // si la couleur présente correspond à la couleur de notre pièce, la placer
                            if (arete.facelettes[0].color == piece.charAt(j)) {
                                arete.facelettes[0].face = face;
                            } else if (arete.facelettes[1].color == piece.charAt(j)) {
                                arete.facelettes[1].face = face;
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur de l'import des angles");
        }
    }

    /**
     * Retourne le nombre correspondant à la face donnée dans l'ordre établi par ordreFace
     *
     * @param face la face dont on veut la corespondance
     * @return le nombre correspondant à la face
     */
    public static int correspondanceFaceNombre(char face) {
        String ordre = "UFLBRD";
        return ordre.indexOf(face);
    }

    /**
     * Retourne la face correspondant au nombre donné
     *
     * @param index l'index dont on veut la face associée
     * @return le caractère correspondant à la face donnée
     */
    public static char correspondanceNombreFace(int index) {
        String ordre = "UFLBRD";
        return ordre.charAt(index);
    }
}
