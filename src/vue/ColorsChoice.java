package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JComboBox;

public class ColorsChoice extends JPanel {

	//Choix du nombre de joueurs.
	
	
	public ColorsChoice(JFrame parent, String playerName, String game, int number_players) {
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		JLabel labelMenu = new JLabel("COULEURS");
		labelMenu.setForeground(Color.BLACK);
		labelMenu.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		labelMenu.setBounds(373, 42, 480, 90);
		add(labelMenu);
		
		JLabel label = new JLabel("PAR JOUEUR");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		label.setBounds(350, 104, 329, 75);
		add(label);
		
		
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
				JPanel panel = new PlayersNumberChoice(parent, playerName,game);
				panel.setVisible(true);
				panel.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel);
			}
		});
		boutonRetour.setFont(new Font("Arial", Font.BOLD, 15));
		boutonRetour.setBounds(185, 463, 150, 65);
		add(boutonRetour);
		
		JButton bouton1couleur = new JButton("1");
		bouton1couleur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				JPanel panel = new VariantChoice(parent, playerName,game,number_players,1);
				panel.setVisible(true);
				panel.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel);
				
			}
		});
		bouton1couleur.setFont(new Font("Arial", Font.BOLD, 15));
		bouton1couleur.setBounds(373, 207, 235, 75);
		add(bouton1couleur);
		
		
		JButton bouton2couleurs = new JButton("2");
		bouton2couleurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				JPanel panel = new VariantChoice(parent, playerName,game,number_players,2);
				panel.setVisible(true);
				panel.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel);
				
			}
		});
		bouton2couleurs.setFont(new Font("Arial", Font.BOLD, 15));
		bouton2couleurs.setBounds(373, 308, 235, 75);
		add(bouton2couleurs);
		
		
		JButton bouton3couleurs = new JButton("3");
		bouton3couleurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				JPanel panel = new VariantChoice(parent, playerName,game,number_players,3);
				panel.setVisible(true);
				panel.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel);
			}
		});
		bouton3couleurs.setFont(new Font("Arial", Font.BOLD, 15));
		bouton3couleurs.setBounds(373, 409, 235, 75);
		
		if(number_players==2)
		{
			add(bouton3couleurs);
		}
		
		
		JLabel label2 = new JLabel("");
		label2.setIcon(new ImageIcon("Images\\Fond2.png"));
		label2.setBounds(0, 0, 1000, 600);
		add(label2);
		
	}
}
