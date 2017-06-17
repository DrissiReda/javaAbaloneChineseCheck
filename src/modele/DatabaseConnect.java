package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DatabaseConnect 
{
	private static Connection connection;
	private static int idUtilisateur;

	public boolean getConnection()
	{
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://www.budbud.ovh:3306/projet_java","iatic3","iatic3");
			
			return true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	//Enregistre compte.
	public static boolean saveUser(String pseudo, String mdp) throws Exception
	{
		Statement stmt = connection.createStatement();
		
		int WrittenLines = stmt.executeUpdate("insert into user set pseudo='"+pseudo+"', mdp=MD5('"+mdp+"')");
		
		
		ResultSet rs = stmt.executeQuery("select idUtilisateur, pseudo, mdp from user where pseudo = '" + pseudo + "' and mdp = MD5('"+mdp+"')");
		while (rs.next())
		{
			idUtilisateur = rs.getInt("idUtilisateur");
		}
		rs.close();

		stmt.close();
		
		return WrittenLines == 1;
	}
	
	//Renvoie vrai si le compte peut se connecter, faux sinon.
	public static boolean userLogin(String pseudo, String password) throws SQLException
	{
		String pseudoRS  = null;
		Statement stmt = connection.createStatement();
		
		ResultSet rs = stmt.executeQuery("select idUtilisateur, pseudo, mdp from user where pseudo = '" + pseudo + "' and mdp = MD5('"+password+"')");
		while (rs.next())
		{
			pseudoRS = rs.getString("pseudo");
			idUtilisateur = rs.getInt("idUtilisateur");
		}
		rs.close();
		
		//user not found
		if (pseudoRS == null)
		{
			stmt.close();
			return false;
		}
		
		stmt.close();
		return true;
	}
	
	
	public static Object[][] getHistory() throws Exception
	{
		Statement stmt = connection.createStatement();
		
		ResultSet rs = stmt.executeQuery("select idJeu, type, scoreJ1, scoreJ2, date from gameplayed where idUtilisateur='"+idUtilisateur+"'");
		
		int idJeu;
		String game=null;
		String type;
		String scoreJ1;
		String scoreJ2;
		String timestamp;
		
		
		
		ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<String>();
		
		while (rs.next())
		{
			idJeu = rs.getInt("idJeu");
			type = String.valueOf(rs.getInt("type"));
			scoreJ1 = String.valueOf(rs.getInt("scoreJ1"));
			scoreJ2 = String.valueOf(rs.getInt("scoreJ2"));
			timestamp = String.valueOf(rs.getTimestamp("date"));
			
			
			ResultSet rs2 = stmt.executeQuery("select nom from game where idJeu='"+idJeu+"'");
			while (rs2.next())
			{
				game=rs2.getString("nom");
			}
			rs2.close();
			
			
			temp.add(game);
			temp.add(type);
			temp.add(scoreJ1);
			temp.add(scoreJ2);
			temp.add(timestamp);
			
			al.add(new ArrayList<String>(temp));
			temp.clear();
			
		}
		
		
		Object[][] data = new Object[al.size()][5];
		for(int compteur=0;compteur<al.size();compteur++)
		{
			for(int compteur2=0;compteur2<5;compteur2++)
			{
				data[compteur][compteur2]=al.get(compteur).get(compteur2);
			}
		}
		
		rs.close();
		stmt.close();
		return data;
	}
	
	
	public static boolean saveGame(String game, int type, int scorePlayer1, int scorePlayer2) throws Exception
	{
		Statement stmt = connection.createStatement();
		
		
		int idJeu = 0;
		ResultSet rs = stmt.executeQuery("select idJeu from game where nom='" + game +"'");
		while (rs.next())
		{
			idJeu = rs.getInt("idJeu");
		}
		rs.close();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		int WrittenLines = stmt.executeUpdate("insert into gameplayed set idUtilisateur='"+idUtilisateur+"', idJeu='"+idJeu+"', type='"+type+"', scoreJ1='"+scorePlayer1+"', scoreJ2='"+scorePlayer2+"', date='"+timestamp+"' ");
		
		
		stmt.close();
		
		return WrittenLines == 1;
	}
	
	
	//Renvoie les points d'un utilisateur.
	public static int playerPoints(String playerName) throws Exception
	{
		Statement stmt = connection.createStatement();
		
		int points = 0;
		ResultSet rs = stmt.executeQuery("select points from user where nom='" + playerName +"'");
		while (rs.next())
		{
			points = rs.getInt("points");
		}
		rs.close();
		stmt.close();
		
		return points;
	}
	
	public static void closeDatabase()
	{
		try 
		{
			connection.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
