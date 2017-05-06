package modele;

public class Tile{
	
	private Color color;
	
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

	public Tile(Color color){
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
