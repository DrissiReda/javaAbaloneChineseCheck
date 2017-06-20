package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControlerAbalone;

public class StarterChoice extends JPanel{
	private JPanel centerArea;
	private JPanel southArea;
	private JPanel northArea;
	private int indice = 0;
	
	public StarterChoice(JFrame parent, boolean AI){		
		setLayout(new BorderLayout());
		CardLayout cl = new CardLayout();
		
		northArea = new JPanel();
		centerArea = new JPanel();
		southArea = new JPanel();
		
		JButton next = new JButton(">");
		JButton previous = new JButton("<");
		JButton launch = new JButton("Lancer la partie");
		
		add(centerArea, BorderLayout.CENTER);
		add(southArea, BorderLayout.SOUTH);
		add(northArea, BorderLayout.NORTH);
		
		southArea.add(previous);
		southArea.add(launch);
		southArea.add(next);
		
		// Images CardLayout
		JPanel card1 = new JPanel();
	    ImageIcon img1 = new ImageIcon("Images/standard.png");	    
	    JLabel var1 = new JLabel(img1);
	    card1.add(var1);
	    
		JPanel card2 = new JPanel();
	    ImageIcon img2 = new ImageIcon("Images/belgian.png");	    
	    JLabel var2 = new JLabel(img2);
	    card2.add(var2);
	    
		JPanel card3 = new JPanel();
	    ImageIcon img3 = new ImageIcon("Images/allienage.png");	    
	    JLabel var3 = new JLabel(img3);
	    card3.add(var3);
		
	    next.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	          cl.next(centerArea);
	          setIndice(true); //indice++
	        }
	    });
	    previous.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	          cl.previous(centerArea);
	          setIndice(false); //indice--
	        }
	    });
	    
	    launch.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	setVisible(false);
	        	String mode = getMode(indice);
	        	System.out.println(mode);
	        	ControlerAbalone abalone = new ControlerAbalone(parent, AI, mode);
	        	
	        }
	    });
	    
	    centerArea.setLayout(cl);
	    centerArea.add(card1);
	    centerArea.add(card2);
	    centerArea.add(card3);
	}
	
	public void setIndice(boolean next){
		if(next){
			if(this.indice == 2)
				this.indice = 0;
			else
				this.indice++;
		}
		else{
			if(this.indice == 0)
				this.indice = 2;
			else
				this.indice--;
		}
			
	}
	
	public String getMode(int indice){
		if(indice == 0)
			return "standard";
		else if(indice == 1)
			return "belgian";
		else
			return "allienage";
	}
	
	public String getTitre(int indice){
		if(indice == 0)
			return "Standard";
		else if(indice == 1)
			return "Marguerite Belge";
		else
			return "Allienage";
	}
}
