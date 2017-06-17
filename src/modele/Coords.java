package modele;

public class Coords {
	public int x;
	public int y;
	
	public Coords(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setCoords(Coords a){
		x=a.x;
		y=a.y;
	}
	public void setCoords(int a, int b)
	{
		x = a;
		y = b;
	}
}
