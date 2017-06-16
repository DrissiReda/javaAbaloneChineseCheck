package vue;
import modele.Board;
import modele.BoardAbalone;
import modele.Coords;

import javax.swing.*;

public class Fenetre extends JFrame {

    private Panneau pan;


    public Fenetre() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
    	
    	UIManager.setLookAndFeel(
				UIManager.getSystemLookAndFeelClassName());
        this.setTitle("ABALONE");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
       // this.setContentPane(pan);
        this.setVisible(true);
        
        
        launch_interface();
    }

    // Fonctions interfaces principales
    
    public void launch_interface()
	{
		Panneau panel1 = new Panneau();
		panel1.setBounds(0,0,1000,600);
		this.getContentPane().add(panel1);		
	}
    
    // Fonctions Abalone
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

    public int getConfirmDirection() {
        return pan.getConfirmDirection();
    }

    public void reInit(){
        pan.reInit();
    }

    public Coords[] getTabPieces() {
        return pan.getTabPieces();
    }
}