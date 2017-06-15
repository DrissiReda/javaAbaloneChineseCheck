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
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class Connection extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	//Écran de connexion.
	
	public Connection(JFrame parent) {
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		JLabel labelConnexion = new JLabel("CONNEXION");
		labelConnexion.setBackground(new Color(245, 245, 245));
		labelConnexion.setForeground(Color.BLACK);
		labelConnexion.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		labelConnexion.setBounds(354, 74, 290, 90);
		add(labelConnexion);
		
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
		
		JLabel labelConnexionFailure = new JLabel();
		labelConnexionFailure.setForeground(Color.RED);
		labelConnexionFailure.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		labelConnexionFailure.setBounds(488, 358, 379, 40);
		add(labelConnexionFailure);
		
		
		JButton boutonValider = new JButton("VALIDER");
		boutonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				JPanel panel5 = new GameChoice(parent,textField.getText());
				panel5.setVisible(true);
				panel5.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel5);

				String password = String.valueOf(passwordField.getPassword());
				try
				{
					if (!DatabaseConnect.userLogin(textField.getText(), password))
					{
						//message user not found or password not valid
						labelConnexionFailure.setText("Echec de connexion");
						
					}
					
					else
					{
						/*setVisible(false);
						JPanel panel5 = new GameChoice(parent,textField.getText());
						panel5.setVisible(true);
						panel5.setBounds(0,0,1000,600);
						parent.getContentPane().add(panel5);*/
					}
				} 
				catch (SQLException e) 
				{
					//error reading user
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
		// test
	}
}
