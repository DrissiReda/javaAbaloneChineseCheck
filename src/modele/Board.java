package modele;

import modele.Config.Color;
import modele.Config.Direction;

import java.util.ArrayList;

public abstract class Board {
	protected int height, width;
	protected Tile GameBoard[][];
	protected int moveSize;
	public Board(int height, int width,int moveSize) {
		this.height = height;
		this.width = width;
		this.moveSize=moveSize;
	}
	
	// Methodes abstraites
	public abstract boolean free_next(Coords pos,Direction dir);
	public abstract void printTabPieces();
	public abstract boolean selectMarble(Coords pos);
	public abstract void cancelSelection();
	public abstract String AvailableMoves(Color player);
	public abstract boolean inTab(Coords marble);
	public abstract int ally_next(Coords marble,Direction k,Color player);

	public abstract int executeMove(Coords[] tabPieces, Color player);
	public abstract boolean undo(Coords[] tabPieces,Color player);
	public abstract Coords[] stringToMove(String str);
	public abstract String MoveToString(Coords[] tabPieces);
	public abstract Color switchPlayer(Color player);
	public abstract String MoveOrdering(Color player);
	public int getHeight(){ return height;}
	public int getWidth(){return width;}

	public int getMoveSize() {
		return moveSize;
	}
	public abstract Color getCase(Coords pos);
	public abstract void setCase(Coords pos, Color col);
	public abstract int marble_count(Color player);
	//Modification
	public abstract ArrayList<Color> getColors();
	public abstract ArrayList<String> getPseudos();
    /**
     * Returns the next coordinates for a given position
     * @param pos (Coords)
     * @param dir (Direction)
     * @return Coords
     */
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
	/**
	 * Converts integer to Direction
	 * @param value (int)
	 * @return Direction
	 */
	public Direction toDir(int value)
	{
		switch(value){
			case 0 : return Direction.LEFT;
			case 1 : return Direction.RIGHT;
			case 2 : return Direction.UPLEFT;
			case 3 : return Direction.DOWNRIGHT;
			case 4 : return Direction.UPRIGHT;
			case 5 : return Direction.DOWNLEFT;
			default : return Direction.LEFT;
		}
	}
	
	public Direction find_direction(Coords marble1,Coords marble2)
	{
		if(marble2.x > marble1.x)
		{
			if(marble2.y < marble1.y)
				return Direction.DOWNLEFT;
			else if(marble2.y > marble1.y)
				return Direction.DOWNRIGHT;
		}
		else if(marble2.x  <marble1.x)
		{
			if(marble2.y<marble1.y)
				return Direction.UPLEFT;
			else if (marble2.y> marble1.y)
				return Direction.UPRIGHT;
		}
		else
		{
			if(marble2.x == marble1.x)
				if(marble2.y > marble1.y)
					return Direction.RIGHT;
				else if(marble2.y < marble1.y)
					return Direction.LEFT;
		}
		return Direction.LEFT;
	}
	public Color switchPlayerIA(Color player){ return (player==Color.WHITE)?Color.BLACK:Color.WHITE;}
}
