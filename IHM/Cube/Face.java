package IHM.Cube;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class Face{

	String valeur; // U,L,R,D,B,F
	String voisins;
	Queue<Face> queue;

	public Face(String valeur, String voisins) {
		this.valeur = valeur;
		this.voisins = voisins;
	}

	public void defQueue(HashMap<String, Face> faces) {
		queue = new LinkedList<Face>();
		for (int i=0;i<voisins.length();i++)
			queue.add(faces.get(voisins.charAt(i)));
	}
}
