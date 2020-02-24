package cubesolver.Cube;

/**
 * Pièce PHYSIQUE définie par son appartenance à 2/3 face qui changent en fonction des mouvements
 */
public class Piece {
    public Facelette[] facelettes;

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

    public boolean estDeCouleur(char face){
        for (int i = 0; i <  facelettes.length; i++) {
            if (facelettes[i].color == face) {
                return true;
            }
        }
        return false;
    }

    public boolean estOriente(){
        for (int i = 0; i <  facelettes.length; i++) {
            if (facelettes[i].color == facelettes[i].face) {
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

    public boolean estEnPlace(){
        boolean b = true;
        int i = 0;
        while(b && i<this.facelettes.length){
            b = this.facelettes[i].color == this.facelettes[i].face;
            i++;
        }
        return b;
    }

    public boolean orienteSelon(char face){
        boolean b = false;
        int i = 0;
        while(i<facelettes.length && !b){
            b = facelettes[i].color == face;
            i++;
        }
        return b;
    }
}