package IHM.Cube;

import java.util.HashMap;

public class Cube {

    public static HashMap<String, Face> faces;
    public static HashMap<String, String> facesVoisines;
    public static String[] nomFaces;

    // TODO : Générer automatiquement les angles et arêtes
    public static Angle[] angles = {
            new Angle("UFL"),
            new Angle("UBL"),
            new Angle("UBR"),
            new Angle("UFR"),
            new Angle("DFR"),
            new Angle("DFL"),
            new Angle("DBL"),
            new Angle("DBR")
    };

    public static Arete[] aretes = {
            new Arete("UF"),
            new Arete("UL"),
            new Arete("UB"),
            new Arete("UR"),
            new Arete("DF"),
            new Arete("DR"),
            new Arete("DB"),
            new Arete("DL"),
            new Arete("FR"),
            new Arete("FL"),
            new Arete("BL"),
            new Arete("BR")
    };


    public Cube() {
        nomFaces = new String[]{"U", "L", "B", "D", "R", "F"};
        facesVoisines = new HashMap<>();
        facesVoisines.put("U", "FLBRF");
        facesVoisines.put("L", "UFDBU");
        facesVoisines.put("B", "ULDRU");
        facesVoisines.put("D", "FRBLF");
        facesVoisines.put("R", "UBDFU");
        facesVoisines.put("F", "URDLU");

        faces = new HashMap<>();
        for (String nom: nomFaces) {
            faces.put(nom, new Face(nom.charAt(0), facesVoisines.get(nom)));
        }
    }

    public void mouvement(String nomFace, boolean direction) {
        Face face = faces.get(nomFace);

        /* Pour les angles */
        for(Angle angle: angles) {
            angle.mouvement(face, direction);
        }

        /* Pour les arêtes */
        for(Arete arete: aretes) {
            arete.mouvement(face, direction);
        }
    }
}
