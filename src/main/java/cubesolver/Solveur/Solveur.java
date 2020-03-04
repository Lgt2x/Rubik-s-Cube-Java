package cubesolver.Solveur;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.Etapes.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Solveur {
    public Cube cube;
    private Iterator<EtapeResolution> etapes;

    public Solveur(Cube cube) {
        this.cube = cube;
        LinkedList<EtapeResolution> etapesList = new LinkedList<>();

        etapesList.add(new CroixBlanche());
        etapesList.add(new AnglesBlancs());
        etapesList.add(new DeuxiemeEtage());
        etapesList.add(new CroixJaune());
        etapesList.add(new OrientationOfLastLayer());
        etapesList.add(new PositionOfLastLayer());

        etapes=etapesList.iterator();
    }

    public ArrayList<Character> effectueEtapeSuivante() {
        EtapeResolution etape = etapes.next();
        return etape.effectuerEtape(this.cube);
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
