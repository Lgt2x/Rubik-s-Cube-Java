package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.Etat;

import javax.swing.*;

import java.awt.*;

import static cubesolver.IHM.GestionAffichage.*;

public class FormuleSolution extends JPanel implements Etat {
    private static JTextArea text;

    public FormuleSolution() {
        this.setLayout(null);
        this.setBounds(875, 430, 600, 100);
        this.setBackground(couleurBoutons);
        this.setBorder(BorderFactory.createLineBorder(Color.white));


        text = new JTextArea("abc", 2, 50);
        text.setBounds(0, 0, 600, 100);
        text.setEditable(false);
        text.setCursor(null);
        text.setFocusable(false);
        text.setOpaque(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setForeground(Color.white);
        text.setFont(new java.awt.Font(Font.SERIF, Font.BOLD,15));

        this.add(text);
    }

    public static void actualiseEtat() {
        if (getEtat().equals("resolution")) {
            text.setText(formuleResolutionComplet.substring(0, niemeMouv));
        } else
            text.setText("");
    }
}
