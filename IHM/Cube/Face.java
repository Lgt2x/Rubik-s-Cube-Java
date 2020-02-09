package IHM.Cube;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class Face{

	char valeur; // U,L,R,D,B,F
	//String voisins;
	LinkedList<Character> queue;

	public Face(char valeur, String voisins) {
		this.valeur = valeur;

		queue = new LinkedList<Character>();
		for (int i=0;i<voisins.length();i++)
			queue.add(voisins.charAt(i));
	}



	//

	/*public void defQueue(HashMap<String, Face> faces) {
		queue = new LinkedList<Face>();
		for (int i=0;i<voisins.length();i++)
			queue.add(faces.get(voisins.charAt(i)));
	}*/
}
