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


    public void refreshBoard(){
        pan.refreshBoard();
    }

    public void copyTab(Board b){
        pan.copyTab((BoardAbalone)b);
    }

    public void setMarbleLeftBlack(int marbleLeftBlack) {
        pan.setMarbleLeftBlack(marbleLeftBlack);
    }

    public void setMarbleLeftWhite(int marbleLeftWhite) {
        pan.setMarbleLeftWhite(marbleLeftWhite);
    }

    public int getConfirmValidation() {
        return pan.getConfirmValidation();
    }

    public int getConfirmDirection() {
        return pan.getConfirmDirection();
    }

    public void reInit(){
        pan.reInit();
    }

    public void moveIntoTabPieces(){
        pan.moveIntoTabPieces();
    }

    public Coords[] getTabPieces() {
        return pan.getTabPieces();
    }
}