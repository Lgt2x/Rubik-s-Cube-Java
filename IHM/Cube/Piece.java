package IHM.Cube;

/**
 * Pièce PHYSIQUE définie par son appartenance à 2/3 face qui changent en fonction des mouvements
 */
public abstract class Piece {
    Facelette[] facelettes;

    public Piece(String name) {
        this.facelettes = new Facelette[name.length()];

        for(int i = 0; i < name.length(); i++) {
            this.facelettes[i] = new Facelette(name.charAt(i),name.charAt(i));
        }
    }

    public boolean appartientFace(char face) {
        for (int i = 0; i <  facelettes.length; i++) {
            if (facelettes[i].face == face) {
                return true;
            }
        }
        return false;
    }

    public void mouvement(Face face, boolean direction) {
        if(appartientFace(face.valeur)){
            for (Facelette facelette: facelettes) {
                if (facelette.face != face.valeur) {
                    facelette.face = face.faceSuivante(facelette.face, direction);
                }
            }
        }
    }
}
