package cubesolver.Solveur;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.etapes.*;

import java.util.Iterator;
import java.util.LinkedList;

public class Solveur {
    public Cube cube;
    private Iterator<EtapeResolution> etapes;

    public Solveur(Cube cube) {
        this.cube = cube;
        LinkedList<EtapeResolution> etapesList = new LinkedList<>();
        etapesList.add(new CroixBlanche());
        etapesList.add(new DeuxiemeEtage());
        etapesList.add(new OrientationOfLastLayer());

        etapes=etapesList.iterator();
    }

    public void effectueEtapeSuivante() {
        EtapeResolution etape = etapes.next();
        etape.effectuerEtape(this.cube);
    }

    public boolean peutFaireEtapeSuivante() {
        return etapes.hasNext();
    }

    public void resolution() {
        while(this.peutFaireEtapeSuivante()) {
            this.effectueEtapeSuivante();
        }
    }

}
