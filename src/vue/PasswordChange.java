package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import modele.DatabaseConnect;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class PasswordChange extends JPanel {

	//Changement mot de passe.

	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	
	public PasswordChange(JFrame parent,String playerName) {
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		JLabel labelTitle1 = new JLabel("CHANGER");
		labelTitle1.setBackground(new Color(245, 245, 245));
		labelTitle1.setForeground(Color.BLACK);
		labelTitle1.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		labelTitle1.setBounds(403, 55, 290, 90);
		add(labelTitle1);
		
		JLabel labelTitle2 = new JLabel("MOT DE PASSE");
		labelTitle2.setForeground(Color.BLACK);
		labelTitle2.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		labelTitle2.setBackground(new Color(245, 245, 245));
		labelTitle2.setBounds(342, 118, 378, 90);
		add(labelTitle2);
		
		JLabel labelJoueur = new JLabel("Joueur : " + playerName);
		labelJoueur.setFont(new Font("Arial", Font.PLAIN, 17));
		labelJoueur.setBounds(22, 0, 366, 59);
		add(labelJoueur);
		
		JLabel labelOldPassword = new JLabel("Ancien mot de passe");
		labelOldPassword.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
		labelOldPassword.setBounds(245, 203, 178, 75);
		add(labelOldPassword);
		
		
		JLabel labelNewPassword = new JLabel("Nouveau mot de passe");
		labelNewPassword.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
		labelNewPassword.setBounds(245, 318, 250, 53);
		add(labelNewPassword);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(488, 224, 236, 32);
		add(passwordField1);
		passwordField1.setColumns(10);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(488, 328, 236, 32);
		add(passwordField2);
		
		JButton boutonRetour = new JButton("RETOUR MENU DU JEU");
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
		
		JLabel labelConnexionFailure = new JLabel();
		labelConnexionFailure.setForeground(Color.RED);
		labelConnexionFailure.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		labelConnexionFailure.setBounds(488, 358, 379, 40);
		add(labelConnexionFailure);
		
		
		JButton boutonValider = new JButton("VALIDER");
		boutonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String password1 = String.valueOf(passwordField1.getPassword());
				String password2 = String.valueOf(passwordField2.getPassword());
				
				try
				{
					if ( password2.length()<=4 /*|| !DatabaseConnect.changePassword(playerName, password1, password2) */)
					{
						//message user not found or password not valid
						labelConnexionFailure.setText("Mot de passe invalide");
					}
					
					else
					{
						setVisible(false);
						JPanel panel5 = new GameChoice(parent,playerName);
						panel5.setVisible(true);
						panel5.setBounds(0,0,1000,600);
						parent.getContentPane().add(panel5);
					}
				} 
				catch (Exception e)
				{
					//error reading user
					e.printStackTrace();
				}
			}
		});
		boutonValider.setFont(new Font("Arial", Font.BOLD, 15));
		boutonValider.setBounds(428, 463, 345, 65);
		add(boutonValider);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Images\\Fond2.png"));
		label.setBounds(0, 0, 1000, 600);
		add(label);
		

	}
}
