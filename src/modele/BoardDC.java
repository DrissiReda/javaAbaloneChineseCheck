package modele;

import modele.Config.Color;
import modele.Config.Direction;

public class BoardDC extends Board{

	// 27 * 19
	private Tile GameBoard[][]={
				// 0						1						2						3						4						5						6						7						8						9						10						11						12						13						14						15						16						17						18						19						20						21						22						23						24						25						26
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),  new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
		{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)}
		
	};
	
	private static Coords marble = null;
	
	public BoardDC() {
		super(19, 27);
	}

	public void affichePlateau()
	{
		for (int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(GameBoard[i][j].getColor() == Color.ILLEGAL)
    				System.out.print(" ");
    			else if(GameBoard[i][j].getColor() == Color.EMPTY)
    				System.out.print(".");
    			else if(GameBoard[i][j].getColor() == Color.BLUE)
    				System.out.print("B");
    			else if(GameBoard[i][j].getColor() == Color.WHITE)
    				System.out.print("W");
    		}
    		System.out.println("");
		}
	}

	// Remplissage de pions bleu pour commencer les déplacements
	public void initBoard()
	{
		for(int i=14;i<height;i++){
			for(int j=0; j<width; j++){
				if(GameBoard[i][j].getColor() != Color.ILLEGAL){
					GameBoard[i][j].setColor(Color.BLUE);
					System.out.println("["+i+";"+j+"]");
				}
					
			}
		}
	}
	
	public boolean selectMarble(Coords pos)
	{
		// faire la condition, si le pion appartient bien au joueur alors
		System.out.println(GameBoard[pos.x][pos.y].getColor());
		if(GameBoard[pos.x][pos.y].getColor() != Color.ILLEGAL && GameBoard[pos.x][pos.y].getColor() != Color.EMPTY){
			marble = pos;
			return true;
		}
		return false;
	}
	
	public void printTabPieces(){
		if(marble != null)
			System.out.println("Selection : ["+marble.x+","+marble.y+"]");
		else
			System.out.println("Pas de selection");
	}
	
	public boolean move(Direction dir)
	{
		if(free_next(marble, dir)){
			simple_move(dir);
			return true;
		}
		else{
			if(free_next(next_coord(marble, dir), dir)){
				jump_move(dir);
				return true;
			}
		}
		return false;	
	}
	
	public void simple_move(Direction dir){
		Color player = Color.BLUE; // A modifier pour adapter à chaque joueur
		Coords newMarble = next_coord(marble, dir);
    	GameBoard[marble.x][marble.y].setColor(Color.EMPTY);
    	GameBoard[newMarble.x][newMarble.y].setColor(player);
    	cancelSelection();
	}
	
	public void jump_move(Direction dir){
		Color player = Color.BLUE; // A modifier pour adapter à chaque joueur
		Coords newMarble = next_coord(next_coord(marble, dir), dir);
    	GameBoard[marble.x][marble.y].setColor(Color.EMPTY);
    	GameBoard[newMarble.x][newMarble.y].setColor(player);
    	cancelSelection();
	}
	
	public void cancelSelection(){
		marble = null;
	}
	
    /**
     * Verifies if the given position is in the board
     * @param pos (Coords)
     * @return boolean
     */
    public boolean inTab(Coords pos)
    {
    	if(pos.x >= 0 && pos.x < height && pos.y >= 0 && pos.y < width)
    		if(GameBoard[pos.x][pos.y].getColor() != Color.ILLEGAL)
    			return true;
    	return false;
    }
	
	public boolean free_next(Coords pos,Direction dir)
	{
		if(inTab(next_coord(pos,dir)) || getCase(next_coord(pos,dir))==Color.EMPTY)
			return true;
		else
			return false;
	}

}


