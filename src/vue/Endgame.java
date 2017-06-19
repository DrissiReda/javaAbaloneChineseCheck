package vue;

/**
 * Created by root on 19/06/17.
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Endgame extends JPanel {

    /**
     * Create the panel.
     */
    private JPanel contentPane;
    private JTextField txt2;
    private JTextField txt_1;
    private boolean victoire;
    private int score_j1;
    private int score_j2;
    private String pseudo;

    public Endgame() {
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Winner");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblNewLabel.setForeground(new Color(0, 102, 153));
        lblNewLabel.setBounds(167, 11, 128, 55);
        contentPane.add(lblNewLabel);

        JLabel lblNomJoueur = new JLabel("Nom Joueur");
        lblNomJoueur.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNomJoueur.setBounds(80, 89, 120, 21);
        contentPane.add(lblNomJoueur);

        txt2 = new JTextField();
        txt2.setBounds(80, 121, 152, 49);
        contentPane.add(txt2);
        txt2.setColumns(10);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("score/1497916023_number_1_blue.png"));
        label.setBounds(10, 115, 60, 55);
        contentPane.add(label);

        txt_1 = new JTextField();
        txt_1.setBounds(242, 121, 120, 49);
        contentPane.add(txt_1);
        txt_1.setColumns(10);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("score/1497916271_cup.png"));
        label_1.setBounds(193, 186, 71, 64);
        contentPane.add(label_1);

        JLabel lblPoints = new JLabel("Points");
        lblPoints.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblPoints.setBounds(242, 89, 97, 21);
        contentPane.add(lblPoints);

        JLabel label_4 = new JLabel("");
        label_4.setIcon(new ImageIcon("score/1497916196_number_2_blue.png"));
        label_4.setBounds(10, 186, 36, 30);
        contentPane.add(label_4);
    }

    public boolean affiche(int score_j1, int score_j2, boolean victoire, String pseudo) {
        victoire = true;
        score_j1 = 100;
        score_j2 = 50;
        if (score_j1 > score_j2) {
            String strI = "" + score_j1;
            txt_1.setText(strI);
            txt2.setText(pseudo);
            return victoire;
        } else if (score_j2 > score_j1) {
            String strI = "" + score_j2;
            txt_1.setText(strI);
            txt2.setText(pseudo);
            return victoire;
        } else
            return false;
    }
}

