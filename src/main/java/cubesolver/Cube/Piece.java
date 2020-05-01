package cubesolver.Cube;

/**
 * Pièce PHYSIQUE définie par son appartenance à 2/3 face qui changent en fonction des mouvements
 * Peut être un angle ou une arête, en fonction du nombre de faces. Le traitement est le même
 */
public class Piece {
    public Facelette[] facelettes; // Les facelettes appartement à la face, sous forme de face + couleur
    public String name;

    public Piece(String name) {
        this.name = name;
        this.facelettes = new Facelette[name.length()];

        for (int i = 0; i < name.length(); i++) {
            this.facelettes[i] = new Facelette(name.charAt(i), name.charAt(i));
        }
    }

    /**
     * Effectue un mouvement du cube en déplaçant la pièce si elle est sur la face concernée
     *
     * @param face      la face qui est tournée sur le cube
     * @param direction true si le sens est le sens horaire, false sinon
     */
    public void mouvement(Face face, boolean direction) {
        if (appartientFace(face.valeur)) {
            for (Facelette facelette : facelettes) {
                if (facelette.face != face.valeur) {
                    facelette.face = face.faceSuivante(facelette.face, direction);
                }
            }
        }
    }

    /**
     * Vérifie l'appartenance de la pièce à une face donnée
     *
     * @param face le caractère décrivant la face
     * @return True si la pièce appartient à la face en entrée, false sinon
     */
    public boolean appartientFace(char face) {
        for (Facelette facelette : facelettes) {
            if (facelette.face == face) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vérifie que la pièce est orientée correctement par rapport à sa position d'origine
     *
     * @return true si la pièce est orientée correctement
     */
    public boolean estOrienteCorrectement() {
        for (Facelette facelette : facelettes) {
            if (facelette.color == facelette.face) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vérifie que l'angle est en place sur la bonne face, si toutes ses facelettes sont orientées correctement absoluement
     *
     * @return true si l'angle est en place, false sinon
     */
    public boolean estPositionneeCorrectement() {
        for (Facelette facelette : facelettes) {
            if (!(facelette.color == facelette.face)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Vérifie que l'angle est orienté selon une face donnée
     *
     * @param face le caractère correspondant à la face par rapport à laquelle on veut vérifier l'orientation de l'angle
     * @return true si la pièce est positionnée correctement par rapport à la face donnée
     */
    public boolean estOrienteeSelon(char face) {
        for (Facelette facelette : facelettes) {
            if (!(facelette.color == face)) {
                return false;
            }
        }
        return true;
    }


    public boolean correspondA(String nom) {

        for (int i = 0; i < this.name.length(); i++) {
            if (!this.name.contains("" + nom.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
