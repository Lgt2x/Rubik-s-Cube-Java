package IHM.Cube;

public class Mouvements{



	public Mouvements(){
	}
/*
	public Cube UP(Cube cube){

		Arete aretes0 = cube.aretes[0];
		Arete aretes1 = cube.aretes[1];
		Arete aretes2 = cube.aretes[2];
		Arete aretes3 = cube.aretes[3];

		Angle angles0 = cube.angles[0];
		Angle angles1 = cube.angles[1];
		Angle angles2 = cube.angles[2];
		Angle angles3 = cube.angles[4];


		cube.aretes[0] = aretes3;
		cube.aretes[1] = aretes0;
		cube.aretes[2] = aretes1;
		cube.aretes[3] = aretes2;

		cube.angles[0] = angles3;
		cube.angles[1] = angles0;
		cube.angles[2] = angles1;
		cube.angles[3] = angles2;

		//Reorienter les pieces qui doivent l'etre
		for(int i = 0; i<3; i++){
			if (cube.angles[i].orientation != 0){
				cube.angles[i].orientation++;
				if(cube.angles[i].orientation == 5){
					cube.angles[i].orientation = 1;
				}
			}

			if (cube.aretes[i].orientation != 0){
				cube.aretes[i].orientation++;
				if(cube.aretes[i].orientation == 5){
					cube.aretes[i].orientation = 1;
				}
			}
		}
		return cube;
	}

	public Cube R(Cube cube){

		Arete aretes3 = cube.aretes[3];
		Arete aretes4 = cube.aretes[4];
		Arete aretes7 = cube.aretes[7];
		Arete aretes8 = cube.aretes[8];

		Angle angles2 = cube.angles[2];
		Angle angles3 = cube.angles[3];
		Angle angles4 = cube.angles[4];
		Angle angles5 = cube.angles[5];


		cube.aretes[3] = aretes4;
		cube.aretes[4] = aretes8;
		cube.aretes[7] = aretes3;
		cube.aretes[8] = aretes7;

		cube.angles[2] = angles3;
		cube.angles[3] = angles4;
		cube.angles[4] = angles5;
		cube.angles[5] = angles2;

		//Reorienter les pieces qui doivent l'etre
		for(int i = 0; i<3; i++){
			if (cube.angles[i].orientation != 0){
				cube.angles[i].orientation++;
				if(cube.angles[i].orientation == 5){
					cube.angles[i].orientation = 1;
				}
			}

			if (cube.aretes[i].orientation != 0){
				cube.aretes[i].orientation++;
				if(cube.aretes[i].orientation == 5){
					cube.aretes[i].orientation = 1;
				}
			}
		}
		return cube;

	}*/
}
