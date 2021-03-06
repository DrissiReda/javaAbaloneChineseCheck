package vue;

import modele.DatabaseConnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Subscription extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	//écran de connexion.
	
	public Subscription(JFrame parent) {
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		JLabel labelInscription = new JLabel("INSCRIPTION");
		labelInscription.setForeground(Color.BLACK);
		labelInscription.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		labelInscription.setBounds(354, 75, 290, 90);
		add(labelInscription);
		
		JLabel labelPseudo = new JLabel("Pseudonyme");
		labelPseudo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 25));
		labelPseudo.setBounds(245, 203, 178, 75);
		add(labelPseudo);
		
		JLabel labelMdp = new JLabel("Mot de passe");
		labelMdp.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 25));
		labelMdp.setBounds(245, 318, 250, 53);
		add(labelMdp);
		
		textField = new JTextField();
		textField.setBounds(488, 224, 236, 32);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(488, 328, 236, 32);
		add(passwordField);
		
		JButton boutonRetour = new JButton("RETOUR");
		boutonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JPanel panel2 = new ConnectionSubscriptionChoice(parent);
				panel2.setVisible(true);
				panel2.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel2);
			}
		});
		boutonRetour.setFont(new Font("Arial", Font.BOLD, 15));
		boutonRetour.setBounds(185, 463, 150, 65);
		add(boutonRetour);
		
		
		JLabel labelSubscriptionFailure = new JLabel();
		labelSubscriptionFailure.setForeground(Color.RED);
		labelSubscriptionFailure.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		labelSubscriptionFailure.setBounds(488, 328, 379, 124);
		add(labelSubscriptionFailure);
		
		JButton boutonValider = new JButton("VALIDER");
		boutonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					String password = String.valueOf(passwordField.getPassword());
					
					if(password.length()>5 && textField.getText().length()>5)
					{
						DatabaseConnect.saveUser(textField.getText(), password);
						setVisible(false);
						JPanel panel5 = new GameChoice(parent,textField.getText());
						panel5.setVisible(true);
						panel5.setBounds(0,0,1000,600);
						parent.getContentPane().add(panel5);
					}
					
					else
					{
						labelSubscriptionFailure.setText("<html>Echec d'inscription<br>(Pseudo/mdp > 5 caract�res)</html>");
					}
					
				} 
				catch (Exception  e) 
				{
					//error connecting to database or user exists
					labelSubscriptionFailure.setText("<html>Echec d'inscription<br>(Pseudo existant)</html>");
					e.printStackTrace();
				}
				

			
			}
		});
		
		boutonValider.setFont(new Font("Arial", Font.BOLD, 15));
		boutonValider.setBounds(374, 463, 350, 65);
		add(boutonValider);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Images\\Fond2.png"));
		label.setBounds(0, 0, 1000, 600);
		add(label);

		
	}
}
