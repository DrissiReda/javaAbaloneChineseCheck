package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class History extends JPanel {

	//Historique.
	
	
	
	public History(JFrame parent,String playerName) {
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		JLabel labelTitle = new JLabel("HISTORIQUE");
		labelTitle.setBackground(new Color(245, 245, 245));
		labelTitle.setForeground(Color.BLACK);
		labelTitle.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		labelTitle.setBounds(365, 55, 290, 90);
		add(labelTitle);
		
		JLabel labelJoueur = new JLabel("Joueur : " + playerName);
		labelJoueur.setFont(new Font("Arial", Font.PLAIN, 17));
		labelJoueur.setBounds(22, 0, 366, 59);
		add(labelJoueur);
		
		/*
		
	    Object[][] data = {
	    	      {"Abalone", "1", "10"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "2", "14"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "2", "14"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "2", "14"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "2", "14"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "9"},
	    	      {"Dames chinoises", "0", "12"},
	    	      {"Dames chinoises", "0", "12"}
	    	    };

	    
	    
	    //Les titres des colonnes
	    String  title[] = {"Jeu", "Type", "Score"};
	    JTable tableau = new JTable(data, title);
	    //Nous ajoutons notre tableau à notre contentPane dans un scroll
	    //Sinon les titres des colonnes ne s'afficheront pas !
	    parent.getContentPane().add(new JScrollPane(tableau));
	    tableau.setBounds(280, 160, 420, 250);
		tableau.setBackground(new Color(240, 240, 240));
	    add(tableau);
	    
	    */
	    
		
		JButton boutonRetour = new JButton("RETOUR");
		boutonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JPanel panel5 = new GameChoice(parent, playerName);
				panel5.setVisible(true);
				panel5.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel5);
			}
		});
		boutonRetour.setFont(new Font("Arial", Font.BOLD, 15));
		boutonRetour.setBounds(174, 463, 214, 65);
		add(boutonRetour);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Images\\Fond2.png"));
		label.setBounds(0, 0, 1000, 600);
		add(label);
		

	}
}
