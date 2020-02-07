public class Facelette{
	/*on représente les couleurs d'un cube avec leurs faces associées comme il suit:
	UP/blanc : 0
	FRONT/bleu : 1
	LEFT/rouge : 2
	BACK/vert : 3
	LEFT/orange : 4
	DOWN/jaune : 5

	 */
	int color;
	int face;
	public Facelette(int color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Facelette{" +
				"color=" + color +
				'}';
	}

	public int getFace() {
		return face;
	}

	public void setFace(int face) {
		this.face = face;
	}
}
