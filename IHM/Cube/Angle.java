package IHM.Cube;

public class Angle extends  Piece{

    //instancier les pièces dans leur position initiale
    public Angle (String name) {
        this.facelette = new Facelette[3];
        for(int i = 0; i < 3; i++) {
            this.facelette[i] = new Facelette(name.charAt(i),name.charAt(i));
        }
    }
}
