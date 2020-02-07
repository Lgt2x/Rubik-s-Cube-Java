package IHM.Cube;

public class Facelette{
	/*on représente les couleurs d'un cube avec leurs faces associées comme il suit:
	UP/jaune
	FRONT/bleu
	LEFT/orange
	BACK/vert
	LEFT/rouge
	DOWN/blang
	 */

	public int color;
	public Face face;

	public Facelette(int color, Face face) {
		this.color = color;
		this.face = face;
	}
}
