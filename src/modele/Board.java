package modele;
import modele.Config.Color;
public class Board {
    private Tile GameBoard[][];

    public Board(int height, int width) {
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
}