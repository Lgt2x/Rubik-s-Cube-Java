public class Angle{
	Facelette facelette1; //composition d'un angle
	Facelette facelette2;
	Facelette facelette3;
	int orientation;     // position de la première facelette allant de 0 à 5

	public Angle(Facelette facelette1, Facelette facelette2, Facelette facelette3, int orientation) {
		this.facelette1 = facelette1;
		this.facelette2 = facelette2;
		this.facelette3 = facelette3;
		this.orientation = orientation;
	}
}


