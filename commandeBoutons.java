import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class commandeBoutons extends JPanel {
    //Déclaration de chaque bouton
    private JButton pause  = new JButton(new ImageIcon("play2.png"));
    private JButton avancer = new JButton(new ImageIcon("avancer.png"));
    private JButton arriere  = new JButton(new ImageIcon("arriere.png"));
    private Color maCouleur = new Color(48, 48, 48);


    public  commandeBoutons(){
        this.setLayout(null);
        this.setBounds(1025, 10, 300, 75);
        this.setBackground(maCouleur);

        //Placement boutons
        arriere.setBounds(0, 0, 100, 75);
        pause.setBounds(100, 0, 100, 75);
        avancer.setBounds(200, 0, 100, 75);

        //Couleurs et Bordures
        arriere.setBackground(maCouleur);
        pause.setBackground(maCouleur);
        avancer.setBackground(maCouleur);

        arriere.setBorder(BorderFactory.createLineBorder(Color.white));
        pause.setBorder(BorderFactory.createLineBorder(Color.white));
        avancer.setBorder(BorderFactory.createLineBorder(Color.white));

        this.add(arriere); this.add(avancer); this.add(pause);



    }
}