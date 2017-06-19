package vue;

import modele.Board;
import modele.BoardAbalone;
import modele.Config;
import modele.Coords;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Panneau extends JPanel{

    JSlider slideDif = new JSlider(JSlider.VERTICAL, 1, 10, 1);
    int difficulty = 0;
    private int marbleLeftBlack = 14;
    private int marbleLeftWhite = 14;
    private BoardAbalone boardView = new BoardAbalone();
    private int tabSelec[][] = new int[11][19];
    private int initParam=1;
    private int confirmValidation=0;
    private int confirmDirection=0;
    private JLabel scoreB = new JLabel("restants : "+marbleLeftBlack);
    private JLabel scoreW = new JLabel("restants : "+marbleLeftWhite);
    private JLabel validButtonDown = new JLabel(new ImageIcon("Images/ValidDown.png"));
    private JLabel validButtonUp = new JLabel(new ImageIcon("Images/ValidUp.png"));
    private Config.Direction direction=null;
    private ArrayList<Config.Direction> tabDirections = new ArrayList<Config.Direction>();
    
    public void setName(String s)
    {
    	boardView.setName(s);
    }
    
    public void setIA(boolean b)
    {
    	boardView.setIA(b);
    }

    public void paintComponent(Graphics g) {

        //Initialisation
        if(initParam==1){
            //souris
            setLayout(null);
            scoreB.setFont(new Font("Synchro LET", Font.BOLD, 20));
            scoreW.setFont(new Font("Synchro LET", Font.BOLD, 20));
            
            /*
            scoreB.setForeground(new Color(0xE97628));
            scoreW.setForeground(new Color(0x5ABEB1));
			*/
            
            scoreB.setBounds(730, 450, 170, 50);
            scoreW.setBounds(730, 487, 170, 50);
            add(scoreB);
            add(scoreW);

            validButtonDown.setBounds(530, 140, 170, 50);
            validButtonUp.setBounds(530, 140, 170, 50);

            slideDif.setBounds(583,90,50,208);
            add(slideDif);

            //police
            try {
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Images/Synchro-LET-Plain.ttf")));
            } catch (IOException|FontFormatException e) {
                e.printStackTrace();
            }

            initParam=0;

/*
            JLabel hg = new JLabel("Test");
            JLabel d = new JLabel("Test");
            JLabel gau = new JLabel("Test");
            JLabel bd = new JLabel("Test");
            JLabel bg = new JLabel("Test");
            hg.setBackground(Color.lightGray);
            d.setBackground(Color.lightGray);
            gau.setBackground(Color.lightGray);
            bd.setBackground(Color.lightGray);
            bg.setBackground(Color.lightGray);
            hg.setOpaque(true);
            d.setOpaque(true);
            gau.setOpaque(true);
            bd.setOpaque(true);
            bg.setOpaque(true);
            hg.setBounds(721, 202, 72, 73);
            d.setBounds(821, 278, 86, 65);
            gau.setBounds(672, 278, 86, 65);
            bd.setBounds(793, 345, 72, 73);
            bg.setBounds(722, 345, 72, 73);
            this.add(hg);
            this.add(d);
            this.add(gau);
            this.add(bd);
            this.add(bg);
*/
        }

        //Affiche le fond
        try {
            if(boardView.player == Config.Color.BLACK) {
                Image img = ImageIO.read(new File("Images/AbaFondTourPBLACK.png"));
                g.drawImage(img, 0, 0, this);
            }
            else{
                Image img = ImageIO.read(new File("Images/AbaFondTourPWHITE.png"));
                g.drawImage(img, 0, 0, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Mets à jour le pad directionnel
        if(verifMoveTabDirections(Config.Direction.UPRIGHT)){
            try {
                Image img = ImageIO.read(new File("Images/padUpRight.png"));
                g.drawImage(img, 672, 204, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(direction==Config.Direction.UPRIGHT){
                this.confirmDirection=1;
            }
        }
        if(verifMoveTabDirections(Config.Direction.UPLEFT)){
            try {
                Image img = ImageIO.read(new File("Images/padUpLeft.png"));
                g.drawImage(img, 672, 204, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(direction==Config.Direction.UPLEFT){
                this.confirmDirection=1;
            }
        }
        if(verifMoveTabDirections(Config.Direction.RIGHT)){
            try {
                Image img = ImageIO.read(new File("Images/padRight.png"));
                g.drawImage(img, 672, 204, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(direction==Config.Direction.RIGHT){
                this.confirmDirection=1;
            }
        }
        if(verifMoveTabDirections(Config.Direction.LEFT)){
            try {
                Image img = ImageIO.read(new File("Images/padLeft.png"));
                g.drawImage(img, 672, 204, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(direction==Config.Direction.LEFT){
                this.confirmDirection=1;
            }
        }
        if(verifMoveTabDirections(Config.Direction.DOWNRIGHT)){
            try {
                Image img = ImageIO.read(new File("Images/padDownRight.png"));
                g.drawImage(img, 672, 204, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(direction==Config.Direction.DOWNRIGHT){
                this.confirmDirection=1;
            }
        }
        if(verifMoveTabDirections(Config.Direction.DOWNLEFT)){
            try {
                Image img = ImageIO.read(new File("Images/padDownLeft.png"));
                g.drawImage(img, 672, 204, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(direction==Config.Direction.DOWNLEFT){
                this.confirmDirection=1;
            }
        }


        //Mets à jour les "Boules restants
        scoreB.setText("restants : "+marbleLeftBlack);
        scoreW.setText("restants : "+marbleLeftWhite);

        int widthOffset = 0;
        int heightOffset = 153;
        int limX;

        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                limX=103 + (j * 20) - widthOffset;
                if (boardView.getCase(new Coords(i, j)) == Config.Color.BLACK) {
                    try {
                        Image img = ImageIO.read(new File("Images/Borange.png"));
                        g.drawImage(img, limX, heightOffset, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (boardView.getCase(new Coords(i, j)) == Config.Color.WHITE) {
                    try {
                        Image img = ImageIO.read(new File("Images/Bbleu.png"));
                        g.drawImage(img, limX, heightOffset, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (tabSelec[i][j] == 1) { //Show ring selection
                    try {
                        Image imgSelec = ImageIO.read(new File("Images/SelectionBall.png"));
                        g.drawImage(imgSelec, limX-4, heightOffset-5, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            heightOffset = heightOffset + 40;
        }

    }

    public void copyTab(BoardAbalone b) {
        String tmp = boardView.getName();
        this.boardView = b;
        boardView.setName(tmp);
    }
    
    public void refreshBoard(){
        repaint();
    }

    public void setMarbleLeftBlack(int marbleLeftBlack) {
        this.marbleLeftBlack = marbleLeftBlack;
    }

    public void setMarbleLeftWhite(int marbleLeftWhite) {
        this.marbleLeftWhite = marbleLeftWhite;
    }

    public int getConfirmValidation() {
        return confirmValidation;
    }

    public int getConfirmDirection() {
        return confirmDirection;
    }


    public void click(MouseEvent e) throws IOException {
        int widthOffset = 0;
        int heightOffset = 183;
        int limX;
        int flagClic=0;
        System.out.println("Click : "+e.getX()+";"+e.getY());
        //clic on directions
        if(confirmValidation==1) {
        	//
            if ((e.getX() > 792) && (e.getX() < 792 + 72) && (e.getY() > 235) && (e.getY() < 235 + 73)) {
            	flagClic=1;
            	if(verifMoveTabDirections(Config.Direction.UPRIGHT)){
                    this.direction = Config.Direction.UPRIGHT;
                    moveIntoTabPieces();
                    confirmDirection = 1;
                    
                }
            } else if ((e.getX() > 721) && (e.getX() < 721 + 72) && (e.getY() > 235) && (e.getY() < 235 + 73)) {
                flagClic=1;
                if(verifMoveTabDirections(Config.Direction.UPLEFT)){
                    this.direction = Config.Direction.UPLEFT;
                    moveIntoTabPieces();
                    confirmDirection = 1;
                    
                }
            } else if ((e.getX() > 821) && (e.getX() < 821 + 86) && (e.getY() > 310) && (e.getY() < 310 + 65)) {
            	flagClic=1;
                if(verifMoveTabDirections(Config.Direction.RIGHT)){
                    this.direction = Config.Direction.RIGHT;
                    moveIntoTabPieces();
                    confirmDirection = 1;
                    
                }
            } else if ((e.getX() > 672) && (e.getX() < 672 + 86) && (e.getY() > 310) && (e.getY() < 310 + 65)) {
                flagClic=1;
                if(verifMoveTabDirections(Config.Direction.LEFT)){
                    this.direction = Config.Direction.LEFT;
                    moveIntoTabPieces();
                    confirmDirection = 1;
                    
                }
            } else if ((e.getX() > 796) && (e.getX() < 805 + 72) && (e.getY() > 375) && (e.getY() < 375 + 73)) {
                flagClic=1;
                if(verifMoveTabDirections(Config.Direction.DOWNRIGHT)){
                    this.direction = Config.Direction.DOWNRIGHT;
                    moveIntoTabPieces();
                    confirmDirection = 1;
                    
                }
            } else if ((e.getX() > 722) && (e.getX() < 722 + 72) && (e.getY() > 375) && (e.getY() < 375 + 73)) {
                flagClic=1;
                if(verifMoveTabDirections(Config.Direction.DOWNLEFT)){
                    this.direction = Config.Direction.DOWNLEFT;
                    moveIntoTabPieces();
                    confirmDirection = 1;
                    
                }
            }
        }

        //Clic on balls
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                limX = 106 + (j * 20) - widthOffset;
                if ((e.getX() > limX) && (e.getX() < limX + 33) && (e.getY() > heightOffset) && (e.getY() < heightOffset + 40) && (((j % 2 != 0) && (i % 2 != 0)) || ((j % 2 == 0) && (i % 2 == 0)))) {
                    if (boardView.selectMarble(new Coords(i,j))) {
                        tabSelec[i][j] = 1;
                        this.confirmValidation = 1;
                        flagClic=1;
                        tabDirections=boardView.generateDir();
                    }
                }
            }
            heightOffset = heightOffset + 40;
        }

        for (int i = 0; i < 4; i++) {
            if ((e.getX() > 539) && (e.getX() < 539 + 110) && (e.getY() > 387+(i*43)) && (e.getY() < 387+(i*43) + 34)){
                switch (i){
                    case 0: //SAUVER
                    	System.out.println(boardView.getName());
                    	if(boardView.getIA())
                    	{
                    		save(boardView.getName(),1,boardView.player.ordinal(),boardView);
                    	}
                    	else
                    	{
                    		save(boardView.getName(),2,boardView.player.ordinal(),boardView);
                    	}
                    	break;
                    	
                    case 1: //CHARGER

                    	System.out.println("TEST");
                    	break;
                    case 2: //MENU
                    	break;
                    case 3: //A PROPOS
                    	break;
                }
            }
        }

        if(flagClic==0){
            for (int i = 1; i < 11; i++) {
                for (int j = 0; j < 19; j++) {
                    this.tabSelec[i][j]=0;
                }
            }
            boardView.initTabPieces();
            tabDirections.clear();
        }
        this.difficulty=slideDif.getValue();
        //System.out.println("DIFFICULTE : "+this.difficulty);
        repaint();
    }

    public void reInit(){
        boardView.initTabPieces();
        this.confirmValidation=0;
        this.confirmDirection=0;
        this.direction=null;
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                this.tabSelec[i][j]=0;
            }
        }
        tabDirections.clear();
    }

    public void moveIntoTabPieces(){
        boardView.tabPieces[3].x= this.direction.ordinal();
        boardView.tabPieces[3].y= 88;
    }

    public Coords[] getTabPieces() {
        return boardView.getTabPieces();
    }

    public boolean verifMoveTabDirections(Config.Direction dir){
        for (Config.Direction k: tabDirections) {
            if(dir==k){
                return true;
            }
        }
        return false;
    }

    public int getDifficulty() {
        return difficulty;
    }
    
    public void save(String playerName, int nbPlayers, int playerRound, Board board)
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

    public void loadGame(String playerName, Board board) throws IOException {

        String path=null;
        String game;
        String temp;
        int condition=0;

        String name;
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
                        board.setCase(new Coords(i, j), Config.Color.ILLEGAL);
                        break;
                    case "EMPTY":
                        board.setCase(new Coords(i, j), Config.Color.EMPTY);
                        break;
                    case "BLACK":
                        board.setCase(new Coords(i, j), Config.Color.BLACK);
                        break;
                    case "WHITE":
                        board.setCase(new Coords(i, j), Config.Color.WHITE);
                        break;
                    case "RED":
                        board.setCase(new Coords(i, j), Config.Color.RED);
                        break;
                    case "GREEN":
                        board.setCase(new Coords(i, j), Config.Color.GREEN);
                        break;
                    case "BLUE":
                        board.setCase(new Coords(i, j), Config.Color.BLUE);
                        break;
                    case "YELLOW":
                        board.setCase(new Coords(i, j), Config.Color.YELLOW);
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
                        board.getColors().add(Config.Color.ILLEGAL);
                        break;
                    case "EMPTY":
                        board.getColors().add(Config.Color.EMPTY);
                        break;
                    case "BLACK":
                        board.getColors().add(Config.Color.BLACK);
                        break;
                    case "WHITE":
                        board.getColors().add(Config.Color.WHITE);
                        break;
                    case "RED":
                        board.getColors().add(Config.Color.RED);
                        break;
                    case "GREEN":
                        board.getColors().add(Config.Color.GREEN);
                        break;
                    case "BLUE":
                        board.getColors().add(Config.Color.BLUE);
                        break;
                    case "YELLOW":
                        board.getColors().add(Config.Color.YELLOW);
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

    public BoardAbalone getBoardView() {
        return boardView;
    }
} //