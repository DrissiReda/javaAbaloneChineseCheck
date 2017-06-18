package vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.BoardDC;
import modele.Config;
import modele.Config.Color;
import modele.Coords;

public class PanneauDC extends JPanel{
	
	private BoardDC boardView = new BoardDC();
	private ArrayList<Coords> listTargets = new ArrayList<Coords>();
	private int tabTargets[][] = new int[19][27];
	
	private Coords[] tabPieces = new Coords[3];
	private Coords marble = new Coords(0,0);
	private Coords target = new Coords(0,0);
	
	private ArrayList<Color> players = new ArrayList<>();
	
	private Config.Direction direction = null;
	
	private ArrayList<Config.Direction> tabDirections = new ArrayList<Config.Direction>();
	
	// Elements graphiques
	private JLabel joueur1;
	
	public void paintComponent(Graphics g) {
		
		addImage(g, "Images/dames/Board.png", 0, 0, this);
		 
        int widthOffset = 0;
        int heightOffset = 152;
        int limX = 0;

        for (int i = 1; i < boardView.getHeight(); i++) {
            for (int j = 0; j < boardView.getWidth(); j++) {
            	
            	limX = 102 + j*15;

                if (boardView.getCase(new Coords(i, j)) == Config.Color.BLACK) {
                	addImage(g, "Images/dames/BallDameBrown.png", limX, heightOffset, this);
                } else if (boardView.getCase(new Coords(i, j)) == Config.Color.WHITE) {
                	addImage(g, "Images/dames/BallDameViolet.png", limX, heightOffset, this);
                }
	            else if (boardView.getCase(new Coords(i, j)) == Config.Color.YELLOW) {
	            	addImage(g, "Images/dames/BallDameYellow.png", limX, heightOffset, this);
                }
	            else if (boardView.getCase(new Coords(i, j)) == Config.Color.BLUE) {
	            	addImage(g, "Images/dames/BallDameBlue.png", limX, heightOffset, this);
                }
	            else if (boardView.getCase(new Coords(i, j)) == Config.Color.RED) {
	            	addImage(g, "Images/dames/BallDameRed.png", limX, heightOffset, this);
                }
	            else if (boardView.getCase(new Coords(i, j)) == Config.Color.GREEN) {
	            	addImage(g, "Images/dames/BallDameGreen.png", limX, heightOffset, this);
	            }
	            else{ // Affichage des directions possibles
	    	        for(Coords tar : listTargets){
	    	        	if(tar.x == i && tar.y == j)
	    	        		addImage(g, "Images/dames/target.png", limX+2, heightOffset+1, this);
	    	        }
            	}
                if(marble.x == i && marble.y == j){
                	addImage(g, "Images/dames/BallDameSelec.png", limX, heightOffset, this);
                }
            }
            heightOffset += 22;
        }
	}
	
    public void copyTab(BoardDC b) {
        this.boardView = b;
    }
    
    Coords[] getTabPieces() {
        return boardView.getTabPieces();
    }
    
    // Pour simplifier l'écriture
    public void addImage(Graphics g, String path, int x, int y, ImageObserver observer){
    	try {
            Image img = ImageIO.read(new File(path));
            g.drawImage(img, x, y, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void click(MouseEvent e) {
    	
    	int widthOffset = 0;
    	int heightOffset = 185;
        int limX;
    	System.out.println("Click: x = "+e.getX()+" y = "+e.getY());
    	//Clic on balls
        for (int i = 1; i < boardView.getHeight(); i++) {
            for (int j = 0; j < boardView.getWidth(); j++) {
                limX = 105 + (j * 15) - widthOffset;
                if ((e.getX() > limX) && (e.getX() < limX + 20) && (e.getY() > heightOffset) && (e.getY() < heightOffset + 20) && (((j % 2 != 0) && (i % 2 != 0)) || ((j % 2 == 0) && (i % 2 == 0)))) {
                    if(marble.x == i && marble.y == j)
                    	reset();
                    else{
                    	for(Coords tar : listTargets){
    	    	        	if(tar.x == i && tar.y == j)
    	    	        		clickMove(new Coords(i, j));
    	    	        }
	                	if (boardView.selectMarble(new Coords(i,j), "sss")) {
	                    	clickSelec(new Coords(i, j));
	                    }
	                	/*else
	                		reset();*/
                    } 
                }
            }
            heightOffset = heightOffset + 22;
        }
        
        repaint();
    }
    
    public boolean moveOk(){
    	if(direction != null)
    		return true;
    	else
    		return false;
    }

    public void clickMove(Coords destination)
    {
    	target = destination;
    	direction = boardView.find_direction(marble, destination); // On détecte la direction
    	System.out.println("Target : "+target);
    	System.out.println("Direction : "+direction);
    }
    
    public Coords getTarget(){
    	return this.target;
    }
    
    public Coords getMarble(){
    	return this.marble;
    }
    
    public Config.Direction getDirection(){
    	return this.direction;
    }
    
    public void refreshBoard(){
        repaint();
    }

    public void clickSelec(Coords marble)
    {
    	this.marble = marble;
    	listTargets = boardView.generateTarget(this.marble);
    	System.out.println("Click de sélection");
    }
    
    public void reset(){
    	this.boardView.cancelSelection();
    	this.listTargets.clear();
    	this.marble = new Coords(0,0);
    	this.target = null;
    	this.direction = null;
    }
    
    public void displayPlayers(int nbPlayers, ArrayList <String> pseudos, ArrayList <Config.Color> colors){
    	setLayout(null);
    	ArrayList <JLabel> listPlayers = new ArrayList <JLabel>();
    	int i = 0;
    	
    	for(String pseudo : pseudos)
    		listPlayers.add(new JLabel(pseudo));

    	int height = 235;
    	for(JLabel player : listPlayers){
    		player.setBounds(750, height, 170, 50);
    		player.setFont(new Font("Arial", Font.BOLD, 20));
    		add(player);
    		height += 50;
    	}
    }
    	
    	
    	/*
    	joueur1 = new JLabel("Joueur");
    	setLayout(null);
    	joueur1.setBounds(730, 250, 1000, 600);
    	joueur1.setFont(new Font("Synchro LET", Font.BOLD, 20));
    	add(joueur1);
    	*/

    public void affichePlateau()
	{
		for (int i = 0; i < boardView.getHeight(); i++){
			for(int j = 0; j < boardView.getWidth(); j++){
				if(boardView.getCase(new Coords(i, j)) == Config.Color.ILLEGAL)
    				System.out.print(" ");
    			else if(boardView.getCase(new Coords(i, j)) == Config.Color.EMPTY)
    				System.out.print(".");
    			else if(boardView.getCase(new Coords(i, j)) == Config.Color.BLACK)
    				System.out.print("N");
    			else if(boardView.getCase(new Coords(i, j)) == Config.Color.WHITE)
    				System.out.print("W");
    			else if(boardView.getCase(new Coords(i, j)) == Config.Color.RED)
    				System.out.print("R");
    			else if(boardView.getCase(new Coords(i, j)) == Config.Color.GREEN)
    				System.out.print("G");
    			else if(boardView.getCase(new Coords(i, j)) == Config.Color.BLUE)
    				System.out.print("B");
    			else if(boardView.getCase(new Coords(i, j)) == Config.Color.YELLOW)
    				System.out.print("Y");
    		}
    		System.out.println("");
		}
	}

}
