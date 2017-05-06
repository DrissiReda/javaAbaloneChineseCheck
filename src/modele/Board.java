package modele;

public class Board {
    private Tile GameBoard[][];

    public Board(int height,int width) {
        GameBoard = new Tile[height][width];
        for (int j = 0; j < 11; j++)
            Tile[0][j] = new Tile(((j % 2) == 0 ? ILLEGAL : EMPTY));
        for (int j = 0; j < 11; j++)
            Tile[height-1][j] = new Tile(((j % 2) == 0 ? ILLEGAL : EMPTY));
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                Tile[5-i][j] = new Tile((((i + j) % 2) == 0 ? ILLEGAL : EMPTY));
                Tile[5-i][width - j-1] = new Tile((((i + j) % 2) == 0 ? ILLEGAL : EMPTY));
            }
            for (int j=i;j<width-i-1;j++){
                Tile[5-i][j] = new Tile((((i + j) % 2) == 0 ? WHITE : EMPTY));
                Tile[5-i][width - j-1] = new Tile((((i + j) % 2) == 0 ? WHITE : EMPTY));
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                Tile[5+i][j] = new Tile((((i + j) % 2) == 0 ? ILLEGAL : EMPTY));
                Tile[5+i][width - j-1] = new Tile((((i + j) % 2) == 0 ? ILLEGAL : EMPTY));
            }
            for (int j=i;j<width-i-1;j++){
                Tile[5+i][j] = new Tile((((i + j) % 2) == 0 ? BLACK : EMPTY));
                Tile[5+i][width - j-1] = new Tile((((i + j) % 2) == 0 ? BLACK : EMPTY));
            }
        }
    }
}