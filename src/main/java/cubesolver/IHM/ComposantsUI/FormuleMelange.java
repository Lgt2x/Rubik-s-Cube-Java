package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.Etat;

import javax.swing.*;
import java.awt.*;

import static cubesolver.IHM.GestionAffichage.*;
import static cubesolver.IHM.GestionAffichage.niemeMouv;

public class FormuleMelange extends JPanel implements Etat {
    private static JTextArea textMix;

    public FormuleMelange() {
        this.setLayout(null);
        this.setBounds(875, 540, 600, 100);
        this.setBackground(couleurBoutons);
        this.setBorder(BorderFactory.createLineBorder(Color.white));


        textMix = new JTextArea("abc", 2, 50);
        textMix.setBounds(0, 0, 600, 100);
        textMix.setEditable(false);
        textMix.setCursor(null);
        textMix.setFocusable(false);
        textMix.setOpaque(false);
        textMix.setLineWrap(true);
        textMix.setWrapStyleWord(true);
        textMix.setForeground(Color.white);
        textMix.setFont(new Font(Font.SERIF, Font.BOLD, 15));

        this.add(textMix);
    }

    public static void actualiseEtat() {
        textMix.setText(formuleMix);
    }
}
