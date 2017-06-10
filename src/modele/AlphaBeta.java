package modele;
import modele.Config.Color;
import modele.Config.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 08/06/17.
 */
public class AlphaBeta {

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
    public AlphaBeta(Board b){
        this.b=b;
        zobristTableB=new HashMap<>();
        zobristTableW=new HashMap<>();
        score=new HashMap<>();
        for(int i=0;i<b.getHeight();i++)
            for(int j=0;j<b.getWidth();j++){
                zobristTableW.put(i*b.getWidth()+j,(int)Math.random()%10000);
                zobristTableB.put(i*b.getWidth()+j,(int)Math.random()%10000);
            }
    }
    int getPlayerVal(Color b){return b==Color.WHITE?1:-1;}
    int eval_adjacency(Color player)
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

    long eval_board(Color player)
    {
        long res=0;
        if(marble_count(Color.WHITE)<=8)
            return Integer.MIN_VALUE;  //losing case avoid at all costs
        if(marble_count(Color.BLACK)<=8)
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
        return getPlayerVal(player)*(res +eval_adjacency(player) + (marble_count(Color.WHITE)-marble_count(Color.BLACK))*500);
    }
    int marble_count(Color player)
    {
        int count=0;
        for(int i=0;i<b.getHeight();i++)
            for(int j=0;j<b.getWidth();j++)
                if(b.getCase(new Coords(i,j)) == player)
                    count++;
        return count;
    }
    String MoveOrdering(String moves)
    {
        String  sumito32A="";
        String  sumito32C="";
        String  sumito31A="";
        String  sumito31C="";
        String  sumito21A="";
        String  sumito21C="";
        String  broadside2="";
        String  broadside3="";
        String  simplemove1="";
        String  simplemove2="";
        String  simplemove3="";
        int type;
        for(int i=0;i<moves.length();i+=16)
        {
            type=Integer.parseInt(moves.substring(i+12,i+13));
            switch(type)
            {
                case 3 : {
                    if(Integer.parseInt(moves.substring(i+4,i+6))!=22)
                    {
                        if(Integer.parseInt(moves.substring(i+8,i+10))!=22)
                            simplemove3=simplemove3+moves.substring(i,i+16);
                        else
                            simplemove2=simplemove2+moves.substring(i,i+16);
                    }
                    else
                        simplemove1=simplemove1+moves.substring(i,i+16);
                    break;
                }
                case 4 : {
                    /*if(moves.substring(i+16,i+17),"A"))
                        sumito21A=concat(sumito21A,substr(moves,i,17));
                    else*/
                        sumito21C=sumito21C+moves.substring(i,i+16);
                    break;
                }
                case 5 : {
                    /*if(!strcmp(substr(moves,i+16,1),"A"))
                        sumito31A=concat(sumito31A,substr(moves,i,17));
                    else*/
                        sumito31C=sumito31C+moves.substring(i,i+16);
                    break;
                }
                case 6 : {
                    /*if(!strcmp(substr(moves,i+16,1),"A"))
                        sumito32A=concat(sumito32A,substr(moves,i,17));
                    else*/
                        sumito32C=sumito32C+moves.substring(i,i+16);
                    break;
                }
                case 7 : {
                    if(Integer.parseInt(moves.substring(i+8,i+10))!=22)
                        broadside3=broadside3+moves.substring(i,i+16);
                    else
                        broadside2=broadside2+moves.substring(i,i+16);
                    break;
                }
            }
        }
        return sumito32C+sumito31C+sumito21C+sumito32A+sumito31A+sumito21A
                +simplemove3+simplemove2+broadside3+broadside2+simplemove1;
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
    String alphaBeta(int deptG,int dept, int alpha, int beta,String current,Color player,Color main)
    {
        long eval=eval_board(main);
        //String moves= MoveOrdering(b.AvailableMoves(player));
        String moves=b.AvailableMoves(player);
        if(b.AvailableMoves(player).length()%16 != 0) {
            System.out.println(b.AvailableMoves(player));
            System.out.println(b.AvailableMoves(player).length());
        }
        int hash_id = hashZobrist() %900000;

        if(score.containsKey(hash_id) && !current.substring(0,16).equals(score.get(hash_id).substring(0,16)))
        {
            return score.get(hash_id);
        }
        if (dept==0 || moves.length()==0)
        {
            score.put(hash_id,current+eval);// we can always check
            return score.get(hash_id);
        }
        for(int i=0;i<moves.length();i+=16)
        {
            //System.out.println(dept+" of "+i+" string "+moves.substring(i,i+16));
            b.executeMove(b.stringToMove(moves.substring(i,i+16)),player);
            String returnString= alphaBeta(deptG,dept-1, alpha, beta,moves.substring(i,i+16), b.switchPlayer(player),main);
            int value = Integer.parseInt(returnString.substring(16));
            b.undo(b.stringToMove(moves.substring(i,i+16)),player);
            if (player==b.switchPlayer(main)){
                if (value<=beta)
                {
                    beta=value;
                    if (dept==deptG)
                    {
                        current=returnString.substring(0,16);
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
                        current=returnString.substring(0,16);
                    }
                }
            }
            if (alpha>=beta)
            {
                if (player==b.switchPlayer(main))
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
        if (player==b.switchPlayer(main))
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

    int hashZobrist()
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
                    hash=hash^ zobristTableB.get(i*b.getWidth()+j);
                }

            }
        return hash;
    }

}
