package vue;
import javax.swing.*;
import modele.*;
import java.awt.*;

public class Fenetre extends JFrame {

    private Panneau pan = new Panneau();


    public Fenetre(){
        this.setTitle("ABALONE");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.setContentPane(pan);


        this.setVisible(true);
    }


    public void updateTab(){
        pan.repaint();
    }

    public void copyTab(Board b){
        pan.copyTab(b);
    }

    public void setPlayer(Config.Color player) {
        pan.setPlayer(player);
    }





}