package modele;

import modele.Config.Color;
import modele.Config.Direction;

public abstract class Board {
	protected int height, width;
	protected Tile GameBoard[][];

	public Board(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	// Methodes abstraites
	public abstract boolean free_next(Coords pos,Direction dir);
	public abstract void printTabPieces();
	public abstract boolean selectMarble(Coords pos);
	public abstract void cancelSelection();
	
	public Color getCase(Coords pos){
        return GameBoard[pos.x][pos.y].getColor();
    }
	
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
	
}
