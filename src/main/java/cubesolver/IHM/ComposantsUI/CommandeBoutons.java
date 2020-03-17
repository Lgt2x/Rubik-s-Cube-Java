package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.ComposantsUI.BoutonsLecture.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandeBoutons extends JPanel {

    public CommandeBoutons() {
        this.setLayout(null);
        this.setBounds(925, 10, 500, 75);

        this.add(new BoutonReculerEtape(0, 0, 100, 75));
        this.add(new BoutonReculerMouvement(100, 0, 100, 75));
        this.add(new BoutonFinir(400, 0, 100, 75));
        this.add(new BoutonAvancerMouvement(200, 0, 100, 75));
        this.add(new BoutonAvancerEtape(300, 0, 100, 75));

    }
}