package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
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
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.TableColumn;

import com.sun.jmx.snmp.Timestamp;

import modele.DatabaseConnect;



public class History extends JPanel{
	private JTable table;

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
		
		String[] columnNames = {"Jeu",
                "Nombre joueurs",
                "Score joueur 1",
                "Score joueur 2",
                "Date"};
		try
		{
			Object[][] data = DatabaseConnect.getHistory();
			
			table = new JTable(data, columnNames);
			table.setEnabled(false);
			JScrollPane scroller = new JScrollPane(table);
			scroller.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			scroller.setBackground(new Color(245, 245, 245));
			scroller.setBounds(254, 157, 496, 284);
			add(scroller);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
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
		label.setBackground(new Color(0, 0, 0));
		label.setIcon(new ImageIcon("Images\\Fond2.png"));
		label.setBounds(0, 0, 1000, 600);
		add(label);
	}
}