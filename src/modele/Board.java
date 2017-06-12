package modele;
import modele.Config.Color;
import modele.Config.Direction;

public class Board {
	
	public static Coords[] tabPieces = new Coords[4];
	public static Color player = Color.BLACK;

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

    public int getHeight(){return height;}
    public int getWidth() {return width;}
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
    
    public void printPosition(Coords pos)
    {
    	System.out.println(GameBoard[pos.x][pos.y].getColor());
    }
    
    public void displayBoard()
    {
    	for(int i = 0; i < height; i++){
    		for(int j = 0; j < width; j++){
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
    	Coords defaultPos;
    	Coords defaultDir = new Coords(88, 88);
    	for (int i = 0; i < 4; i++){
    		defaultPos = new Coords(22, 22);
    		tabPieces[i] = i == 3 ? defaultDir : defaultPos;
    	}
    }
    
    public void addPiece(){
    	tabPieces[0].setCoords(1, 1);
    }
    public void printTabPieces()
    {
    	System.out.print("Pièces sélectionnées : ");
    	for (int i = 0; i < 3; i++){
    		if(tabPieces[i].x != 22)
    			System.out.print("["+tabPieces[i].x+";"+tabPieces[i].y+"]");
    		else{
    			if(tabPieces[0].x == 22){
    				System.out.print("Aucune");
    				break;
    			}	
    		}
    	}
    	System.out.println("");
    	System.out.print("Direction : ");
    	if (tabPieces[3].x != 88)
    		System.out.println(toDir(tabPieces[3].x));
    	else
    		System.out.println("Non définie");
    }
    
    public int nbPiece()
    {
    	int nb = 0;
    	for(int i = 0; i < 2; i++){ // Parcours des cases pour les pions (les 3 premières)
    		if(tabPieces[i].x != 22)
    			nb++;
    		else
    			break;
    	}
    	return nb;
    }
    
    public boolean selectMarble(Coords position)
    {
    	// Vérifie que le pion n'est pas déjà sélectionné et est valide
    	if(checkSelected(position) && isMarble(position) && isValid(position)){
    		// Recherche une place disponible dans le tableau
    		for (int i = 0; i < 3; i++){
    			System.out.println("valeur dans le tab : " + tabPieces[i].x);
    			if(tabPieces[i].x == 22){
    				tabPieces[i].x = position.x;
    				tabPieces[i].y = position.y;
    				return true;
    			}
    		}
    	}
    	return false; //Pas de place disponible ou pion déjà sélectionné
    }
    
    // Ici il faut voir si on doit reset aussi le mouvement ecrit ou pas
    public void cancelSelection()
    {
    	/*for(int i = 0; i < 3; i++){
    		tabPieces[i].x = 
    		
    	}*/
    	
    	initTabPieces();
    }
    
    public boolean isMarble(Coords position){ // + Color player
    	Tile selected = GameBoard[position.x][position.y];
    	switch(selected.getColor()){
    		case ILLEGAL : return false;
    		case EMPTY : return false;
    		case WHITE : 
    			if(player == Color.WHITE)
    				return true;
    			else
    				return false;
    		case BLACK :
    			if(player == Color.BLACK)
    				return true;
    			else
    				return false;
    		default : break;
    	}
		return false;
    }
    
    public boolean checkSelected(Coords position)
    {
    	for (int i = 0; i < 3; i++){
    		if(tabPieces[i].x == position.x && tabPieces[i].y == position.y)
    			return false;
    	}
    	return true;
    }

    public boolean isValid(Coords position)
    {
    	int x, y;
    	boolean result = false;
    	boolean isEmpty = true;
    	boolean twoMarbles = false;

    	for (int i = 0; i < 3; i++){
    		if(tabPieces[i].x != 22){
    			if(i == 1)
    				twoMarbles = true;

    			isEmpty = true;
    			x = tabPieces[i].x - position.x;
    			y = tabPieces[i].y - position.y;

    			if(x == 0){ // les deux pions sont sur la meme ligne
    				if(y == 2 || y == -2)
    					result = true;
    			}
    			else if (x == -1 || x == 1){
    				if(y == 1 || y == -1)
    					result = true;
    			}
    		}
    	}
    	
    	/* Dans le cas où deux pions ont déjà été sélectionnés il faut
    	 * s'assurer que le troisième soit placé dans la continuité */ 
    	
		if (twoMarbles){
			if (tabPieces[0].x == tabPieces[1].x){
				if(position.x != tabPieces[0].x)
					result = false;
			}
			else{
				if(position.x == tabPieces[0].x || position.x == tabPieces[1].x)
					result = false;
			}
		}
		
		if(isEmpty)
			result = true;

		return result;
    }

    public Coords[] stringToMove(String str){

    	Coords tab[]={
    			new Coords(Integer.parseInt(str.substring(0,2)),Integer.parseInt(str.substring(2,4))),
				new Coords(Integer.parseInt(str.substring(4,6)),Integer.parseInt(str.substring(6,8))),
				new Coords(Integer.parseInt(str.substring(8,10)),Integer.parseInt(str.substring(10,12))),
				new Coords(Integer.parseInt(str.substring(12,14)),Integer.parseInt(str.substring(14,16))),
					};
		return tab;
	}
    public String MoveToString(Coords[] tab)
	{
		String ret = "";
		for(int i=0;i<4;i++)
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
    /**
     * Converts a string like "4,8" to new Coords(4, 8);
     * @param str
     * @return Coords
     */
    public Coords stringToCoords(String str)
    {
		int x = 0, y = 0;
		Coords pos;

		String [] cut = str.split(",");
		x = Integer.parseInt(cut[0]);
		y = Integer.parseInt(cut[1]);

		pos = new Coords(x, y);
		return pos;
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
    		case LEFT :      return new Coords(pos.x,pos.y-2);
    		case RIGHT :     return new Coords(pos.x,pos.y+2);
    		case UPLEFT :    return new Coords(pos.x-1,pos.y-1);
    		case DOWNRIGHT : return new Coords(pos.x+1,pos.y+1);
    		case UPRIGHT :   return new Coords(pos.x-1,pos.y+1);
    		case DOWNLEFT :  return new Coords(pos.x+1,pos.y-1);
			default : return pos;
    	}
    }
    
    public int ally_next(Coords pos,Direction dir,Color player)
	{
		if(!inTab(next_coord(pos,dir)) || getCase(next_coord(pos,dir))==Color.ILLEGAL)
			return 2; // illegal
		if(getCase(next_coord(pos,dir))==player)
			return 1; //Same color
		return 0;   // enemy or empty
	}
    
    public boolean free_next(Coords pos,Direction dir)
	{
		if(!inTab(next_coord(pos,dir)) || getCase(next_coord(pos,dir))==Color.EMPTY)
			return true;
		else
			return false;
	}
    
	Direction find_direction(Coords marble1,Coords marble2)
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
     * @param tabPieces (Coords [])
     * @param player (Color)
     */
    public void sumito_2_1(Coords tabPieces[], Color player){
    	Direction dir = toDir(tabPieces[3].x % 10);
    	Coords marble = next_coord(tabPieces[1], dir);
    	GameBoard[tabPieces[0].x][tabPieces[0].y].setColor(Color.EMPTY);
    	GameBoard[marble.x][marble.y].setColor(player);
    	marble = next_coord(marble, dir);
    	if(inTab(marble))
    		GameBoard[marble.x][marble.y].setColor(switchPlayer(player));
    }
    
    public void sumito_3_1(Coords tabPieces[], Color player){
    	Direction dir = toDir(tabPieces[3].x % 10);
    	Coords marble = next_coord(tabPieces[2], dir);
    	GameBoard[tabPieces[0].x][tabPieces[0].y].setColor(Color.EMPTY);
    	GameBoard[marble.x][marble.y].setColor(player);
    	marble = next_coord(marble, dir);
    	if(inTab(marble))
    		GameBoard[marble.x][marble.y].setColor(switchPlayer(player));  	
    }
    
    public void sumito_3_2(Coords tabPieces[], Color player){
    	Direction dir = toDir(tabPieces[3].x % 10);
    	Coords marble = next_coord(tabPieces[2], dir);
    	GameBoard[tabPieces[0].x][tabPieces[0].y].setColor(Color.EMPTY);
    	GameBoard[marble.x][marble.y].setColor(player);
    	marble = next_coord(next_coord(marble, dir), dir);
    	if(inTab(marble))
    		GameBoard[marble.x][marble.y].setColor(switchPlayer(player)); 
    }
    
    public void broadside(Coords tabPieces[], Color player){
    	simple_move(tabPieces, player);
    }
    
    public void simple_move(Coords tabPieces[], Color player){
    	Direction dir = toDir(tabPieces[3].x % 10);
    	for(int i = 2; i >= 0; i--){
    		if(tabPieces[i].x == 22)
    			continue;
    		setCase(tabPieces[i],Color.EMPTY);
			setCase(next_coord(tabPieces[i], dir), player);
    	}
    }
    
    public void executeMove(Coords tabPieces[], Color player){
    	int type = tabPieces[3].x/10;
    	
    	switch(type){
    		case 3 : simple_move(tabPieces, player); break;
    		case 4 : sumito_2_1(tabPieces, player); break;
    		case 5 : sumito_3_1(tabPieces, player); break;
    		case 6 : sumito_3_2(tabPieces, player); break;
    		case 7 : broadside(tabPieces, player); break;
    		default : break;
    	}
    }
    public void undo(Coords tabPieces[],Color player)
	{
		int i=2;
		Direction k     = toDir(tabPieces[3].x %10); // find the direction to invert
		//DIRECTION not_k = invert_direction(k);
		int type        = tabPieces[3].x /10; // find the type of move to know what to do
		while(i>=0 && tabPieces[i].x==22 )
			i--;
		if(i<0)
			i=0;
		int j=i;// we modify the substantial tabPieces so we need to decrement
		switch(type)    // back since we stopped at direction and type info
		{
			case 3 : {               // simple_move (almost)same as broadside
				while(j>=0)
				{
					setCase(tabPieces[j],player);
					j--;
				}
				setCase(next_coord(tabPieces[i],k),Color.EMPTY);
				break;
			}
			case 4 :   {    // sumito_2_1
				Coords marble        = next_coord(tabPieces[1],k);
				Coords marble2       = next_coord(marble,k);
				setCase(marble,switchPlayer(player));
				if(inTab(marble2))
					setCase(marble2,Color.EMPTY);
				setCase(tabPieces[0],player);
				break;
			}
			case 5 :   {  //  sumito_3_1
				// only difference between 4 and 5 is here j is going to be bigger by one
				Coords marble        = next_coord(tabPieces[2],k);
				Coords marble2       = next_coord(marble,k);
				setCase(marble,switchPlayer(player));
				if(inTab(marble2))
					setCase(marble2,Color.EMPTY);
				setCase(tabPieces[0],player);
				break;
			}
			case 6 :   {  // sumito_3_2
				// same thing but we go marbles deeper (1 step)
				Coords marble          = next_coord(tabPieces[2],k);
				Coords marble3         = next_coord(next_coord(marble,k),k);
				setCase(marble,switchPlayer(player));
				if(inTab(marble3))
					setCase(marble3,Color.EMPTY);
				setCase(tabPieces[0],player);
				break;
			}
			case 7 :   {           // broadside same as simple_move
				while(j>=0)
				{
					setCase(tabPieces[j],player);
					Coords marble=next_coord(tabPieces[j],k);
					setCase(marble,Color.EMPTY);
					j--;
				}
				break;
			}
		}
	}

	public String AvailableMoves(Color player)
	{
 		String Av_Moves="";
		Coords marble,marble2,marble3;
		for(int i=1;i<height;i++)
		{
			for(int j=1;j<width;j++)
			{
				tabPieces[0].x=i;
				tabPieces[0].y=j;
				if(!inTab(tabPieces[0]) || GameBoard[i][j].getColor()!=player)
					continue;
				else
				{
					for(Direction k : Direction.values()) //Cycle through neighbors
					{
						marble=next_coord(tabPieces[0],k);
						if(inTab(marble))
						{
							if(ally_next(tabPieces[0],k,player)==1) //groups of 2
							{
								tabPieces[1]=marble;
								if(ally_next(marble,k,player)==1)   // groups of 3
								{
									marble2=next_coord(marble,k);
									//if(inTab(marble2))
									{
										if(ally_next(marble2,k,switchPlayer(player))==1)
										{
											marble3=next_coord(marble2,k);
											if(ally_next(marble3,k,switchPlayer(player))==1)
											{
												if(free_next(next_coord(marble3,k),k) || !inTab(next_coord(next_coord(marble3,k),k))) // case of 3v3+ no move in this direction
												{
													tabPieces[2]=marble2;//sumito_3_2
													tabPieces[3].x=60+k.ordinal();     tabPieces[3].y=88;   //88 is code name for direction for debugging purposes,
													/*if(!inTab(next_coord(next_coord(marble3,k),k)))
													{tabPieces[4].x=1; tabPieces[4].y=0;}
													else
													{tabPieces[4].x=0; tabPieces[4].y=0;}*/
													Av_Moves=Av_Moves+MoveToString(tabPieces)+BroadsideMoves(tabPieces);         //we add the broadside moves
												}
											}
											else if(free_next(marble3,k) || !inTab(next_coord(marble3,k)))
											{
												tabPieces[2]=marble2;   //sumito_3_1
												tabPieces[3].x=50+k.ordinal();          tabPieces[3].y=88;       //88 is code name for direction for debugging purposes,
												/*
												if(!inTab(next_coord(marble3,k)))
												{tabPieces[4].x=1;  tabPieces[4].y=0;}               //Capture
												else
												{tabPieces[4].x=0;  tabPieces[4].y=0;}
												*/               //Attack
												Av_Moves=Av_Moves+MoveToString(tabPieces)+BroadsideMoves(tabPieces);        //we add the broadside moves
											}
										}
										else if(free_next(marble2,k) && inTab(next_coord(marble2,k)))
										{
											tabPieces[2]=marble2;    //simple_move
											tabPieces[3].x=30+k.ordinal();          tabPieces[3].y=88;
											//tabPieces[4].setCoords(0,0);          //no captures
											Av_Moves=Av_Moves+MoveToString(tabPieces)+BroadsideMoves(tabPieces);          //we add the broadside moves
										}
									}
								}
								else if(ally_next(marble,k,switchPlayer(player))==1)
								{

									if(free_next(next_coord(marble,k),k) || !inTab(next_coord(next_coord(marble,k),k)))
									{
										tabPieces[2].setCoords(22,22); // 22 is the code for irrelevant and other functions will ignore these slots
										tabPieces[3].setCoords(40+k.ordinal(),88); //sumito_2_1
										/*
										if(!inTab(next_coord(next_coord(marble,k),k)))
										{tabPieces[4].x=1;     tabPieces[4].y=0;}              //Capture
										else
										{tabPieces[4].x=0;     tabPieces[4].y=0;}              //Attack
										*/
										Av_Moves=Av_Moves+MoveToString(tabPieces)+BroadsideMoves(tabPieces);          //we add the broadside moves
									}
								}
								else if(free_next(marble,k) && inTab(next_coord(marble,k)))
								{
									tabPieces[2].setCoords(22,22);
									tabPieces[3].setCoords(30+k.ordinal(),88);
									//tabPieces[4].setCoords(0,0);          //no captures
									Av_Moves=Av_Moves+MoveToString(tabPieces)+BroadsideMoves(tabPieces);  // we add the broadside moves
								}
							}
						}
						if(free_next(tabPieces[0],k) && inTab(marble))
						{
							tabPieces[1].setCoords(22,22); // 22 is the code for irrelevant and other functions will ignore these slots
							tabPieces[2].setCoords(22,22);
							tabPieces[3].setCoords(30+k.ordinal(),88);//simple_move
							//tabPieces[4].setCoords(0,0); //no captures
							Av_Moves=Av_Moves+MoveToString(tabPieces);//no need for broadsides
						}
					}
				}
			}
		}
		return Av_Moves;
	}


//Implementation of generation of broadside moves

String BroadsideMoves(Coords[] tabPieces){

		String Bs_Moves="";
		Coords marble;
		//tabPieces[4].setCoords(0,0) ;          //no captures
		for(Direction k : Direction.values())
		{
			for(int i=0;i<3;i++)
			{

				if(tabPieces[i].x==22)
					continue;
				if(tabPieces[i].y==88)
				{
					tabPieces[i].x=70+k.ordinal();  // 70 for Broadside
					Bs_Moves=Bs_Moves+MoveToString(tabPieces);
				}
				if (find_direction(tabPieces[0],tabPieces[1])!=Direction.LEFT && find_direction(tabPieces[0],tabPieces[1])!=Direction.RIGHT)
				{
					marble=next_coord(tabPieces[i],k);
					if(!inTab(marble) || getCase(marble)!= Color.EMPTY)
						break;
				}
				if (find_direction(tabPieces[0],tabPieces[1])!=Direction.UPLEFT && find_direction(tabPieces[0],tabPieces[1])!=Direction.DOWNRIGHT)
				{
					marble=next_coord(tabPieces[i],k);
					if(!inTab(marble) || getCase(marble)!= Color.EMPTY)
						break;
				}
				if (find_direction(tabPieces[0],tabPieces[1])!=Direction.DOWNLEFT && find_direction(tabPieces[0],tabPieces[1])!=Direction.UPRIGHT)
				{
					marble=next_coord(tabPieces[i],k);
					if(!inTab(marble) || getCase(marble)!= Color.EMPTY)
						break;
				}
			}
		}
		return Bs_Moves;
	}

}