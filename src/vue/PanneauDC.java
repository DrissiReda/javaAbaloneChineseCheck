package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
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
	private Coords marble = new Coords(0,0);
	
	private ArrayList<Color> players = new ArrayList<>();
	
	private Config.Direction direction = null;
	
	private ArrayList<Config.Direction> tabDirections = new ArrayList<Config.Direction>();
	
	public void paintComponent(Graphics g) {
	
		 try {
                Image img = ImageIO.read(new File("Images/dames/Board.png"));
                g.drawImage(img, 0, 0, this);
	        } catch (IOException e) {
	            e.printStackTrace();
	    }
		 
	        int widthOffset = 0;
	        int heightOffset = 152;
	        int limX = 0;

	        for (int i = 1; i < boardView.getHeight(); i++) {
	            for (int j = 0; j < boardView.getWidth(); j++) {
	            	
	            	limX = 102 + j*15;

	                if (boardView.getCase(new Coords(i, j)) == Config.Color.BLACK) {
	                    try {
	                        Image img = ImageIO.read(new File("Images/dames/BallDameBrown.png"));
	                        g.drawImage(img, limX, heightOffset, this);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                } else if (boardView.getCase(new Coords(i, j)) == Config.Color.WHITE) {
	                    try {
	                        Image img = ImageIO.read(new File("Images/dames/BallDameViolet.png"));
	                        g.drawImage(img, limX, heightOffset, this);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
		            else if (boardView.getCase(new Coords(i, j)) == Config.Color.YELLOW) {
	                    try {
	                        Image img = ImageIO.read(new File("Images/dames/BallDameYellow.png"));
	                        g.drawImage(img, limX, heightOffset, this);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
		            else if (boardView.getCase(new Coords(i, j)) == Config.Color.BLUE) {
	                    try {
	                        Image img = ImageIO.read(new File("Images/dames/BallDameBlue.png"));
	                        g.drawImage(img, limX, heightOffset, this);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
		            else if (boardView.getCase(new Coords(i, j)) == Config.Color.RED) {
	                    try {
	                        Image img = ImageIO.read(new File("Images/dames/BallDameRed.png"));
	                        g.drawImage(img, limX, heightOffset, this);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
		            else if (boardView.getCase(new Coords(i, j)) == Config.Color.GREEN) {
	                    try {
	                        Image img = ImageIO.read(new File("Images/dames/BallDameGreen.png"));
	                        g.drawImage(img, limX, heightOffset, this);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }/*
		            else{
		            	if(listTargets.contains(new Coords(i, j))){
		            		try {
		                        Image img = ImageIO.read(new File("Images/dames/BallDameGreen.png"));
		                        g.drawImage(img, limX, heightOffset, this);
		                    } catch (IOException e) {
		                        e.printStackTrace();
		                    }
		            	}
		            }*/
	                if(marble.x == i && marble.y == j){
	                	try {
	                        Image imgSelec = ImageIO.read(new File("Images/dames/BallDameSelec.png"));
	                        g.drawImage(imgSelec, limX, heightOffset, this);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	                /*if (tabSelec[i][j] == 1) { //Show ring selection
	                    try {
	                        Image imgSelec = ImageIO.read(new File("Images/SelectionBall.png"));
	                        g.drawImage(imgSelec, limX-4, heightOffset-5, this);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }*/
	            }
	            heightOffset += 22;
	        }
	}
	
    public void copyTab(BoardDC b) {
        this.boardView = b;
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
                    if (boardView.selectMarble(new Coords(i,j))) {
                        marble = new Coords(i, j);
                        System.out.println("click sur la bille "+i + ";"+j);
                        System.out.println(marble.x + ";"+marble.y);
                        listTargets = boardView.generateTarget(marble);
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
