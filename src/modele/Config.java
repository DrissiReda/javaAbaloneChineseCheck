package modele;

public class Config {
	
	public enum Color {
		ILLEGAL,
		EMPTY,
		BLACK,
		WHITE,
		RED,
		GREEN,
		BLUE,
		YELLOW;
		public Color getNext(Color k){
			return k.ordinal()<values().length - 1
					? values()[k.ordinal()+1]
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
		public Direction getNext(Direction k){
			return k.ordinal()<values().length - 1
					? values()[k.ordinal()+1]
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
		public Area getNext(Area k){
			return k.ordinal()<values().length - 1
					? values()[k.ordinal()+1]
					: NORTH;
		}
	}
}
