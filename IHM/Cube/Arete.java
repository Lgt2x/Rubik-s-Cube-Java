package IHM.Cube;

public class Arete extends Piece {

	//instancier les pièces dans leur position initiale
	public Arete (String name) {
		this.facelette = new Facelette[2];
		for(int i = 0; i < 2; i++) {
			this.facelette[i] = new Facelette(name.charAt(i),name.charAt(i));
		}
	}
}
