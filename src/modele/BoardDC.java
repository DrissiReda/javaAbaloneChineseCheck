package modele;

import modele.Config.Color;
import modele.Config.Direction;

public class BoardDC {
	
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
	
	private int height = 19, width = 27;
	private static Coords marble = null;

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
				if(GameBoard[i][j].getColor() != Color.ILLEGAL)
					GameBoard[i][j].setColor(Color.BLUE);
			}
		}
	}
	
	public boolean selectMarble(Coords position)
	{
		// faire la condition, si le pion appartient bien au joueur alors
		marble = position;
		return true;
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
    	GameBoard[marble.x][marble.y].setColor(player);
		cancelSelect();
	}
	
	public void jump_move(Direction dir){
		Color player = Color.BLUE; // A modifier pour adapter à chaque joueur
		Coords newMarble = next_coord(next_coord(marble, dir), dir);
    	GameBoard[marble.x][marble.y].setColor(Color.EMPTY);
    	GameBoard[marble.x][marble.y].setColor(player);
		cancelSelect();
	}
	
	public void cancelSelect(){
		marble = null;
	}
	
	public boolean inTab(Coords pos)
    {
    	if(pos.x >= 0 && pos.x < height && pos.y >= 0 && pos.y < width)
    		if(GameBoard[pos.x][pos.y].getColor() != Color.ILLEGAL)
    			return true;
    	return false;
    }
	
	public Color getCase(Coords pos){
        return GameBoard[pos.x][pos.y].getColor();
    }
	
	public boolean free_next(Coords pos,Direction dir)
	{
		if(!inTab(next_coord(pos,dir)) || getCase(next_coord(pos,dir))==Color.EMPTY)
			return true;
		else
			return false;
	}
	
    public Coords next_coord(Coords pos, Direction dir)
    {
    	switch(dir){
    		case LEFT :      return new Coords(pos.x,pos.y-2);
    		case RIGHT :     return new Coords(pos.x,pos.y+2);
    		case UPLEFT :    return new Coords(pos.x-1,pos.y-1);
    		case DOWNRIGHT : return new Coords(pos.x+1,pos.y+1);
    		case UPRIGHT :   return new Coords(pos.x-1,pos.y+1);
    		case DOWNLEFT :  return new Coords(pos.x+1,pos.y-1);
			default : return pos;
    	}
    }

}


