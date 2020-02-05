import java.awt.*;
import javax.swing.*;

public class fenetre extends JFrame{

    private AffichageCube affichageCube;
    private commandeBoutons panneauBouton ;
    private Color maCouleur = new Color(48, 48, 48);

    public fenetre(){

        //initialisation de la fenetre
        this.setTitle("Solver de rubik's cube");
        this.setSize(1500,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        JPanel panneauPrincipal = new JPanel();
        panneauPrincipal.setLayout(null);
        panneauPrincipal.setBounds(0,0, getWidth(), getHeight());
        panneauPrincipal.setBackground(maCouleur);
        affichageCube = new AffichageCube();
        panneauBouton = new commandeBoutons();
        panneauPrincipal.add(affichageCube); panneauPrincipal.add(panneauBouton);

        this.setContentPane(panneauPrincipal);
        this.setVisible(true);
    }



}