package cubesolver.Solveur;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.Etapes.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Solveur {
    private static Iterator<EtapeResolution> etapes;
    public static LinkedList<EtapeResolution> etapesList;

    public Solveur() {
        etapesList = new LinkedList<>();

        etapesList.add(new CroixBlanche());
        etapesList.add(new AnglesBlancs());
        etapesList.add(new DeuxiemeEtage());
        etapesList.add(new OrientationOfLastLayer());
        etapesList.add(new PositionOfLastLayer());

        etapes=etapesList.iterator();
    }

    public static String[] resolution() {
        String[] solution = new String[etapesList.size()];
        int compteurEtape = 0;
        while(etapes.hasNext()) {
            solution[compteurEtape] = etapes.next().effectuerEtape();
            compteurEtape++;
        }

        return solution;
    }

}
