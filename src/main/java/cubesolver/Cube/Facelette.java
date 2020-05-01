package cubesolver.Cube;

/**
 * Classe décrivant une facelette par sa couleur (statique) et son appartenance à une face (dynamique)
 * On représente les couleurs d'un cube avec leurs faces associées comme il suit:
 * U - UP/jaune
 * F - FRONT/bleu
 * L - LEFT/orange
 * B - BACK/vert
 * R - RIGHT/rouge
 * D - DOWN/blanc
 */
public class Facelette {
    public final char color;
    public char face;

    public Facelette(char color, char face) {
        this.color = color;
        this.face = face;
    }
}
