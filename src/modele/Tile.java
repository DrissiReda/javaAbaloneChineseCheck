package modele;

public class Tile{
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
	
	private Color color;
	
	public Tile(Color color){
		this.color = color;
	}

}
