package modele;

import modele.Config.Color;
import modele.Config.Direction;

import java.util.ArrayList;

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
	private Coords[] tabPieces=new Coords[2];
	private ArrayList<Color> players=new ArrayList<>();
	public BoardDC() {
		super(19, 27,8);
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
	public Color getCase(Coords pos){
		return GameBoard[pos.x][pos.y].getColor();
	}
	public void setCase(Coords pos, Color c){
		GameBoard[pos.x][pos.y].setColor(c);
	}
	public boolean addPlayer(Color player){
		if(players.size()>=6 || players.contains(player))
			return false;
		players.add(player);
		return true;
	}
	@Override
	public int marble_count(Color player) {
		return 10;
	}

	// Remplissage de pions bleu pour commencer les deplacements
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
			tabPieces[0] = pos;
			return true;
		}
		return false;
	}
	
	public void printTabPieces(){
		if(tabPieces[0] != null)
			System.out.println("Selection : ["+tabPieces[0].x+","+tabPieces[0].y+"]");
		else
			System.out.println("Pas de selection");
	}
	
	public boolean executeMove(Coords[] tabPieces,Color player)
	{
		if(free_next(tabPieces[0], toDir(tabPieces[1].x%10))){
			simple_move(tabPieces,player);
			return true;
		}
		else{
			if(free_next(next_coord(tabPieces[0], toDir(tabPieces[1].x%10)), toDir(tabPieces[1].x%10))){
				jump_move(tabPieces,player);
				return true;
			}
		}
		return false;	
	}
	
	public void simple_move(Coords[] tabPieces,Color player){
		Coords newMarble = next_coord(tabPieces[0], toDir(tabPieces[1].x%10));
    	setCase(tabPieces[0],Color.EMPTY);
    	setCase(newMarble,player);
    	cancelSelection();
	}
	
	public void jump_move(Coords[] tabPieces,Color player){
		Coords newMarble = next_coord(next_coord(tabPieces[0], toDir(tabPieces[1].x%10)), toDir(tabPieces[1].x%10));
    	setCase(tabPieces[0],Color.EMPTY);
    	setCase(newMarble,player);
    	cancelSelection();
	}
	public void cancelSelection(){
		tabPieces[0] = null;
	}

	@Override
	public String AvailableMoves(Color player) {
		String Av_Moves="";
		for(int i=0;i<getHeight();i++)
			for(int j=0;j<getWidth();j++)
				for(Direction k : Direction.values()){
					tabPieces[0].setCoords(i,j);
					if(free_next(new Coords(i,j),k)) {
						tabPieces[1].setCoords(10 + k.ordinal(), 88);
						Av_Moves=Av_Moves+MoveToString(tabPieces);
					}
					if(ally_next(new Coords(i,j),k,player)==1 && free_next(next_coord(new Coords(i,j),k),k))
						tabPieces[1].setCoords(20+k.ordinal(),88);{
						Av_Moves=Av_Moves+MoveToString(tabPieces);
					}
				}
		return Av_Moves;
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

	@Override
	public int ally_next(Coords marble, Direction k, Color player) {
		return 0;
	}

	@Override
	public boolean undo(Coords[] tabPieces, Color player) {
		return false;
	}

	@Override
	public Coords[] stringToMove(String str) {
		Coords tab[]= {
				new Coords(Integer.parseInt(str.substring(0, 2)), Integer.parseInt(str.substring(2, 4))),
				new Coords(Integer.parseInt(str.substring(4, 6)), Integer.parseInt(str.substring(6, 8))),
		};
		return tab;
	}

	@Override
	public String MoveToString(Coords[] tab) {
		String ret = "";
		for(int i=0;i<2;i++)
		{
			if(tab[i].x<10)
				ret=ret+"0";
			ret=ret+tab[i].x;
			if(tab[i].y<10)
				ret=ret+"0";
			ret=ret+tab[i].y;
		}
		return ret;
	}

	@Override
	public Color switchPlayer(Color player) {
		int i;
		//trouve l'index du joueur actuel
    	for(i=0;i<players.size();i++)
			if(player==players.get(i))
				break;
    	//retourne le suivant, si c'est le dernier
		//retourne le premier
		return players.get((i+1)%players.size());
	}

	@Override
	public String MoveOrdering(Color player) {
		return null;
	}

	public boolean free_next(Coords pos,Direction dir)
	{
		if(inTab(next_coord(pos,dir)) || getCase(next_coord(pos,dir))==Color.EMPTY)
			return true;
		else
			return false;
	}

}


