package vue;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.*;

import modele.BoardDC;
import modele.Config;
import modele.Config.Color;
import modele.Coords;

public class PanneauDC extends JPanel{
	
	private BoardDC boardView = new BoardDC();
	private ArrayList<Coords> listTargets = new ArrayList<Coords>();
	private int tabTargets[][] = new int[19][27];

    private int initParam=1;
	
	private Coords[] tabPieces = new Coords[3];
	private Coords marble = new Coords(0,0);
	private Coords target = new Coords(0,0);
	
	private ArrayList<Color> players = new ArrayList<>();
	
	private Config.Direction direction = null;
	
	private ArrayList<Config.Direction> tabDirections = new ArrayList<Config.Direction>();

    JSlider slideDif = new JSlider(JSlider.VERTICAL, 1, 10, 1);
	
	// Elements graphiques
	private JLabel joueur1;
	
	public void paintComponent(Graphics g) {

        if(initParam==1){
            slideDif.setBounds(600,140,50,208);
            add(slideDif);
        }
		
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
						if (boardView.selectMarble(new Coords(i, j), boardView.getCurrentplayer())) {
							clickSelec(new Coords(i, j));
	                    }
	                	/*else
	                		reset();*/
                    } 
                }
            }
            heightOffset = heightOffset + 22;
        }

		for (int i = 0; i < 4; i++) {
			if ((e.getX() > 551) && (e.getX() < 551 + 110) && (e.getY() > 385+(i*43)) && (e.getY() < 385+(i*43) + 34)){
				switch (i){
					case 0: //SAUVER


						break;
					case 1: //CHARGER


						break;
					case 2: //MENU
						break;
					case 3: //A PROPOS
						break;
				}
			}
		}
        
        repaint();
    }
    
    public boolean moveOk(){
		return direction != null;
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
    	ArrayList<Color> listColors;
    	ArrayList <JLabel> listPlayers = new ArrayList <JLabel>();
    	int i = 0;

    	// Exclusion des doublons de pseudos dans distinctPseudos
        Set set = new HashSet() ;
        set.addAll(pseudos) ;
        ArrayList <String> distinctPseudos = new ArrayList<String>(set) ;
        Collections.reverse(distinctPseudos);
        // **************************
        
        
    	for(String pseudo : distinctPseudos)
    		listPlayers.add(new JLabel(pseudo));

    	int height = 235;
    	int x = 750;
    	int decal;
    	JLabel imgColor;
    	for(JLabel player : listPlayers){
    		decal = -70;
    		listColors = boardView.getColors(player.getText());
    		player.setBounds(x, height, 170, 50);
    		player.setFont(new Font("Arial", Font.BOLD, 20));
    		add(player);
    		for(Color color : listColors){
    			ImageIcon image = generateImage(color);
    			imgColor = new JLabel(image);
    			imgColor.setBounds(x+decal, height+30, 170, 50);
    			add(imgColor);
    			decal += 35;
    		}
    		height += 70;
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
    
    public ImageIcon generateImage(Color color){
    	switch(color){
		case BLACK :
			return new ImageIcon("Images/dames/BallDameBrown.png");
		case WHITE :
			return new ImageIcon("Images/dames/BallDameViolet.png");
		case GREEN :
			return new ImageIcon("Images/dames/BallDameGreen.png");
		case RED :
			return new ImageIcon("Images/dames/BallDameRed.png");
		case BLUE :
			return new ImageIcon("Images/dames/BallDameBlue.png");
		case YELLOW :
			return new ImageIcon("Images/dames/BallDameYellow.png");
    	default : return new ImageIcon("Images/dames/BallDameBrown.png");
    	}
    }
}
