package cubesolver.Solveur;

import cubesolver.Solveur.Etapes.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * Classe maîtresse pour la résolution du cube,
 * qui appelle les différentes étape pendant la résolution
 */
public class Solveur {
    private static Iterator<EtapeResolution> etapes;
    public static LinkedList<EtapeResolution> etapesList;

    public Solveur() {
        reset();
    }

    /**
     * Méthode principale appelée pour la résolution,
     * qui retourne un tableau représentant les mouvements nécessaire à la résolution
     * Attention : le cube est résolu à la fin de la méthode
     * @return la formule de résolution, chaque élément du tableau est la formule pour l'étape suivante
     */
    public static String[] resolution() {
        ArrayList<String> solution = new ArrayList<>();

        while(etapes.hasNext()) {
            String formuleEtape = etapes.next().effectuerEtape();
            if (formuleEtape.length() > 0) {
                solution.add(formuleEtape);
            }
        }

        return solution.toArray(new String[solution.size()]);
    }

    /**
     * Remet à zéro le solveur pour une nouvelle utilisation
     */
    public static void reset() {
        etapesList = new LinkedList<>();

        // Ajout des différentes étapes de résolution
        etapesList.add(new CroixBlanche());
        etapesList.add(new AnglesBlancs());
        etapesList.add(new DeuxiemeEtage());
        etapesList.add(new OrientationOfLastLayer());
        etapesList.add(new PositionOfLastLayer());

        etapes=etapesList.iterator();
    }

}
