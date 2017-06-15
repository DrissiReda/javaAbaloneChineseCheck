package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class Menu extends JPanel {

	//Menu.
	
	
	public Menu(JFrame parent, String playerName, String game) {
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		JLabel labelMenu = new JLabel("MENU");
		labelMenu.setForeground(Color.BLACK);
		labelMenu.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		labelMenu.setBounds(426, 38, 480, 90);
		add(labelMenu);
		
		JLabel label = new JLabel("***");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		label.setBounds(469, 105, 33, 34);
		add(label);
		
		if(game=="Abalone")
		{
			JLabel labelAbalone = new JLabel("ABALONE");
			labelAbalone.setForeground(Color.BLACK);
			labelAbalone.setFont(new Font("Synchro LET", Font.PLAIN, 50));
			labelAbalone.setBounds(390, 137, 431, 59);
			add(labelAbalone);
		}
		
		else if(game=="Dames chinoises")
		{
			JLabel labelDamesChinoises = new JLabel("DAMES CHINOISES");
			labelDamesChinoises.setForeground(Color.BLACK);
			labelDamesChinoises.setFont(new Font("Synchro LET", Font.PLAIN, 50));
			labelDamesChinoises.setBounds(280, 137, 431, 59);
			add(labelDamesChinoises);
		}
		
		
		JLabel labelJoueur = new JLabel("Joueur : " + playerName);
		labelJoueur.setFont(new Font("Arial", Font.PLAIN, 17));
		labelJoueur.setBounds(22, 0, 366, 59);
		add(labelJoueur);
		
		JButton boutonMdp = new JButton("CHANGER MOT DE PASSE");
		boutonMdp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				JPanel panel9 = new PasswordChange(parent, playerName);
				panel9.setVisible(true);
				panel9.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel9);
				
			}
		});
		boutonMdp.setFont(new Font("Arial", Font.BOLD, 15));
		boutonMdp.setBounds(22, 42, 245, 27);
		add(boutonMdp);
		
		
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
		boutonRetour.setBounds(185, 463, 150, 65);
		add(boutonRetour);
		
		JButton boutonNouvellePartie = new JButton("NOUVELLE PARTIE");
		boutonNouvellePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Lancement d'une nouvelle partie.
				setVisible(false);
				JPanel panel7 = new PlayersNumberChoice(parent, playerName, game);
				panel7.setVisible(true);
				panel7.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel7);
				
			}
		});
		boutonNouvellePartie.setFont(new Font("Arial", Font.BOLD, 15));
		boutonNouvellePartie.setBounds(373, 222, 235, 75);
		add(boutonNouvellePartie);
		
		JButton boutonPartEnreg = new JButton("PARTIE ENREGISTR\u00C9E");
		boutonPartEnreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Lancement d'une partie enregistrée.
				
				
				
				
			}
		});
		boutonPartEnreg.setFont(new Font("Arial", Font.BOLD, 15));
		boutonPartEnreg.setBounds(373, 325, 235, 75);
		add(boutonPartEnreg);
		
		JButton boutonRegles = new JButton("R\u00C8GLES DU JEU");
		boutonRegles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(game=="Abalone")
				{
					if (Desktop.isDesktopSupported()) {
					    try {
					        File myFile = new File("Images\\ReglesAbalone.pdf");
					        Desktop.getDesktop().open(myFile);
					    } catch (IOException ex) {
					    }
					}
				}
				
				else if(game=="Dames chinoises")
				{
					if (Desktop.isDesktopSupported()) {
					    try {
					        File myFile = new File("Images\\ReglesDamesChinoises.pdf");
					        Desktop.getDesktop().open(myFile);
					    } catch (IOException ex) {
					    }
					}
				}
				
				
				
				
				
				
			}
		});
		boutonRegles.setFont(new Font("Arial", Font.BOLD, 15));
		boutonRegles.setBounds(373, 424, 235, 75);
		add(boutonRegles);
		
		JLabel label2 = new JLabel("");
		label2.setIcon(new ImageIcon("Images\\Fond2.png"));
		label2.setBounds(0, 0, 1000, 600);
		add(label2);
		
	}
}
