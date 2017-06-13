package vue;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Board;
import modele.BoardAbalone;
import modele.Config;
import modele.Coords;

public class Panneau extends JPanel implements MouseListener {


    private int marbleLeftBlack = 14;
    private int marbleLeftWhite = 14;

    BoardAbalone boardView = new BoardAbalone();
    int tabSelec[][] = new int[11][19];

    int initParam=1;
    int confirmValidation=0;
    int confirmDirection=0;

    int etatBoutonValidation=0;

    JLabel scoreB = new JLabel("restants : "+marbleLeftBlack);
    JLabel scoreW = new JLabel("restants : "+marbleLeftWhite);
    JLabel validButtonDown = new JLabel(new ImageIcon("Images/ValidDown.png"));
    JLabel validButtonUp = new JLabel(new ImageIcon("Images/ValidUp.png"));



    public void paintComponent(Graphics g) {

        //Initialisation
        if(initParam==1){
            //souris
            this.addMouseListener(this);


            setLayout(null);
            scoreB.setFont(new Font("Synchro LET", Font.BOLD, 20));
            scoreW.setFont(new Font("Synchro LET", Font.BOLD, 20));
            scoreB.setForeground(new Color(0xE97628));
            scoreW.setForeground(new Color(0x5ABEB1));

            scoreB.setBounds(730, 450, 170, 50);
            scoreW.setBounds(730, 487, 170, 50);
            add(scoreB);
            add(scoreW);

            validButtonDown.setBounds(530, 140, 170, 50);
            validButtonUp.setBounds(530, 140, 170, 50);

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
            if(boardView.player == Config.Color.BLACK) {
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
        add(validButtonDown);
        add(validButtonUp);
        if(this.etatBoutonValidation==0){
            validButtonDown.setVisible(true);
            validButtonUp.setVisible(false);
        }
        else{
            validButtonDown.setVisible(false);
            validButtonUp.setVisible(true);
        }

        //Mets à jour les "Boules restants
        scoreB.setText("restants : "+marbleLeftBlack);
        scoreW.setText("restants : "+marbleLeftWhite);

        int widthOffset = 0;
        int heightOffset = 153;
        int limX;

        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                limX=103 + (j * 20) - widthOffset;
                if (boardView.getCase(new Coords(i, j)) == Config.Color.BLACK) {
                    try {
                        Image img = ImageIO.read(new File("Images/Borange.png"));
                        g.drawImage(img, limX, heightOffset, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (boardView.getCase(new Coords(i, j)) == Config.Color.WHITE) {
                    try {
                        Image img = ImageIO.read(new File("Images/Bbleu.png"));
                        g.drawImage(img, limX, heightOffset, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (tabSelec[i][j] == 1) { //Show ring selection
                    try {
                        Image imgSelec = ImageIO.read(new File("Images/SelectionBall.png"));
                        g.drawImage(imgSelec, limX-4, heightOffset-5, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            heightOffset = heightOffset + 40;
        }

    }

    public void copyTab(BoardAbalone b) {
        this.boardView = b;
    }

    public void refreshBoard(){
        repaint();
    }

    public void setMarbleLeftBlack(int marbleLeftBlack) {
        this.marbleLeftBlack = marbleLeftBlack;
    }

    public void setMarbleLeftWhite(int marbleLeftWhite) {
        this.marbleLeftWhite = marbleLeftWhite;
    }

    public int getConfirmValidation() {
        return confirmValidation;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Click: x= "+e.getX()+" y = "+e.getY());

        int widthOffset = 0;
        int heightOffset = 153;
        int limX;

        //Clic on validation button
        if((e.getX()>530) && (e.getX()<530+170) && (e.getY()>140) && (e.getY()<140+50)){
            this.confirmValidation=1;
            System.out.println("GROSSE");
            this.etatBoutonValidation=0;
        }

        //Clic on balls
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                limX=103 + (j * 20) - widthOffset;
                if ((e.getX()>limX) && (e.getX()<limX+20) && (e.getY()>heightOffset) && (e.getY()<heightOffset+40) && (((j%2!=0)&&(i%2!=0))||((j%2==0)&&(i%2==0)))){
                    if(boardView.selectMarble(new Coords(i,j))){
                        tabSelec[i][j]=1;
                        this.etatBoutonValidation=1;
                        System.out.println("ETAT CHANG2"+this.etatBoutonValidation);
                    }
                }
            }
            heightOffset = heightOffset + 40;
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stu
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void reInit(){
        boardView.initTabPieces();
        this.confirmValidation=0;
        this.confirmDirection=0;
        this.etatBoutonValidation=0;
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                this.tabSelec[i][j]=0;
            }
        }
    }

   // public  getTabPieces(){

    //}

}