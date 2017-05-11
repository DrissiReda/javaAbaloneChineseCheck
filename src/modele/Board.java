package modele;
import modele.Config.Color;
import modele.Config.Direction;
public class Board {
    private Tile GameBoard[][];

    public Color getCase(int i,int j){
        return GameBoard[i][j].getColor();
    }
    public void SetCase(int i,int j,Color c){
        GameBoard[i][j].setColor(c);
    }
    
    public Board(int height,int width) {
        GameBoard = new Tile[height][width];
        for (int j = 0; j < 11; j++)
            GameBoard[0][j] = new Tile(((j % 2) == 0 ?Color.ILLEGAL : Color.EMPTY));
        for (int j = 0; j < 11; j++)
            GameBoard[height-1][j] = new Tile(((j % 2) == 0 ? Color.ILLEGAL : Color.EMPTY));
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                GameBoard[5-i][j] = new Tile((((i + j) % 2) == 0 ? Color.ILLEGAL : Color.EMPTY));
                GameBoard[5-i][width - j-1] = new Tile((((i + j) % 2) == 0 ? Color.ILLEGAL : Color.EMPTY));
            }
            for (int j=i;j<width-i-1;j++){
                GameBoard[5-i][j] = new Tile((((i + j) % 2) == 0 ? Color.WHITE : Color.EMPTY));
                GameBoard[5-i][width - j-1] = new Tile((((i + j) % 2) == 0 ? Color.WHITE : Color.EMPTY));
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                GameBoard[5+i][j] = new Tile((((i + j) % 2) == 0 ? Color.ILLEGAL : Color.EMPTY));
                GameBoard[5+i][width - j-1] = new Tile((((i + j) % 2) == 0 ? Color.ILLEGAL : Color.EMPTY));
            }
            for (int j=i;j<width-i-1;j++){
                GameBoard[5+i][j] = new Tile((((i + j) % 2) == 0 ? Color.BLACK : Color.EMPTY));
                GameBoard[5+i][width - j-1] = new Tile((((i + j) % 2) == 0 ? Color.BLACK : Color.EMPTY));
            }
        }
    }
    
    public void displayBoard()
    {
    	for(int i = 0; i < 11; i++){
    		for(int j = 0; j < 19; j++){
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
    
    // Moves
    
    public void sumito_2_1(Coords pieces[], int player){
    	//Direction k = (Direction)pieces[3].x%10;
    }
    public void sumito_3_1(Coords pieces, int player){
    	
    }
    public void sumito_3_2(Coords pieces, int player){
    	
    }
    public void broadside(Coords pieces, int player){
    	
    }
    public void simple_move(Coords pieces, int player){
    	
    }
}