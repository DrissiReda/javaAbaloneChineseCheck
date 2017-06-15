package vue;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Start extends JPanel {

	//Premier écran : cliquez pour continuer.
	
	public Start(JFrame parent){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				JPanel panel2 = new ConnectionSubscriptionChoice(parent);
				panel2.setVisible(true);
				panel2.setBounds(0,0,1000,600);
				parent.getContentPane().add(panel2);				
			}
		});
		setLayout(null);
		setBackground(new Color(245, 245, 245));
		
		
		JLabel label1 = new JLabel("ABALONE");
		label1.setForeground(Color.BLACK);
		label1.setBounds(379, 158, 431, 59);
		label1.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		add(label1);
		
		JLabel label2 = new JLabel("***");
		label2.setForeground(Color.BLACK);
		label2.setBounds(461, 217, 33, 34);
		label2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		add(label2);
		
		
		JLabel label3 = new JLabel("DAMES CHINOISES");
		label3.setForeground(Color.BLACK);
		label3.setBounds(285, 262, 484, 59);
		label3.setFont(new Font("Synchro LET", Font.PLAIN, 50));
		add(label3);
		
		JLabel lblCliquezPourContinuer = new JLabel("CLIQUEZ POUR CONTINUER ...");
		lblCliquezPourContinuer.setFont(new Font("Synchro LET", Font.PLAIN, 30));
		lblCliquezPourContinuer.setBounds(295, 503, 384, 71);
		add(lblCliquezPourContinuer);

		
		
	}
}
