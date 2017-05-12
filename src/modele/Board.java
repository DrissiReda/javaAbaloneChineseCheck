package modele;
import modele.Config.Color;
import modele.Config.Direction;

/**
 * @author Etienne
 *
 */
public class Board {
	
	public static Coords[] tabPieces = new Coords[4];
											//0                         1                       2                      3                       4                       5                       6                       7                        8                      9                          10                    11                        12                   13                      14                      15                       16                     17                        18
	private Tile GameBoard[][]={{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
                                {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
                                {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
                                {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
                                {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
                                {new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL)},
                                {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
                                {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
                                {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
                                {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
                                {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
                                };
    private int height, width;

    public Color getCase(Coords pos){
        return GameBoard[pos.x][pos.y].getColor();
    }
    
    public void setCase(Coords pos, Color c){
        GameBoard[pos.x][pos.y].setColor(c);
    }
    
    public Board(){
        height = 11;
        width = 19;
        initTabPieces();
    }
    
    public Board(int h, int w) {
        height = h;
        width = w;
        initTabPieces();
    }
    
    public void displayBoard()
    {
    	for(int i = 0; i < height; i++){
    		for(int j = 0; j < 19; j++){
    			if(GameBoard[i][j].getColor() == Color.ILLEGAL)
    				System.out.print(" ");
    			else if(GameBoard[i][j].getColor() == Color.EMPTY)
    				System.out.print(".");
    			else if(GameBoard[i][j].getColor() == Color.BLACK)
    				System.out.print("B");
    			else if(GameBoard[i][j].getColor() == Color.WHITE)
    				System.out.print("W");
    		}
    		System.out.println("");
    	}
    }
    
    public void initTabPieces()
    {
    	Coords defaultPos = null;
    	Coords defaultDir = null;
    	defaultPos.x = 22; defaultPos.y = 22;
    	defaultDir.x = 88; defaultDir.y = 88;
    	for (int i = 0; i < 4; i++){
    		tabPieces[i] = i == 3 ? defaultDir : defaultPos;
    	}
    		
    }
    
    public void selectMarble(Coords pos)
    {
    	
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
    
    /**
     * Converts integer to Color
     * @param value (int)
     * @return Color
     */
    public Color toColor(int value)
    {
    	switch(value){
    		case 0 : return Color.ILLEGAL;
    		case 1 : return Color.EMPTY;
    		case 2 : return Color.BLACK;
    		case 3 : return Color.WHITE;
    		case 4 : return Color.RED;
    		case 5 : return Color.GREEN;
    		case 6 : return Color.BLUE;
    		case 7 : return Color.YELLOW;
    		default : return Color.ILLEGAL;
    	}
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
    		case LEFT : pos.y -= 2; break;
    		case RIGHT : pos.y +=2; break;
    		case UPLEFT : pos.x-=1; pos.y-=1; break;
    		case DOWNRIGHT : pos.x+=1; pos.y+=1; break;
    		case UPRIGHT : pos.x-=1; pos.y+=1; break;
    		case DOWNLEFT : pos.x+=1; pos.y-=1; break;
    		default : break;
    	}
		return pos;
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
    
    /**
     * Switch player : Returns Color.WHITE if player is Color.BLACK and conversely
     * @param player (Color)
     * @return Color
     */
    public Color switchPlayer(Color player)
    {
    	return player == Color.WHITE ? Color.BLACK : Color.WHITE;
    }
    
    /**
     * Function for sumito 2 marbles vs 1
     * @param pieces (Coords [])
     * @param player (Color)
     */
    public void sumito_2_1(Coords pieces[], Color player){
    	Direction dir = toDir(pieces[3].x % 10);
    	Coords marble = next_coord(pieces[1], dir);
    	GameBoard[pieces[0].x][pieces[0].y].setColor(Color.EMPTY);
    	GameBoard[marble.x][marble.y].setColor(player);
    	marble = next_coord(marble, dir);
    	if(inTab(marble))
    		GameBoard[marble.x][marble.y].setColor(switchPlayer(player));
    }
    
    public void sumito_3_1(Coords pieces[], Color player){
    	Direction dir = toDir(pieces[3].x % 10);
    	Coords marble = next_coord(pieces[2], dir);
    	GameBoard[pieces[0].x][pieces[0].y].setColor(Color.EMPTY);
    	GameBoard[marble.x][marble.y].setColor(player);
    	marble = next_coord(marble, dir);
    	if(inTab(marble))
    		GameBoard[marble.x][marble.y].setColor(switchPlayer(player));  	
    }
    
    public void sumito_3_2(Coords pieces[], Color player){
    	Direction dir = toDir(pieces[3].x % 10);
    	Coords marble = next_coord(pieces[2], dir);
    	GameBoard[pieces[0].x][pieces[0].y].setColor(Color.EMPTY);
    	GameBoard[marble.x][marble.y].setColor(player);
    	marble = next_coord(next_coord(marble, dir), dir);
    	if(inTab(marble))
    		GameBoard[marble.x][marble.y].setColor(switchPlayer(player)); 
    }
    
    public void broadside(Coords pieces[], Color player){
    	simple_move(pieces, player);
    }
    
    public void simple_move(Coords pieces[], Color player){
    	Direction dir = toDir(pieces[3].x % 10);
    	Coords marble;
    	for(int i = 2; i >= 0; i--){
    		if(pieces[i].x == 22)
    			continue;
    		GameBoard[pieces[i].x][pieces[i].y].setColor(Color.EMPTY);
    		marble = next_coord(pieces[i], dir);
    		GameBoard[marble.x][marble.y].setColor(player);
    		
    	}
    }
}