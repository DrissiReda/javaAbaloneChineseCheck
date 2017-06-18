package vue;
import modele.Board;
import modele.BoardAbalone;
import modele.BoardDC;
import modele.Coords;
import modele.Config.Color;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Fenetre extends JFrame {

    private Panneau pan;


    public Fenetre() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, FileNotFoundException, IOException{
    	
    	UIManager.setLookAndFeel(
				UIManager.getSystemLookAndFeelClassName());
        this.setTitle("ABALONE");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
       // this.setContentPane(pan);
        this.setVisible(true);
        
        
        launch_interface();
    }

    // Fonctions interfaces principales
    
    public void launch_interface()
	{
		Panneau panel1 = new Panneau();
		panel1.setBounds(0,0,1000,600);
		this.getContentPane().add(panel1);		
	}
    
    // Fonctions Abalone
    public void refreshBoard(){
        pan.refreshBoard();
    }

    public void copyTab(Board b){
        pan.copyTab((BoardAbalone)b);
    }

    public void setMarbleLeftBlack(int marbleLeftBlack) {
        pan.setMarbleLeftBlack(marbleLeftBlack);
    }

    public void setMarbleLeftWhite(int marbleLeftWhite) {
        pan.setMarbleLeftWhite(marbleLeftWhite);
    }

    public int getConfirmDirection() {
        return pan.getConfirmDirection();
    }

    public void reInit(){
        pan.reInit();
    }

    public Coords[] getTabPieces() {
        return pan.getTabPieces();
    }

    public int getDifficulty() { return pan.getDifficulty(); }
    public void save(String playerName, int scoreJ1, int scoreJ2, int nbPlayers, int playerRound, Board board)
    {

        String game;
        File directory = new File("C:\\ProgramData\\savegame");
        int cpt=1;

        if(board instanceof  BoardAbalone)
        {
            game="Abalone";
        }
        else
        {
            game="Dames chinoises";
        }

        if (!directory.exists()) {

            try{
                directory.mkdir();
            }
            catch(SecurityException se){
            }
        }

        try{

            while(1==1)
            {
                File file = new File("C:\\ProgramData\\savegame\\"+playerName+String.valueOf(cpt)+"."+game);
                if(file.exists() && !file.isDirectory())
                {
                    cpt++;
                }

                else
                {
                    break;

                }
            }

            PrintWriter writer = new PrintWriter("C:\\ProgramData\\savegame\\"+playerName+String.valueOf(cpt)+"."+game, "UTF-8");
            writer.println(playerName);
            writer.println(scoreJ1);
            writer.println(scoreJ2);
            writer.println(nbPlayers);
            writer.println(playerRound);
            String line="";

            if(game=="Abalone")
            {

                for(int i=0;i<11;i++)
                {
                    for(int j=0;j<19;j++)
                    {
                        line=line + board.getCase(new Coords(i,j))+";";
                    }

                    writer.println(line);
                    line="";
                }
            }

            else if(game=="Dames chinoises")
            {
                for(int i=0;i<19;i++)
                {
                    for(int j=0;j<27;j++)
                    {
                        line=line + board.getCase(new Coords(i,j)) +";";
                    }

                    writer.println(line);
                    line="";
                }
            }
            
            
            if(game=="Dames chinoises")
            {
            	
            	line="";
            	for(int i=0;i<board.getColors().size();i++)
            	{
            		line=line+board.getColors().get(i)+";";
            	}
            	writer.println(line);
            	
            	line="";
            	for(int i=0;i<board.getPseudos().size();i++)
            	{
            		line=line+board.getPseudos().get(i)+";";
            	}
            	writer.println(line);
            }

            writer.close();
        }

        catch (IOException e)
        {
        }
    }

    public void loadGame(String playerName, Board board) throws IOException, FileNotFoundException {

        String path=null;
        String game;
        String temp;
        int condition=0;

        String name;
        int scoreJ1=0;
        int scoreJ2=0;
        int nbPlayers=0;
        int playerRound=0;


        if(board instanceof  BoardAbalone)
        {
            game="Abalone";
        }
        else
        {
            game="Dames chinoises";
        }

        JFileChooser fileChooser = new JFileChooser(new File("C:\\ProgramData\\savegame"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
        }

        Scanner read = new Scanner(new File(path));
        read.useDelimiter(";");

        name=read.nextLine();

        if(!(name.equals(playerName)))
        {
            //Erreur : partie n'appartenant pas au joueur.
            return;

        }
        scoreJ1=Integer.parseInt(read.nextLine());
        scoreJ2=Integer.parseInt(read.nextLine());
        nbPlayers=Integer.parseInt(read.nextLine());
        playerRound=Integer.parseInt(read.nextLine());


        for(int i=0;i<board.getHeight();i++)
        {
            int j=0;
            condition=0;

            while(condition==0)
            {
                temp=read.next();

                switch (temp)
                {

                    case "ILLEGAL":
                        board.setCase(new Coords(i,j),Color.ILLEGAL);
                        break;
                    case "EMPTY":
                        board.setCase(new Coords(i,j),Color.EMPTY);
                        break;
                    case "BLACK":
                        board.setCase(new Coords(i,j),Color.BLACK);
                        break;
                    case "WHITE":
                        board.setCase(new Coords(i,j),Color.WHITE);
                        break;
                    case "RED":
                        board.setCase(new Coords(i,j),Color.RED);
                        break;
                    case "GREEN":
                        board.setCase(new Coords(i,j),Color.GREEN);
                        break;
                    case "BLUE":
                        board.setCase(new Coords(i,j),Color.BLUE);
                        break;
                    case "YELLOW":
                        board.setCase(new Coords(i,j),Color.YELLOW);
                        break;
                    default:
                        condition=1;
                }

                j++;
            }
        }
        
        
        if(game=="Dames chinoises")
        {
            temp="";
            while(condition==0)
            {
                temp=read.next();

                switch (temp)
                {
                    case "ILLEGAL":
                    	board.getColors().add(Color.ILLEGAL);
                        break;
                    case "EMPTY":
                    	board.getColors().add(Color.EMPTY);
                        break;
                    case "BLACK":
                    	board.getColors().add(Color.BLACK);
                        break;
                    case "WHITE":
                    	board.getColors().add(Color.WHITE);
                        break;
                    case "RED":
                    	board.getColors().add(Color.RED);
                        break;
                    case "GREEN":
                    	board.getColors().add(Color.GREEN);
                        break;
                    case "BLUE":
                    	board.getColors().add(Color.BLUE);
                        break;
                    case "YELLOW":
                    	board.getColors().add(Color.YELLOW);
                        break;
                    default:
                        condition=1;
                }
            }
            
            temp="";
            condition=0;
            while(!(temp.equals("")))
            {
                temp=read.next();
                board.getPseudos().add(temp);
            }
        }
    }
}
