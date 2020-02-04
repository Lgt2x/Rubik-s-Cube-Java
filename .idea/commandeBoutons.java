import javax.swing.*;

public class commandeBoutons extends JPanel {

        private JButton melange = new JButton("Mélanger");
        private JButton solve = new JButton("Résoudre");
        private JButton pause  = new JButton(new ImageIcon("/images/play.svg"));
        private JButton avancer = new JButton(new ImageIcon("/images/avancer.svg"));
        private JButton arriere  = new JButton(new ImageIcon("/images/arriere.svg"));

        public  commandeBoutons(){
        }
}