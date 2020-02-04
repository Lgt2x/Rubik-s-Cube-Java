import java.awt.*;
import javax.swing.*;

public class fenetre extends JFrame{

    private AffichageCube affichageCube;

    public fenetre(){

        //initialisation de la fenetre
        this.setTitle("solver de rubik's cube");
        this.setSize(1500,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        JPanel panneauPrincipal = new JPanel();
        panneauPrincipal.setLayout(null);
        affichageCube = new AffichageCube();
        panneauPrincipal.add(affichageCube);
        this.setContentPane(panneauPrincipal);
        this.setVisible(true);
    }



}