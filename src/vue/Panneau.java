package vue;
import modele.Board;
import modele.Config;
import modele.Coords;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Panneau extends JPanel {

    int marbleLeftBlack = 14;
    int marbleLeftWhite = 14;

    Config.Color player = Config.Color.BLACK;

    Board boardView = new Board();

    int initParam=1;

    JLabel scoreB = new JLabel("restants : "+marbleLeftBlack);
    JLabel scoreW = new JLabel("restants : "+marbleLeftWhite);
    JLabel validButton = new JLabel(new ImageIcon("Images/ValidDown.png"));



    public void paintComponent(Graphics g) {

        //Initialisation
        if(initParam==1){
            setLayout(null);
            scoreB.setFont(new Font("Synchro LET", Font.BOLD, 20));
            scoreW.setFont(new Font("Synchro LET", Font.BOLD, 20));
            scoreB.setForeground(new Color(0xE97628));
            scoreW.setForeground(new Color(0x5ABEB1));

            scoreB.setBounds(730, 450, 170, 50);
            scoreW.setBounds(730, 487, 170, 50);
            add(scoreB);
            add(scoreW);

            validButton.setBounds(530, 140, 170, 50);

            //police
            try {
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Images/Synchro-LET-Plain.ttf")));
            } catch (IOException|FontFormatException e) {
                e.printStackTrace();
            }

            initParam=0;
        }

        //Affiche le fond
        try {
            if(player == Config.Color.BLACK) {
                Image img = ImageIO.read(new File("Images/AbaFondTourPBLACK.png"));
                g.drawImage(img, 0, 0, this);
            }
            else{
                Image img = ImageIO.read(new File("Images/AbaFondTourPWHITE.png"));
                g.drawImage(img, 0, 0, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //affiche boutonValider
        add(validButton);

        //Mets à jour les "Boules restants
        scoreB.setText("restants : "+marbleLeftBlack);
        scoreW.setText("restants : "+marbleLeftWhite);

        int widthOffset = 0;
        int heightOffset = 153;

        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                if (boardView.getCase(new Coords(i, j)) == Config.Color.BLACK) {
                    try {
                        Image img = ImageIO.read(new File("Images/Borange.png"));
                        g.drawImage(img, 103 + (j * 20) - widthOffset, heightOffset, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (boardView.getCase(new Coords(i, j)) == Config.Color.WHITE) {
                    try {
                        Image img = ImageIO.read(new File("Images/Bbleu.png"));
                        g.drawImage(img, 103 + ((j) * 20) - widthOffset, heightOffset, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            heightOffset = heightOffset + 40;
        }

    }

    public void copyTab(Board b) {
        this.boardView = b;
        repaint();
    }

    public void setPlayer(Config.Color player) {
        this.player = player;
    }

    public Coords SelectBall() {

        return null;
    }

    public void setMarbleLeftBlack(int marbleLeftBlack) {
        this.marbleLeftBlack = marbleLeftBlack;
    }

    public void setMarbleLeftWhite(int marbleLeftWhite) {
        this.marbleLeftWhite = marbleLeftWhite;
    }
}