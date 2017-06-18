package modele;
import modele.Config.Color;
import modele.Config.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by root on 08/06/17.
 */
public class IA {

    Board b;
    Map<Integer,Integer> zobristTableW;
    Map<Integer,Integer> zobristTableB;
    Map<Integer,String> score;
    int ABweight[][] =
    {
        {0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {0,   0,   0,   0,   0, 100,   0, 100,   0, 100,   0, 100,   0, 100,   0,   0,   0,   0,   0},
        {0,   0,   0,   0, 100,   0, 500,   0, 500,   0, 500,   0, 500,   0, 100,   0,   0,   0,   0},
        {0,   0,   0, 100,   0, 500,   0, 750,   0, 750,   0, 750,   0, 500,   0, 100,   0,   0,   0},
        {0,   0, 100,   0, 500,   0, 760,   0, 850,   0, 850,   0, 760,   0, 500,   0, 100,   0,   0},
        {0, 100,   0, 500,   0, 770,   0, 850,   0,1000,   0, 850,   0, 770,   0, 500,   0, 100,   0},
        {0,   0, 100,   0, 500,   0, 760,   0, 850,   0, 850,   0, 760,   0, 500,   0, 100,   0,   0},
        {0,   0,   0, 100,   0, 500,   0, 750,   0, 750,   0, 750,   0, 500,   0, 100,   0,   0,   0},
        {0,   0,   0,   0, 100,   0, 500,   0, 500,   0, 500,   0, 500,   0, 100,   0,   0,   0,   0},
        {0,   0,   0,   0,   0, 100,   0, 100,   0, 100,   0, 100,   0, 100,   0,   0,   0,   0,   0},
        {0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0}

    };
    int DCdistance[][] =
            {
                      //0            //5                  //10                //15                //20                //25
                    {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                    {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                    {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  9,  0,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                    {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 18,  0, 10,  0,  2,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                    {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 27,  0, 19,  0, 11,  0,  3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                    {  0, 97,  0, 95,  0, 93,  0, 90,  0, 36,  0, 28,  0, 20,  0, 12,  0,  4,  0, 90,  0, 93,  0, 95,  0, 97,  0},
                    {  0,  0, 95,  0, 93,  0, 90,  0, 45,  0, 37,  0, 29,  0, 21,  0, 13,  0,  5,  0, 90,  0, 93,  0, 95,  0,  0},
                    {  0,  0,  0, 93,  0, 90,  0, 54,  0, 46,  0, 38,  0, 30,  0, 22,  0, 14,  0,  6,  0, 90,  0, 93,  0,  0,  0},
                    {  0,  0,  0,  0, 90,  0, 63,  0, 55,  0, 47,  0, 39,  0, 31,  0, 23,  0, 15,  0,  7,  0, 90,  0,  0,  0,  0},
                    {  0,  0,  0,  0,  0, 72,  0, 64,  0, 56,  0, 48,  0, 40,  0, 32,  0, 24,  0, 16,  0,  8,  0,  0,  0,  0,  0},
                    {  0,  0,  0,  0, 90,  0, 73,  0, 65,  0, 57,  0, 49,  0, 41,  0, 33,  0, 25,  0, 17,  0, 90,  0,  0,  0,  0},
                    {  0,  0,  0, 93,  0, 90,  0, 74,  0, 66,  0, 58,  0, 50,  0, 42,  0, 34,  0, 26,  0, 90,  0, 93,  0,  0,  0},
                    {  0,  0, 95,  0, 93,  0, 90,  0, 75,  0, 67,  0, 59,  0, 51,  0, 43,  0, 35,  0, 90,  0, 93,  0, 95,  0,  0},
                    {  0, 97,  0, 95,  0, 93,  0, 90,  0, 76,  0, 68,  0, 60,  0, 52,  0, 44,  0, 90,  0, 93,  0, 95,  0, 97,  0},
                    {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 77,  0, 69,  0, 61,  0, 53,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                    {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 78,  0, 70,  0, 62,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                    {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 79,  0, 71,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                    {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 80,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}
            };
    public IA(Board b){
        this.b=b;
        Random rand=new Random();
        zobristTableB=new HashMap<>();
        zobristTableW=new HashMap<>();
        score=new HashMap<>();
        for(int i=0;i<b.getHeight();i++)
            for(int j=0;j<b.getWidth();j++){
                zobristTableW.put(i*b.getWidth()+j,rand.nextInt(Integer.MAX_VALUE));
                zobristTableB.put(i*b.getWidth()+j,rand.nextInt(Integer.MAX_VALUE));
            }
    }
    private int getPlayerVal(Color b){return (b==Color.WHITE)?1:-1;}

    private int eval_distance(Color player){
        int res=0;
        for(int i=0;i<b.getHeight();i++)
            for(int j=0;j<b.getWidth();j++)
                if(b.getCase(new Coords(i,j))==player)
                    res+=DCdistance[i][j]*50;
                else if(b.getCase(new Coords(i,j))==b.switchPlayerIA(player))
                    res+=DCdistance[i][j]-17*50;
        return res;
    }
    private int eval_adjacency(Color player)
    {
        int res=0;
        //initialisation du tableau de visites
        ArrayList<Boolean> visitor=new ArrayList<>();
        for(int i=0;i<b.getWidth()*b.getHeight();i++)
            visitor.add(false);
        for(int i=0;i<b.getHeight();i++)
        {
            for(int j=0;j<b.getWidth();j++)
            {
                Coords marble=new Coords(i,j);
                if(b.inTab(marble) && b.getCase(marble)!=Color.EMPTY )
                {

                    for(Direction k :Direction.values())
                    {
                        if(b.ally_next(marble,k,b.getCase(marble))==1 && visitor.get(i*b.getWidth()+j))
                        {
                            visitor.set(i*b.getWidth()+j,true);
                            res+= getPlayerVal(b.getCase(new Coords(i,j)))*100;
                        }
                    }
                }
            }
        }
        return res;
    }
    public long eval_board(Color player){
        if(b instanceof BoardAbalone)
            return eval_AB(player);
        if(b instanceof BoardDC)
            return eval_DC(player);
        return Long.parseLong(null);
    }
    public long eval_DC(Color player){
        long res=0;
        if(b.marble_count(player)>=10)
            return Integer.MAX_VALUE;
        if(b.marble_count(b.switchPlayerIA(player))>=10)
            return Integer.MIN_VALUE;
        return getPlayerVal(player)*(eval_distance(player)+(b.marble_count(player)-b.marble_count(b.switchPlayerIA(player)))*2000);
    }

    public long eval_AB(Color player)
    {
        long res=0;
        if(b.marble_count(Color.WHITE)<=8)
            return Integer.MIN_VALUE;  //losing case avoid at all costs
        if(b.marble_count(Color.BLACK)<=8)
            return  Integer.MAX_VALUE;  //winning case attain at all costs
        for(int i=0;i<b.getHeight();i++)
        {
            for(int j=0;j<b.getWidth();j++)
            {
                Coords marble= new Coords(i,j);
                if(b.inTab(marble))
                    res+=getPlayerVal(b.getCase(marble))*ABweight[i][j];
            }
        }
        return getPlayerVal(player)*(res +eval_adjacency(player) + (b.marble_count(Color.WHITE)-b.marble_count(Color.BLACK))*50000);
    }

 

///////////////////////////////////////////////////////////////////////

    //just display, most boring function

/////////////////////////////////////////////////////////////////////

    /*void init_display()
    {
        int i,j;
        for (i=0;i<HEIGHT;i++)
        {
            for(j=0;j<WIDTH;j++)
            {
                tiles[i][j]=tilesempty[i][j];
                if(tiles[i][j]!=1 && tiles[i][j]!=-1)
                    if(tiles[i][j]==0)
                        printf(" . ");
                    else
                        printf("   ");
                else
                    printf(" %d ",tiles[i][j]);
                zobristTable[i*WIDTH+j][0]= rand()%10000;
                zobristTable[i*WIDTH+j][1]= rand()%10000;
            }
            printf("\n");
        }
    }
    void display()
    {
        printf("______________________________________\n__________________________________________\n__________________________________\n");
        int i,j;
        for (i=0;i<HEIGHT;i++)
        {
            for(j=0;j<WIDTH;j++)
            {
                if(tiles[i][j]!=1 && tiles[i][j]!=-1)
                    if(tiles[i][j]==0)
                        printf(" . ");
                    else
                        printf("   ");
                else
                    printf(" %c ",tiles[i][j]==1 ? 'W' : 'B');
            }
            printf("\n");
        }
    }*/

//TODO implement a fully functional tail recursion to avoid stack overflow
//TODO something is wrong with undo and causes a butterfly effect : fixed
//TODO figure out the cause of the memory leak
//TODO improve move ordering with A/C into consideration
//TODO improve eval_board accuracy
//(*)  current has the best move + the score to maximize or minimize
//(*)  main keeps track of the player wanting to make the smart move, crucial to differentiate
//     evaluations, as maximizing/minimizing should be done for the same respective player throughout
//     the lifetime of the function
    public String alphaBeta(int deptG,int dept, int alpha, int beta,String current,Color player,Color main)
    {
        long eval=eval_board(main);
        String moves= b.MoveOrdering(player);
        //String moves=b.AvailableMoves(player);
        if(b.AvailableMoves(player).length()%b.moveSize != 0) {
            System.out.println(b.AvailableMoves(player));
            System.out.println(b.AvailableMoves(player).length());
        }
        int hash_id = hashZobristAB();

        if(score.containsKey(hash_id) && current.substring(0,b.moveSize).equals(score.get(hash_id).substring(0,b.moveSize)))
        {
            return score.get(hash_id);
        }
        if (dept==0 || moves.length()==0)
        {
            score.put(hash_id,current+eval);// we can always check
            return score.get(hash_id);
            //return current+eval;
        }
        for(int i=0;i<(moves.length()>(b.moveSize*17)?b.moveSize*17:moves.length());i+=b.moveSize)
        {
            //System.out.println(dept+" of "+i+" string "+moves.substring(i,i+b.moveSize));
            b.executeMove(b.stringToMove(moves.substring(i,i+b.moveSize)),player);
            String returnString= alphaBeta(deptG,dept-1, alpha, beta,moves.substring(i,i+b.moveSize), b.switchPlayerIA(player),main);
            int value = Integer.parseInt(returnString.substring(b.moveSize));
            b.undo(b.stringToMove(moves.substring(i,i+b.moveSize)),player);
            if (player==b.switchPlayerIA(main)){
                if (value<=beta)
                {
                    beta=value;
                    if (dept==deptG)
                    {
                        current=returnString.substring(0,b.moveSize);
                    }
                }
            }
            else
            {
                if (value>alpha)
                {
                    alpha=value;
                    if(dept==deptG)
                    {
                        current=returnString.substring(0,b.moveSize);
                    }
                }
            }
            if (alpha>=beta)
            {
                if (player==b.switchPlayerIA(main))
                {
                    current=current+beta;
                    return current;
                }
                else
                {
                    current=current+alpha;
                    return current;
                }
            }
        }
        if (player==b.switchPlayerIA(main))
        {
            current=current+beta;
            return current;
        }
        else
        {
            current=current+alpha;
            return current;
        }
    }

    public int hashZobristAB()
    {
        int hash=0;
        for(int i=0;i<b.getHeight();i++)
            for(int j=0;j<b.getWidth();j++)
            {
                if(b.getCase(new Coords(i,j))==Color.WHITE)
                {
                    hash=hash ^ zobristTableW.get(i*b.getWidth()+j);
                }
                if(b.getCase(new Coords(i,j))==Color.BLACK)
                {
                    hash=hash ^ zobristTableB.get(i*b.getWidth()+j);
                }

            }
        return hash;
    }

}
