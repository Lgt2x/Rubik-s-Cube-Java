package IHM.Cube;

import java.util.HashMap;

public class Cube {

    public static HashMap<String, Face> faces;
    public static HashMap<String, String> facesVoisines;
    public static String[] nomFaces;

    public Angle[] angles = {
            new Angle("UFL"),
             new Angle("UBL"),
          new Angle("UBR"),
          new Angle("UFR"),
           new Angle("DFR"),
           new Angle("DFL"),
         new Angle("DBL"),
          new Angle("DBR")
    };

    public Arete[] aretes = {
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
        facesVoisines.put("U", "FLBRF");
        facesVoisines.put("L", "UFDBU");
        facesVoisines.put("B", "ULDRU");
        facesVoisines.put("D", "FRBLF");
        facesVoisines.put("R", "UBDFU");
        facesVoisines.put("F", "URDLU");

        faces = new HashMap<>();
        for (String name: nomFaces) {
            faces.put(name, new Face(name.charAt(0), facesVoisines.get(name)));
        }


    }

    public void mouvement(Face face, boolean direction) {
        Angle angleBis;

        for(int i = 0; i< angles.length; i++){
            if(angles[i].appartientFace(face.valeur)){
                for(int k = 0; k< angles.length; k++){
                    if(angles[i].facelette[k].color != face.valeur){
                        angles[i].facelette[k].color = face.queue.get(face.queue.indexOf(angles[i].facelette[k].face)+1);
                    }
                }

            }

        }
    }
}
