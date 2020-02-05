public class Cube{



	Angle UFL = new Angle(new Facelette(0), new Facelette(1), new Facelette(2), 0);
	Angle UBL = new Angle(new Facelette(0), new Facelette(2), new Facelette(3), 0);
	Angle UBR = new Angle(new Facelette(0), new Facelette(3), new Facelette(4), 0);
	Angle UFR = new Angle(new Facelette(0), new Facelette(4), new Facelette(1), 0);

	Angle DFR = new Angle(new Facelette(5), new Facelette(0), new Facelette(4), 5);
	Angle DBR = new Angle(new Facelette(5), new Facelette(4), new Facelette(3), 5);
	Angle DBL = new Angle(new Facelette(5), new Facelette(3), new Facelette(2), 5);
	Angle DFL = new Angle(new Facelette(5), new Facelette(2), new Facelette(1), 5);


	Arete UF = new Arete(new Facelette(0), new Facelette(1), 0);
	Arete UL = new Arete(new Facelette(0), new Facelette(2), 0);
	Arete UB = new Arete(new Facelette(0), new Facelette(3), 0);
	Arete UR = new Arete(new Facelette(0), new Facelette(4), 0);

	Arete FR = new Arete(new Facelette(1), new Facelette(4), 1);
	Arete FL = new Arete(new Facelette(1), new Facelette(2), 1);
	Arete BL = new Arete(new Facelette(3), new Facelette(2), 3);
	Arete BR = new Arete(new Facelette(3), new Facelette(4), 3);

	Arete DR = new Arete(new Facelette(5), new Facelette(4), 5);
	Arete DF = new Arete(new Facelette(5), new Facelette(1), 5);
	Arete DL = new Arete(new Facelette(5), new Facelette(2), 5);
	Arete DB = new Arete(new Facelette(5), new Facelette(3), 5);

	Angle[] angles = {UFL, UBL, UBR, UFR, DFR, DBR, DBL, DFL};
	Arete[] aretes = {UF, UL, UB, UR, FR, FL, BL, BR, DR, DF, DL, DB};

	public Cube(){ //methode à completer avec l'etat actuel du cube récupéré sur l'affichage graphique
	}


}
