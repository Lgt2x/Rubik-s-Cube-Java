package IHM.Cube;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class Face{

	final char valeur; // U,L,R,D,B,F
	String voisins;

	public Face(char valeur, String voisins) {
		this.valeur = valeur;
		this.voisins = voisins;
	}

	/**
	 * Retourne la face d'après selon la direction donnée par rapport à la face courante
	 * @param face la face dont on veut la suivante
	 * @param direction True si positif, False si négatif
	 * @return la face suivante
	 */
	public char faceSuivante(char face, boolean direction) {
		if (direction) {
			return voisins.charAt(voisins.indexOf(face)+1);
		} else {
			int index = voisins.charAt((voisins.indexOf(face)));
			if (index == 0) {
				return voisins.charAt(3);
			} else {
				return voisins.charAt(index-1);
			}
		}
	}

	/*public int[][] exportFace(){
		int[][] faceExporte = new int[3][3];
		faceExporte[1][1] = correspondance(this.valeur);

		return faceExporte;
	}*/



}
