package cubesolver;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;
import cubesolver.Solveur.Solveur;

public class Launcher {
    public Launcher() {
        new Cube();
        new Solveur();
        new GestionAffichage();
    }

}
