package modele;

import modele.Config.Color;

public class Tile{
	
	private Color color;

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
