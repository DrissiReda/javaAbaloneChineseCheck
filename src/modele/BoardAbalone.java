package modele;
import modele.Config.Color;
import modele.Config.Direction;

import java.util.ArrayList;

public class BoardAbalone extends Board{
	
	public Coords[] tabPieces = new Coords[5];
	public Color player = Color.WHITE;

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
    

    public BoardAbalone() {
		super(11, 19,17);
		initTabPieces();
	}
    
    public BoardAbalone(int h, int w, int m) {
    	super(h, w, m);
		initTabPieces();
    }
    
    public int getMoveSize(){
    	return moveSize;
    }
	public Color getCase(Coords pos){
		return GameBoard[pos.x][pos.y].getColor();
	}
	public void setCase(Coords pos, Color c){
		GameBoard[pos.x][pos.y].setColor(c);
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
    	for (int i = 0; i <= 4; i++){
    		defaultPos = new Coords(22, 22);
    		tabPieces[i] = i == 3 ? defaultDir : defaultPos;
    	}
    }

    public void printTabPieces()
    {

    	System.out.print("Pi?ces s?lectionn?es : ");
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
    		System.out.println("Non definie");
    }
    
    public int nbPiece()
    {
    	int nb = 0;
    	for(int i = 0; i < 3; i++){ // Parcours des cases pour les pions (les 3 premi?res)
    		if(tabPieces[i].x != 22)
    			nb++;
    		else
    			break;
    	}
    	return nb;
    }
    
    public boolean selectMarble(Coords pos)
    {
    	// Verifie que le pion n'est pas deja selectionne et est valide
    	if(checkSelected(pos) && isMarble(pos) && isValid(pos)){
    		// Recherche une place disponible dans le tableau
    		for (int i = 0; i < 3; i++){
    			if(tabPieces[i].x == 22){
    				tabPieces[i].x = pos.x;
    				tabPieces[i].y = pos.y;
    				return true;
    			}
    		}
    	}
    	return false; //Pas de place disponible ou pion d?j? s?lectionn?
    }
    
    // Ici il faut voir si on doit reset aussi le mouvement ecrit ou pas
    public void cancelSelection()
    {
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
    
    /**
     * Retourne true si le pion n'est pas selectionne, false s'il l'est deja.
     * @param position
     * @return
     */
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

    			isEmpty = false;
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
    	
    	/* Dans le cas o? deux pions ont d?j? ?t? s?lectionn?s il faut
    	 * s'assurer que le troisi?me soit plac? dans la continuit? */ 
    	
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
				new Coords(str.substring(16,17).equals("C")?1:0,22)	};
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
		if(tab[4].x==1)
			ret=ret+"C";
		else ret=ret+"A";
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

