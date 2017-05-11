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
		YELLOW
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
	};
}
