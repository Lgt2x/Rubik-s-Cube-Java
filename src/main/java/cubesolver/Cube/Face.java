package cubesolver.Cube;

/**
 * Classe correspondant à une face avec 9 facelettes, avec une orientation fixe
 */
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
			int index = voisins.indexOf(face);

			if (index == 0) {
				return voisins.charAt(3);
			} else {
				return voisins.charAt((index-1));
			}
		}
	}
}
