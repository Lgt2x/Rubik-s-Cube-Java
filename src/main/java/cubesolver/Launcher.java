package cubesolver;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

public class Launcher {
    public Launcher() {
        Cube cube = new Cube();
        new GestionAffichage(cube);
    }
}
