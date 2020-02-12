package IHM.Cube;

import java.util.HashMap;


public class Cube {

    public static HashMap<String, Face> faces;
    public static HashMap<String, String> facesVoisines;
    public static String[] nomFaces;




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


    Face U = new Face('U', "LBRFL");
    Face L = new Face('L', "DBUFD");
    Face B = new Face('B', "LDRUL");
    Face R = new Face('R', "UBDFU");
    Face F = new Face('F', "LURDL");
    Face D = new Face('D', "RBLFR");
    char[] ordre ={'U','L','B','R','F','D'};
    Face[] ordreFace = {U,F,L,B,R,D};

    public Cube() {
        nomFaces = new String[]{"U", "L", "B", "D", "R", "F"};
        facesVoisines = new HashMap<>();
        facesVoisines.put("U", "LBRFL");
        facesVoisines.put("F", "LURDL");
        facesVoisines.put("L", "DBUFD");
        facesVoisines.put("B", "LDRUL");
        facesVoisines.put("D", "RBLFR");
        facesVoisines.put("R", "UBDFU");


        faces = new HashMap<>();
        for (String nom: nomFaces) {
            faces.put(nom, new Face(nom.charAt(0), facesVoisines.get(nom)));
        }
    }
        /* TODO: debugger les mouvements
         */
    public void mouvement(String nomFace, boolean direction) {
        Face face = faces.get(nomFace);

        /* Pour les angles */
        for(Piece angle: angles) {
            angle.mouvement(face, direction);
        }

        /* Pour les arêtes */
        for(Piece arete: aretes) {
            arete.mouvement(face, direction);
        }
    }

   public int[][][] exportCube(){

        /*ordre :
        0 = U = jaune
        1 = F = bleu
        2 = L = orange
        3 = B = vert
        4 = R = rouge
        5 = D = blanc
         */

        int[][][] cubeExporte = new int[6][3][3];

        for(int i = 0; i<cubeExporte.length; i++) {
            System.out.println(("compteur :"+i));
            char couleur = correspondance2(i);
            int chiffre = i;
            int[][] faceExporte = new int[3][3];

            int[] compteurLigneAngle = {0, 0, 2, 2};
            int[] compteurColoneAngle = {0, 2, 0, 2};
            int[] compteurLigneArete = {0, 1, 1, 2};
            int[] compteurColoneArete = {1, 0, 2, 1};
            Face test = ordreFace[i];
            System.out.println(test);
            cubeExporte[i][1][1] = i;

            //renvoyer les angles
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < angles.length; k++) {
                    if (angles[k].appartientFace(couleur) && angles[k].appartientFace(test.voisins.charAt(j)) && angles[k].appartientFace(test.voisins.charAt(j + 1))) {
                        for (int l = 0; l < angles[k].facelettes.length; l++) {
                            if (angles[k].facelettes[l].face == couleur) {
                                chiffre = correspondance(angles[k].facelettes[l].color);
                            }
                        }
                        cubeExporte[i][compteurLigneAngle[j]][compteurColoneAngle[j]] = chiffre;
                    }
                }
            }
            //renvoyer les aretes
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < aretes.length; k++) {
                    if (aretes[k].appartientFace(couleur) && aretes[k].appartientFace(test.voisins.charAt(j))) {
                        for (int l = 0; l < aretes[k].facelettes.length; l++) {
                            if (aretes[k].facelettes[l].face == couleur) {
                                chiffre = correspondance(aretes[k].facelettes[l].color);
                            }
                        }
                        cubeExporte[i][compteurLigneArete[j]][compteurColoneArete[j]] = chiffre;
                    }
                }
            }
        }//EndFor, pour une face
        return cubeExporte;
    }

    public static int correspondance(char face){
        String a = "UFLBRD";
        return a.indexOf(face);
    }
    public static char correspondance2(int i){
        String a = "UFLBRD";
        return a.charAt(i);
    }
}
