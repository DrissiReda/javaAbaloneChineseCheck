package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import modele.BoardAbalone;
import modele.BoardDC;
import modele.Config;
import modele.Coords;
import modele.Config.Color;

public class PanneauDC extends JPanel{
	
	private BoardDC boardView = new BoardDC();
	private ArrayList<Coords> listTargets = new ArrayList<Coords>();
	private int tabTargets[][] = new int[19][27];
	
	private Coords[] tabPieces = new Coords[3];
	private Coords marble = new Coords(0,0);
	
	private ArrayList<Color> players = new ArrayList<>();
	
	private Config.Direction direction = null;
	
	private ArrayList<Config.Direction> tabDirections = new ArrayList<Config.Direction>();
	
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
	    	        	if(tar.x == i && tar.y == j){
	    	        		try {
		                        Image img = ImageIO.read(new File("Images/dames/target.png"));
		                        g.drawImage(img, limX+2, heightOffset+1, this);
		                    } catch (IOException e) {
		                        e.printStackTrace();
		                    }
	    	        	}
	    	        }
            	}
                if(marble.x == i && marble.y == j){
                	try {
                        Image imgSelec = ImageIO.read(new File("Images/dames/BallDameSelec.png"));
                        g.drawImage(imgSelec, limX, heightOffset, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            heightOffset += 22;
        }
	}
	
    public void copyTab(BoardDC b) {
        this.boardView = b;
    }
    
    public void deselect(){
    	boardView.cancelSelection();
    	listTargets.clear();
    	marble = new Coords(0,0);
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
    	System.out.println("Click: x= "+e.getX()+" y = "+e.getY());
    	//Clic on balls
        for (int i = 1; i < boardView.getHeight(); i++) {
            for (int j = 0; j < boardView.getWidth(); j++) {
                limX = 105 + (j * 15) - widthOffset;
                if ((e.getX() > limX) && (e.getX() < limX + 20) && (e.getY() > heightOffset) && (e.getY() < heightOffset + 20) && (((j % 2 != 0) && (i % 2 != 0)) || ((j % 2 == 0) && (i % 2 == 0)))) {
                    if (boardView.selectMarble(new Coords(i,j), "sss")) {
                    	marble = new Coords(i, j);
                        listTargets = boardView.generateTarget(marble);
                    }else{
                    	deselect();
                    }
                }
            }
            heightOffset = heightOffset + 22;
        }
        
        repaint();
    }
    
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
