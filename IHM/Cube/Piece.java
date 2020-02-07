package IHM.Cube;

public abstract class Piece {
    Facelette[] facelette;

    public boolean appartientFace(Face face) {
        for (int i=0;i<facelette.length;i++) {
            if (facelette[i].face == face) {
                return true;
            }
        }
        return false;
    }
}
