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
import java.awt.event.ActionEvent;


public class GameChoice extends JPanel {

	//Choix du jeu, ou historique.
	
	
	public GameChoice(JFrame parent,String playerName) {
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		JLabel labelChoix = new JLabel("CHOIX DU JEU");
		labelChoix.setForeground(Color.BLACK);
		labelChoix.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		labelChoix.setBounds(350, 76, 480, 90);
		add(labelChoix);
		
		
		JButton boutonAbalone = new JButton("ABALONE");
		boutonAbalone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
				JPanel panel6 = new Menu(parent, playerName, "Abalone");
				panel6.setVisible(true);
				panel6.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel6);
			
			}
		});
		boutonAbalone.setFont(new Font("Arial", Font.BOLD, 15));
		boutonAbalone.setBounds(289, 259, 195, 65);
		add(boutonAbalone);
		
		
		JButton boutonDamesChinoises = new JButton("DAMES CHINOISES");
		boutonDamesChinoises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
				JPanel panel6 = new Menu(parent, playerName, "Dames chinoises");
				panel6.setVisible(true);
				panel6.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel6);
			
			}
		});
		boutonDamesChinoises.setFont(new Font("Arial", Font.BOLD, 15));
		boutonDamesChinoises.setBounds(535, 259, 195, 65);
		add(boutonDamesChinoises);
		
		
		
		JButton boutonDeconnexion = new JButton("D\u00C9CONNEXION");
		boutonDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JPanel panel2 = new ConnectionSubscriptionChoice(parent);
				panel2.setVisible(true);
				panel2.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel2);
			}
		});
		boutonDeconnexion.setFont(new Font("Arial", Font.BOLD, 15));
		boutonDeconnexion.setBounds(185, 463, 150, 65);
		add(boutonDeconnexion);
		
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
		
		
		JButton boutonHistorique = new JButton("HISTORIQUE");
		boutonHistorique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				JPanel panel10 = new History(parent, playerName);
				panel10.setVisible(true);
				panel10.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel10);
				
			}
		});
		boutonHistorique.setFont(new Font("Arial", Font.BOLD, 15));
		boutonHistorique.setBounds(410, 349, 195, 65);
		add(boutonHistorique);
		
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(0, 0, 0));
		label.setIcon(new ImageIcon("Images\\Fond2.png"));
		label.setBounds(0, 0, 1000, 600);
		add(label);

	}
}
