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

	public char color;
	public char face;

	public Facelette(char color,char face) {
		this.color = color;
		this.face = face;
	}
}
