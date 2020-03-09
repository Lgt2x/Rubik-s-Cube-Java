package cubesolver.Solveur;

import cubesolver.Solveur.Etapes.*;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * Classe maîtresse pour la résolution du cube,
 * qui appelle les différentes étape pendant la résolution
 */
public class Solveur {
    private static Iterator<EtapeResolution> etapes;
    private static LinkedList<EtapeResolution> etapesList;

    public Solveur() {
        etapesList = new LinkedList<>();

        // Ajout des différentes étapes de résolution
        etapesList.add(new CroixBlanche());
        etapesList.add(new AnglesBlancs());
        etapesList.add(new DeuxiemeEtage());
        etapesList.add(new OrientationOfLastLayer());
        etapesList.add(new PositionOfLastLayer());

        etapes=etapesList.iterator();
    }

    /**
     * Méthode principale appelée pour la résolution,
     * qui retourne un tableau représentant les mouvements nécessaire à la résolution
     * Attention : le cube est résolu à la fin de la méthode
     * @return
     */
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
