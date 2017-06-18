package controleur;

import modele.BoardDC;
import modele.Config.Direction;
import modele.Coords;
import modele.Config.Color;
import modele.IA;

import java.util.Random;
//import vue.FenetreDame;


public class TestDC {

    public static void main(String[] args)  {
        BoardDC p=new BoardDC();
        p.addPlayer();
        p.addPlayer();
        p.addPlayer();
        p.initBoard();
        p.displayBoard();
        System.out.println(p.getCase(new Coords(5,5)));
        for(Color k : Color.values())
            if(k!=Color.EMPTY && k!=Color.ILLEGAL)
                System.out.println(p.AvailableMoves(k));
        //Coords[] tP={new Coords(14,14)};
        for(Coords k : p.generateTarget(new Coords(5,3)))
            System.out.println("Th "+k);
        IA a=new IA(p);
        //System.out.println(a.alphaBeta(3,3,Integer.MIN_VALUE,Integer.MAX_VALUE,"",Color.WHITE,Color.WHITE));
        System.out.println("######################");
        Random rand =new Random();
        System.out.println(rand.nextInt(233333)+"  "+rand.nextInt(233333));
    }

}