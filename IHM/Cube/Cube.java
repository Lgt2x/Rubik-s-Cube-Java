package IHM.Cube;

import java.util.HashMap;

public class Cube {

    public static HashMap<String, Face> faces;
    public static HashMap<String, String> facesVoisines;
    public static String[] nomFaces;

    public Cube() {
        nomFaces = new String[]{"U", "L", "B", "D", "R", "F"};
        facesVoisines.put("U", "FLBR");
        facesVoisines.put("L", "UFDB");
        facesVoisines.put("B", "ULDR");
        facesVoisines.put("D", "FRBL");
        facesVoisines.put("R", "UBDF");
        facesVoisines.put("F", "URDL");

        faces = new HashMap<>();
        for (String name: nomFaces) {
            faces.put(name, new Face(name, facesVoisines.get(name)));
        }


    }

    public void mouvement(Face face, boolean direction) {
        //TODO : compléter la méthode
    }
}
