package modele;

import modele.Config.Color;

public class Config {
	
	public enum Color {
		ILLEGAL(0),
		EMPTY(1),
		BLACK(2),
		WHITE(3),
		RED(4),
		GREEN(5),
		BLUE(6),
		YELLOW(7);
		private int val;
		Color(int v){val=v;}
		public Color getNext(){
			return this.ordinal()<values().length - 1
					? values()[this.ordinal()+1]
					: BLACK;
		}
	}
	
	public enum Direction {
		LEFT(0),
		RIGHT(1),
		UPLEFT(2),
		DOWNRIGHT(3),
		UPRIGHT(4),
		DOWNLEFT(5);
		
		private int val;
		Direction(int val){
			this.val = val;
		}
		public Direction getNext(){
			return this.ordinal()<values().length - 1
					? values()[this.ordinal()+1]
					: LEFT;
		}
	}
	
	// Diff?rents coins du plateau de dames chinoises
	public enum Area {
		NORTH,
		NORTHEAST,
		SOUTHEAST,
		SOUTH,
		SOUTHWEST,
		NORTHWEST;
		public Area getNext(){
			return this.ordinal()<values().length - 1
					? values()[this.ordinal()+1]
					: NORTH;
		}
	}
	
	private static Tile belgian[][]={{new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
            {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
            {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
            {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
            {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
            {new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.BLACK  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL)},
            {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
            {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.RED  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.EMPTY  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
            {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
            {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.WHITE  ),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
            {new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL),new Tile(Color.ILLEGAL)},
            };
	private static Tile allienage[][]={{}};
	
	public static Tile[][] getBoard(String mode){
		if(mode == "belgian")
			return belgian;
		return allienage;
	}
	
}
