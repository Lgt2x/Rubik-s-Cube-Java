package IHM.Cube;
import java.util.Queue;
import java.util.LinkedList;

public class Face{
	char valeur; // U,L,R,D,B,F
	Queue<Face> queue;

	public Face(char valeur) {
		this.valeur = valeur;
	}

	public void defQueue(Face f1,Face f2, Face f3, Face f4) {
		queue = new LinkedList<Face>();
		queue.add(f1);
		queue.add(f2);
		queue.add(f3);
		queue.add(f4);
	}
}
