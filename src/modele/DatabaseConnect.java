package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect 
{
	private static Connection connection;
	private static int idUtilisateur;

	public boolean getConnection()
	{
		try 
		{
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/projet_java?user=root&password=root");
			
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
	
	
	//Méthode à écrire.
	public static boolean changePassword(String pseudo, String Oldpassword, String NewPassword) throws SQLException
	{
		return true;
		
	}
	
	//Enregistre partie dans la base de données.
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
		
		/*
		//1 : avec variante, 0 : sans variante.
		int type;
		if(variant)
			{
				type=1;
			}
		else
			{
				type=0;
			}
		*/
		int WrittenLines = stmt.executeUpdate("insert into gameplayed set idUtilisateur='"+idUtilisateur+"', idJeu='"+idJeu+"', type='"+type+"', scoreJ1='"+scorePlayer1+"', scoreJ2='"+scorePlayer2+"'");
		
		
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
