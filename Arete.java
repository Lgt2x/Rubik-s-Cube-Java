public class Arete{

	Facelette facelette1; //composition d'une arete
	Facelette facelette2;
	int orientation;     // position de la première facelette allant de 0 à 5

	public Arete(Facelette facelette1, Facelette facelette2, int orientation) {
		this.facelette1 = facelette1;
		this.facelette2 = facelette2;
		this.orientation = orientation;
	}


}
