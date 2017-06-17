package modele;

import modele.Config.Area;
import modele.Config.Color;
import modele.Config.Direction;

import java.util.ArrayList;

import static modele.Config.Direction.RIGHT;

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
	private Coords[] tabPieces=new Coords[3];
	private ArrayList<Color> players=new ArrayList<>();
	private Color currentplayer;
	private boolean jumping=false;
	public BoardDC() {
		super(19, 27,12);
	}

	public void affichePlateau()
	{
		for (int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(GameBoard[i][j].getColor() == Color.ILLEGAL)
    				System.out.print(" ");
    			else if(GameBoard[i][j].getColor() == Color.EMPTY)
    				System.out.print(".");
    			else if(GameBoard[i][j].getColor() == Color.BLACK)
    				System.out.print("N");
    			else if(GameBoard[i][j].getColor() == Color.WHITE)
    				System.out.print("W");
    			else if(GameBoard[i][j].getColor() == Color.RED)
    				System.out.print("R");
    			else if(GameBoard[i][j].getColor() == Color.GREEN)
    				System.out.print("G");
    			else if(GameBoard[i][j].getColor() == Color.BLUE)
    				System.out.print("B");
    			else if(GameBoard[i][j].getColor() == Color.YELLOW)
    				System.out.print("Y");
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
	public boolean addPlayer(){
		if(players.size() >= 6)
			return false;
		if(players.size()==0)
			players.add(Color.BLACK);
		else
			players.add(players.get(players.size()-2).getNext());
		return true;
	}
	
	public void colorBoard()
	{
		ArrayList<Area> zones = new ArrayList<Area>();
		zones = getAreasToColor(players.size());
		int i = 0;
		for (Area area: zones) {
		    colorBoard(area, players.get(i));
		    i++;
		}
	}
	
	public ArrayList<Area> getAreasToColor(int nbColors){
		ArrayList<Area> zones = new ArrayList<Area>();
		switch (nbColors){
			case 2 :
				zones.add(Area.NORTH);
				zones.add(Area.SOUTH);
				break;
			case 3 :
				zones.add(Area.NORTHEAST);
				zones.add(Area.SOUTH);
				zones.add(Area.NORTHWEST);
				break;
			case 4 :
				zones.add(Area.NORTH);
				zones.add(Area.NORTHWEST);
				zones.add(Area.SOUTHEAST);
				zones.add(Area.SOUTH);
				break;
			case 6 :
				zones.add(Area.NORTH);
				zones.add(Area.NORTHEAST);
				zones.add(Area.SOUTHEAST);
				zones.add(Area.SOUTH);
				zones.add(Area.SOUTHWEST);
				zones.add(Area.NORTHWEST);
				break;
			default : break;
		}
		return zones;
	}
	
	public void colorBoard(Area area, Color color)
	{
		switch(area){
			case NORTH : colorNorth(color); break;
			case NORTHEAST : colorNorthEast(color); break;
			case SOUTHEAST : colorSouthEast(color); break;
			case SOUTH : colorSouth(color); break;
			case SOUTHWEST : colorSouthWest(color); break;
			case NORTHWEST : colorNorthWest(color); break;
			default : break;
		}
	}
	
	public void colorNorth(Color color)
	{
		for(int i = 1; i < 5; i++){
			for(int j = 0; j < width; j++){
				if(GameBoard[i][j].getColor() != Color.ILLEGAL)
					GameBoard[i][j].setColor(color);
			}
		}
	}
	
	public void colorNorthEast(Color color)
	{
		for(int i = 5; i < 9 ; i++){
			for(int j = width-1; j > 20 ; j--){
				if(GameBoard[i][j].getColor() != Color.ILLEGAL){
					GameBoard[i][j].setColor(color);
					System.out.println(i+";"+j+" ");
				}
			}
		}
		GameBoard[5][19].setColor(color);
		GameBoard[6][20].setColor(color);
	}
	
	public void colorNorthWest(Color color)
	{
		for(int i = 5; i < 9 ; i++){
			for(int j = 0; j < 6 ; j++){
				if(GameBoard[i][j].getColor() != Color.ILLEGAL)
					GameBoard[i][j].setColor(color);					
			}
		}
		GameBoard[5][7].setColor(color);
		GameBoard[6][6].setColor(color);
	}
	
	public void colorSouth(Color color)
	{
		for(int i = 14; i < height; i++){
			for(int j = 0; j < width; j++){
				if(GameBoard[i][j].getColor() != Color.ILLEGAL)
					GameBoard[i][j].setColor(Color.BLACK);
			}
		}
	}

	public void colorSouthEast(Color color)
	{
		for(int i = 10; i < 14 ; i++){
			for(int j = width-1; j > 20 ; j--){
				if(GameBoard[i][j].getColor() != Color.ILLEGAL)
					GameBoard[i][j].setColor(color);					
			}
		}
		GameBoard[12][20].setColor(color);
		GameBoard[13][19].setColor(color);
	}

	public void colorSouthWest(Color color)
	{
		for(int i = 10; i < 14 ; i++){
			for(int j = 0; j < 6 ; j++){
				if(GameBoard[i][j].getColor() != Color.ILLEGAL)
					GameBoard[i][j].setColor(color);					
			}
		}
		GameBoard[12][6].setColor(color);
		GameBoard[13][7].setColor(color);
	}
	
	@Override
	//number of pieces that reached the endgoal
	public int marble_count(Color player) {
		int res=0;
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++){
			if(getCase(new Coords(i,j))==player &&
				inArea(new Coords(i,j),getEndArea(new Coords(i,j))))
				res++;
			}
			return res;
	}

	// Remplissage de pions bleu pour commencer les deplacements
	public void initBoard()
	{
		if(players.size() >= 2)
			colorBoard();
		else
			System.out.println("Il faut choisir au moins 2 couleurs pour initialiser le plateau");
	}
	
	public boolean selectMarble(Coords pos)
	{
		// faire la condition, si le pion appartient bien au joueur alors
		if(GameBoard[pos.x][pos.y].getColor() != Color.ILLEGAL && GameBoard[pos.x][pos.y].getColor() != Color.EMPTY){
			tabPieces[0] = pos;
			return true;
		}
		return false;
	}

	@Override
	public void printTabPieces(){
		if(tabPieces[0] != null)
			System.out.println("Selection : ["+tabPieces[0].x+","+tabPieces[0].y+"]");
		else
			System.out.println("Pas de selection");
	}
	@Override
	public Boolean executeMove(Coords[] tabPieces, Color player)
	{
		// Si le pion est dans une zone d'arriv?e et que son mouvement va le faire sortir de cette zone
		if(inOppositeArea(tabPieces[0]) && !inOppositeArea(next_coord(tabPieces[0], toDir(tabPieces[2].x%10))))
			return null;
		// no ability to jump again, make sure not in a jump sequence
		if(free_next(tabPieces[0], toDir(tabPieces[2].x % 10)) && jumping==false){
			simple_move(tabPieces,player);
			return false;
		}
		else{
			if(free_next(next_coord(tabPieces[0], toDir(tabPieces[2].x%10)), toDir(tabPieces[2].x%10))){
				jump_move(tabPieces,player);
				jumping=true;
				return true;
			}
		}
	return false;	
	}
	@Override
	public boolean undo(Coords[] tabPieces, Color player) {
		setCase(tabPieces[1],Color.EMPTY);
		setCase(tabPieces[0],player);
		cancelSelection();
		return true;
	}
	public void simple_move(Coords[] tabPieces,Color player){
		jump_move(tabPieces,player);
	}
	
	public void jump_move(Coords[] tabPieces,Color player){
		//coords newmarble = next_coord(next_coord(tabpieces[0], todir(tabpieces[2].x%10)), todir(tabpieces[2].x%10));
    	setCase(tabPieces[0],Color.EMPTY);
    	setCase(tabPieces[1],player);
    	cancelSelection();
	}
	public void cancelSelection(){
		tabPieces[0] = null;
	}

	@Override
	public String AvailableMoves(Color player) {
		Coords[] tabPieces={new Coords(22,22),new Coords(22,22),new Coords(88,88)};
		String Av_Moves="";
		for(int i=0;i<getHeight();i++)
			for(int j=0;j<getWidth();j++)
				for(Direction k : Direction.values()){
					tabPieces[0].setCoords(i,j);
					if(free_next(new Coords(i,j),k)) {
						//normal
						tabPieces[1].setCoords(next_coord(new Coords(i,j),k));
						tabPieces[2].setCoords(10 + k.ordinal(), 88);
                        if(!(inOppositeArea(tabPieces[0]) && !inOppositeArea(tabPieces[1])))
                            Av_Moves=Av_Moves+MoveToString(tabPieces);
					}
					else {
						if (free_next(next_coord(new Coords(i, j), k), k)) {
							//jump
							tabPieces[1].setCoords(next_coord(next_coord(new Coords(i,j),k),k));
							tabPieces[2].setCoords(20 + k.ordinal(), 88);
                            if(!(inOppositeArea(tabPieces[0]) && !inOppositeArea(tabPieces[1]))) {
                                Av_Moves = Av_Moves + MoveToString(tabPieces);
                                int flag = 1;
                                while (flag != 0) {
                                    for (Direction l : Direction.values()) {
                                        if (l == invert_dir(k))
                                            continue;
                                        if (free_next(next_coord(tabPieces[1], k), k)) {
                                            flag = 2;
                                            //sequence jump
                                            tabPieces[1].setCoords(next_coord(next_coord(tabPieces[1], k), k));
                                            tabPieces[2].setCoords(30 + l.ordinal(), 88);
                                            Av_Moves = Av_Moves + MoveToString(tabPieces);
                                        }

                                    }
                                    if (flag != 2)
                                        break;
                                }
                            }
						}
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
    
    /**
     * Permet de savoir si un pion est dans la zone oppos?e ? sa zone de d?part
     * @param pos
     * @return boolean Vrai si le pion est dans la zone oppos?e, faux sinon
     */
    public boolean inOppositeArea(Coords pos)
    {
    	Area zone = getEndArea(pos); // on recupere la position d'arrivee du pion
    	System.out.println(zone);
    	return inArea(pos, zone);
    }
    
    public boolean inArea(Coords pos, Area zone)
    {
    	switch(zone){
    		case NORTH : return inAreaNorth(pos);
    		case NORTHEAST : return inAreaNorthEast(pos);
    		case SOUTHEAST : return inAreaSouthEast(pos);
    		case SOUTH : return inAreaSouth(pos);
    		case SOUTHWEST : return inAreaSouthWest(pos);
    		case NORTHWEST : return inAreaNorthWest(pos);
    		default : return false;
    	}
    }
    
    public boolean inAreaNorth(Coords pos)
    {
    	return (pos.x < 5);
    }

    public boolean inAreaNorthEast(Coords pos)
    {
    	if((pos.x == 5 && pos.y == 19) || (pos.x == 6 && pos.y == 20))
    		return true;
    	return (pos.x >= 5 && pos.x < 9 && pos.y > 20);
    }

    public boolean inAreaSouthEast(Coords pos)
    {
		if((pos.x == 12 && pos.y == 20) || (pos.x == 13 && pos.y == 19))
			return true;
		return (pos.x >= 10 && pos.x < 20 && pos.y > 20);
    }

    public boolean inAreaSouth(Coords pos)
    {
    	return (pos.x > 13);
    }
    
    public boolean inAreaSouthWest(Coords pos)
    {
		if((pos.x == 12 && pos.y == 6) || (pos.x == 13 && pos.y == 7))
			return true;
		return (pos.x >= 10 && pos.x < 14 && pos.y < 6);		
    }
    
    public boolean inAreaNorthWest(Coords pos)
    {
		if((pos.x == 5 && pos.y == 7) || (pos.x == 6 && pos.y == 6))
			return true;
		return (pos.x >= 5 && pos.x < 9 && pos.y < 6);	
    }

    /**
     * Retourne la zone de d?part d'une couleur
     * @return
     */
    public Area getStartArea(Coords pos){
    	ArrayList<Area> zones = new ArrayList<Area>();
    	int index = players.indexOf(getCase(pos));
    	zones = getAreasToColor(players.size());
    	return zones.get(index);
    }
    
    /**
     * Retourne la zone d'arriv?e d'un pion pass? en param?tre
     * @param pos
     * @return
     */
    public Area getEndArea(Coords pos)
    {
    	return invert(getStartArea(pos));
    }
    
    /**
     * Retourne la zone oppos?e de la zone pass?e en param?tre
     * @param area
     * @return
     */
    public Area invert(Area area){
    	switch(area){
    		case NORTH : return Area.SOUTH;
    		case NORTHEAST : return Area.SOUTHWEST;
    		case SOUTHEAST : return Area.NORTHWEST;
    		case SOUTH : return Area.NORTH;
    		case SOUTHWEST : return Area.NORTHEAST;
    		case NORTHWEST : return Area.SOUTHEAST;
    		default : return null;
    	}
    }

	@Override
	public int ally_next(Coords marble, Direction k, Color player) {return 0;}
	public Direction invert_dir(Direction k){
    	switch(k){
    		case LEFT : return Direction.RIGHT;
			case RIGHT : return Direction.LEFT;
			case UPLEFT: return Direction.DOWNRIGHT;
			case UPRIGHT: return Direction.DOWNLEFT;
			case DOWNLEFT: return Direction.UPRIGHT;
			case DOWNRIGHT: return Direction.UPLEFT;
			default : return null;
		}
	}
	@Override
	public Coords[] stringToMove(String str) {
		Coords tab[]= {
				new Coords(Integer.parseInt(str.substring(0,  2)), Integer.parseInt(str.substring( 2,  4))),
				new Coords(Integer.parseInt(str.substring(4,  6)), Integer.parseInt(str.substring( 6,  8))),
				new Coords(Integer.parseInt(str.substring(8, 10)), Integer.parseInt(str.substring(10, 12))),
		};
		return tab;
	}

	@Override
	public String MoveToString(Coords[] tab) {
		String ret = "";
		for(int i=0;i<moveSize;i++)
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
	public Color switchPlayer(Color player){
		return player.getNext();
	}

	@Override
	public String MoveOrdering(Color player) {
		return null;
	}

	public boolean free_next(Coords pos,Direction dir)
	{
		if(inTab(next_coord(pos,dir)) && getCase(next_coord(pos,dir))==Color.EMPTY)
			return true;
		else
			return false;
	}
	public ArrayList<Direction> generateDir(Coords[] tP){
		ArrayList<Direction> ret=new ArrayList<>();
		// if source = dest it means the user
		// chose to stop, even if he can still continue
		//if(tP[0].x == tP[1].x && tP[0].y==tP[1].y)
		//	return ret;
		String move=AvailableMoves(currentplayer);
		for(int i=0;i<move.length();i+=moveSize) {
			//Test if move exists and is not a long jump
				if (MoveToString(tP).substring(0, 4).equals(move.substring(i, i + 4))
					&& Integer.parseInt(move.substring(i+8,i+9))!=3	)
					ret.add(toDir(Integer.parseInt(move.substring(i +9, i + 10))));
		}
		return ret;
	}
	public ArrayList<Coords> generateTarget(Coords tP){
	    Coords[] a={tP};
	    return generateTarget(a);
    }
	public ArrayList<Coords> generateTarget(Coords[] tP){
		ArrayList<Direction> dirs=generateDir(tP);
		ArrayList<Coords> ret=new ArrayList<>();
		for(Direction k : dirs){
			ret.add(next_coord(tP[0],k));
		}
		return ret;
	}
    public Coords[] generateMove(Coords[] tabPieces,Color player){
        return null;
    }
}
////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////// EXECUTION /////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
/*
 * if(executeMove()== true ) #initiate jump sequence#{
 * 	int flag=1;
 * 	while(flag==1){
 *
 * 		if(generateDir().size()==0)
 * 			break;
 * 		if(executeMove==false) # move was a simple, illegal, revert
 * 			undo()
 */

////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////// tabPieces  /////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
/*
 * the graphic has to do so :
 * tabPieces[0] = Selected source
 * tabPieces[1] = (22,22) or Selected destination
 * tabPieces[2] = (10+k.ordinal(),88) #of course k being the direction
 * The executeMove() here does not care about the type of movement, nor does
 * anyone else besides the AI
 */