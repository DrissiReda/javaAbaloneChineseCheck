package modele;

public class Board {
    private Tile GameBoard[][];
    public Board(){
        GameBoard = new Tile[11][19];
        for(int i=0;i<11;i++)
            for(int j=0;j<19;j++)

    }
}
