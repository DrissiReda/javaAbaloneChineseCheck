package vue;
import modele.Board;
import modele.BoardAbalone;
import modele.Coords;
import modele.Tile;
import modele.Config.Color;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

public class Fenetre extends JFrame {

    private Panneau pan;


    public Fenetre() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException{
    	
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
    
    
    
    // FONCTIONS SAUVEGARDE/CHARGEMENT DE PARTIE
	public void saveAbalone(int scoreJ1, int scoreJ2, int nbPlayers, int playerRound, Tile GameBoard[][])
	{
		

    		try{
    		    PrintWriter writer = new PrintWriter("C:\\Users\\Mokhtar\\Desktop\\savegames\\"+"NOM DU JOUEUR"+".Abalone", "UTF-8");
    		    writer.println(scoreJ1);
    		    writer.println(scoreJ2);
    		    writer.println(nbPlayers);
    		    writer.println(playerRound);
    		   
    		    String line="";
    		    
    		    for(int i=0;i<11;i++)
    		    {
    		    	for(int j=0;j<18;j++)
    		    	{
    		    		line=line+" "+GameBoard[i][j].getColor();
    		    	}
    		    	
		    		writer.println(line);
		    		line="";
    		    }
    		    
    		    writer.close();
    		} 
    		
    		catch (IOException e) 
    		{
    		   // do something
    		}
	}
	
	
	public void saveDamesChinoises(int scoreJ1, int scoreJ2, int nbPlayers, int playerRound, Tile GameBoard[][])
	{
    		try{
    		    PrintWriter writer = new PrintWriter("C:\\Users\\Mokhtar\\Desktop\\savegames\\"+"NOM DU JOUEUR"+".Dames chinoises", "UTF-8");
    		    writer.println(scoreJ1);
    		    writer.println(scoreJ2);
    		    writer.println(nbPlayers);
    		    writer.println(playerRound);
    		   
    		    String line="";
    		    
    		    for(int i=0;i<19;i++)
    		    {
    		    	for(int j=0;j<27;j++)
    		    	{
    		    		line=line+" "+GameBoard[i][j].getColor();
    		    	}
    		    	
		    		writer.println(line);
		    		line="";
    		    }
    		    
    		    writer.close();
    		} 
    		
    		catch (IOException e) 
    		{
    		   // do something
    		}
	}
	
	
	
	public void loadGame(String playerName, String game) throws IOException
	{
    		
		String line;
        BufferedReader in;

        in = new BufferedReader(new FileReader("C:\\Users\\Mokhtar\\Desktop\\savegames\\"+playerName+"."+game));
        line = in.readLine();

        while(line != null)
        {
               System.out.println(line);
               line = in.readLine();
        }

        System.out.println(line);
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