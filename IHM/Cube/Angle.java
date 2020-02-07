package IHM.Cube;

public class Angle extends  Piece{
    public Angle (Facelette f1, Facelette f2, Facelette f3) {
        this.facelette = new Facelette[3];
        this.facelette[0] = f1;
        this.facelette[1] = f2;
        this.facelette[2] = f3;
    }
}
