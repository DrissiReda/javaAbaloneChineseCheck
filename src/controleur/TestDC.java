package controleur;

import modele.BoardDC;
import modele.Config.Direction;
import modele.Coords;
import modele.Config.Color;
//import vue.FenetreDame;


public class TestDC {

    public static void main(String[] args)  {
        BoardDC p=new BoardDC();
        p.addPlayer();
        p.addPlayer();
        p.addPlayer();
        p.initBoard();
        p.affichePlateau();
        System.out.println(p.getCase(new Coords(14,16)));
        for(Color k : Color.values())
            if(k!=Color.EMPTY && k!=Color.ILLEGAL)
                System.out.println(p.AvailableMoves(k));
        //Coords[] tP={new Coords(14,14)};
        for(Coords k : p.generateTarget(new Coords(14,10)))
            System.out.println("Th "+k);
    }

}