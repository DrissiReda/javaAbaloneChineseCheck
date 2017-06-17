package vue;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class ConnectionSubscriptionChoice extends JPanel {

	//Deuxième écran : affichage choix inscription ou connexion.

	public ConnectionSubscriptionChoice(JFrame parent) {
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		JButton boutonInscription = new JButton("INSCRIPTION");
		boutonInscription.setBackground(UIManager.getColor("Button.background"));
		boutonInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JPanel panel4 = new Subscription(parent);
				panel4.setVisible(true);
				panel4.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel4);
			}
		});
		boutonInscription.setFont(new Font("Arial", Font.BOLD, 15));
		boutonInscription.setBounds(361, 256, 235, 75);
		add(boutonInscription);
		
		JButton boutonConnexion = new JButton("CONNEXION");
		boutonConnexion.setBackground(UIManager.getColor("Button.background"));
		boutonConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JPanel panel3 = new Connection(parent);
				panel3.setVisible(true);
				panel3.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel3);
			}
		});
		boutonConnexion.setFont(new Font("Arial", Font.BOLD, 15));
		boutonConnexion.setBounds(361, 402, 235, 75);
		add(boutonConnexion);
		
		JLabel label1 = new JLabel("ABALONE");
		label1.setForeground(Color.BLACK);
		label1.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		label1.setBounds(379, 46, 431, 59);
		add(label1);
		
		JLabel label2 = new JLabel("***");
		label2.setForeground(Color.BLACK);
		label2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		label2.setBounds(462, 104, 33, 34);
		add(label2);
		
		JLabel label3 = new JLabel("DAMES CHINOISES");
		label3.setForeground(Color.BLACK);
		label3.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		label3.setBounds(280, 149, 484, 59);
		add(label3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Images\\Fond2.png"));
		label.setBounds(0, 0, 1000, 600);
		add(label);
		
		

		
	}
}