    public void switchPlayer(){
    	if(this.player==Color.BLACK){
    		this.player=Color.WHITE;
		}
		else{
			this.player=Color.BLACK;
		}
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
    
    public Boolean executeMove(Coords tabPieces[], Color player){
    	int type = tabPieces[3].x/10;
    	
    	switch(type){
    		case 3 : simple_move(tabPieces, player); return true;
    		case 4 : sumito_2_1(tabPieces, player); return true;
    		case 5 : sumito_3_1(tabPieces, player); return true;
    		case 6 : sumito_3_2(tabPieces, player); return true;
    		case 7 : broadside(tabPieces, player); return true;
    		default : return false;
    	}
    }
    public boolean undo(Coords tabPieces[],Color player)
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
				return true;
			}
			case 4 :   {    // sumito_2_1
				Coords marble        = next_coord(tabPieces[1],k);
				Coords marble2       = next_coord(marble,k);
				setCase(marble,switchPlayer(player));
				if(inTab(marble2))
					setCase(marble2,Color.EMPTY);
				setCase(tabPieces[0],player);
				return true;
			}
			case 5 :   {  //  sumito_3_1
				// only difference between 4 and 5 is here j is going to be bigger by one
				Coords marble        = next_coord(tabPieces[2],k);
				Coords marble2       = next_coord(marble,k);
				setCase(marble,switchPlayer(player));
				if(inTab(marble2))
					setCase(marble2,Color.EMPTY);
				setCase(tabPieces[0],player);
				return true;
			}
			case 6 :   {  // sumito_3_2
				// same thing but we go marbles deeper (1 step)
				Coords marble          = next_coord(tabPieces[2],k);
				Coords marble3         = next_coord(next_coord(marble,k),k);
				setCase(marble,switchPlayer(player));
				if(inTab(marble3))
					setCase(marble3,Color.EMPTY);
				setCase(tabPieces[0],player);
				return true;
			}
			case 7 :   {           // broadside same as simple_move
				while(j>=0)
				{
					setCase(tabPieces[j],player);
					Coords marble=next_coord(tabPieces[j],k);
					setCase(marble,Color.EMPTY);
					j--;
				}
				return true;
			}
		}
		return false;
	}

	public String AvailableMoves(Color player)
	{
 		String Av_Moves="";
		Coords marble,marble2,marble3;
		Coords[] tabPieces={new Coords(22,22),new Coords(22,22),new Coords(22,22),new Coords(88,88),new Coords(22,22)};
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
								Av_Moves=Av_Moves+BroadsideMoves(tabPieces);
								if(ally_next(marble,k,player)==1)   // groups of 3
								{
									marble2=next_coord(marble,k);
									tabPieces[2]=marble2;
									Av_Moves=Av_Moves+BroadsideMoves(tabPieces);
									//if(inTab(marble2))
									{
										if(ally_next(marble2,k,switchPlayer(player))==1)
										{
											marble3=next_coord(marble2,k);
											if(ally_next(marble3,k,switchPlayer(player))==1)
											{

												if(free_next(next_coord(marble3,k),k) || !inTab(next_coord(next_coord(marble3,k),k))) // case of 3v3+ no move in this direction
												{
													//sumito_3_2
													tabPieces[3].x=60+k.ordinal();     tabPieces[3].y=88;   //88 is code name for direction for debugging purposes,
													if(!inTab(next_coord(next_coord(marble3,k),k)))
													{tabPieces[4].x=1; tabPieces[4].y=0;} //Capture
													else
													{tabPieces[4].x=0; tabPieces[4].y=0;}
													Av_Moves=Av_Moves+MoveToString(tabPieces);         //we add the broadside moves
												}
											}
											else if(free_next(marble3,k) || !inTab(next_coord(marble3,k)))
											{
												  //sumito_3_1
												tabPieces[3].x=50+k.ordinal();          tabPieces[3].y=88;       //88 is code name for direction for debugging purposes,

												if(!inTab(next_coord(marble3,k)))
												{tabPieces[4].x=1;  tabPieces[4].y=0;}               //Capture
												else
												{tabPieces[4].x=0;  tabPieces[4].y=0;}
												             //Attack
												Av_Moves=Av_Moves+MoveToString(tabPieces);        //we add the broadside moves
											}
										}
										else if(free_next(marble2,k) && inTab(next_coord(marble2,k)))
										{
											tabPieces[2]=marble2;    //simple_move
											tabPieces[3].x=30+k.ordinal();          tabPieces[3].y=88;
											tabPieces[4].setCoords(0,0);          //no captures
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

										if(!inTab(next_coord(next_coord(marble,k),k)))
										{tabPieces[4].x=1;     tabPieces[4].y=0;}              //Capture
										else
										{tabPieces[4].x=0;     tabPieces[4].y=0;}              //Attack

										Av_Moves=Av_Moves+MoveToString(tabPieces);          //we add the broadside moves
									}
								}
								else if(free_next(marble,k) && inTab(next_coord(marble,k)))
								{
									tabPieces[2].setCoords(22,22);
									tabPieces[3].setCoords(30+k.ordinal(),88);
									tabPieces[4].setCoords(0,0);          //no captures
									Av_Moves=Av_Moves+MoveToString(tabPieces)+BroadsideMoves(tabPieces);  // we add the broadside moves
								}
							}
						}
						if(free_next(tabPieces[0],k) && inTab(marble))
						{
							tabPieces[1].setCoords(22,22); // 22 is the code for irrelevant and other functions will ignore these slots
							tabPieces[2].setCoords(22,22);
							tabPieces[3].setCoords(30+k.ordinal(),88);//simple_move
							tabPieces[4].setCoords(0,0); //no captures
							Av_Moves=Av_Moves+MoveToString(tabPieces);//no need for broadsides
						}
					}
				}
			}
		}
		return Av_Moves;
	}


//Implementation of generation of broadside moves

