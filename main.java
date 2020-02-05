import IHM.GestionAffichage;

public class main{
    public static void main(String []args){
        GestionAffichage visualisation = new GestionAffichage();

        Cube cube = new Cube();
        Mouvements m = new Mouvements();
        m.UP(cube);
    }
}