public String BroadsideMoves(Coords[] tabPieces){

		String Bs_Moves="";
		Coords marble;
		tabPieces[4].setCoords(0,0) ;          //no captures
		for(Direction k : Direction.values())
		{
			for(int i=0;i<4;i++)
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

	public String MoveOrdering(Color player)
	{
		String moves=AvailableMoves(player);
		String  sumito32A="";
		String  sumito32C="";
		String  sumito31A="";
		String  sumito31C="";
		String  sumito21A="";
		String  sumito21C="";
		String  broadside2="";
		String  broadside3="";
		String  simplemove1="";
		String  simplemove2="";
		String  simplemove3="";
		int type;
		for(int i=0;i<moves.length();i+=moveSize)
		{
			type=Integer.parseInt(moves.substring(i+12,i+13));
			switch(type)
			{
				case 3 : {
					if(Integer.parseInt(moves.substring(i+4,i+6))!=22)
					{
						if(Integer.parseInt(moves.substring(i+8,i+10))!=22)
							simplemove3=simplemove3+moves.substring(i,i+moveSize);
						else
							simplemove2=simplemove2+moves.substring(i,i+moveSize);
					}
					else
						simplemove1=simplemove1+moves.substring(i,i+moveSize);
					break;
				}
				case 4 : {
                    if(moves.substring(i+16,i+moveSize).equals("A"))
                        sumito21A=sumito21A+moves.substring(i,i+moveSize);
                    else
						sumito21C=sumito21C+moves.substring(i,i+moveSize);
					break;
				}
				case 5 : {
                    if(moves.substring(i+16,i+moveSize).equals("A"))
                        sumito31A=sumito31A+moves.substring(i,i+moveSize);
                    else
						sumito31C=sumito31C+moves.substring(i,i+moveSize);
					break;
				}
				case 6 : {
                    if(moves.substring(i+16,i+moveSize).equals("A"))
                        sumito32A=sumito32A+moves.substring(i,i+moveSize);
                    else
						sumito32C=sumito32C+moves.substring(i,i+moveSize);
					break;
				}
				case 7 : {
					if(Integer.parseInt(moves.substring(i+8,i+10))!=22)
						broadside3=broadside3+moves.substring(i,i+moveSize);
					else
						broadside2=broadside2+moves.substring(i,i+moveSize);
					break;
				}
			}
		}
		return sumito32C+sumito31C+sumito21C+sumito32A+sumito31A+sumito21A
				+simplemove3+simplemove2+broadside3+broadside2+simplemove1;
	}

	public int marble_count(Color player)
	{
		int count=0;
		for(int i=0;i<getHeight();i++)
			for(int j=0;j<getWidth();j++)
				if(getCase(new Coords(i,j)) == player)
					count++;
		return count;
	}
	public Color winner(){
		if(marble_count(Color.BLACK)<=8)
			return Color.WHITE;
		if(marble_count(Color.WHITE)<=8)
			return Color.BLACK;
		return null;
	}

	public Coords[] generateMove(Coords[] tP,Color player){
	    String move=MoveOrdering(player);
	    ArrayList<Coords[]> ls=generateOrder(tP);
	    for(int i=0;i<move.length();i+=moveSize){
	    	for(Coords [] tabPieces : ls)
	        	if(MoveToString(tabPieces).substring(0,12).equals(move.substring(i,i+12))
                	&& MoveToString(tabPieces).substring(13,moveSize-1).equals(move.substring(i+13,i+moveSize-1)))
	            		return stringToMove(move.substring(i,i+moveSize));
        }
		System.out.println("RETOUR NULL");
        return null;
    }
    public void swap(Coords m1,Coords m2){
		Coords tp=new Coords(0,0);
		tp.x=m1.x; tp.y=m1.y;
		m1.x=m2.x; m1.y=m2.y;
		m2.x=tp.x; m2.y=tp.y;

	}
    public ArrayList<Coords[]> generateOrder(Coords[] tP){
		ArrayList<Coords[]> ret= new ArrayList<>();
		Coords[] tabPieces = tP;
		System.out.println(MoveToString(tabPieces));
		if(tabPieces[1].x==22){
			ret.add(tP);
			return ret;
		}
		int i,j,k=0;
		for(i=0;i<=2;i++){
			for(j=0;j<=2;j++){
				if(j==i || j==k)
					continue;
				for(k=0;k<=2;k++){
					if(k==i || k==j)
						continue;
					Coords[] tmp={tP[i],tP[j],tP[k],tP[3],new Coords(0,0)};
					ret.add(tmp);
				}
			}
		}
		return ret;
	}
	public ArrayList<Direction> generateDir(){
		String move=MoveOrdering(player);
		ArrayList<Direction> ret=new ArrayList<>();
		ArrayList<Coords[]> ls=generateOrder(tabPieces);
		for(int i=0;i<move.length();i+=moveSize) {
			for (Coords[] tP : ls) {
				if (MoveToString(tP).substring(0, 12).equals(move.substring(i, i + 12)))
					ret.add(toDir(Integer.parseInt(move.substring(i + 13, i + 14))));
			}
		}
		return ret;
	}
	public Coords[] getTabPieces() {
		return tabPieces;
	}

	public void setTabPieces(Coords[] tabPieces) {
		this.tabPieces = tabPieces;
	}

    public Color getPlayer() {
        return player;
    }
}