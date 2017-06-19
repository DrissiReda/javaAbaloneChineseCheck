package vue;

import javax.swing.*;

/**
 * Created by root on 16/06/17.
 */
public class Game extends JFrame {

    public Game() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        this.setTitle("Projet JAVA");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.setVisible(true);

        launch_interface();
        
    }
    public void launch_interface()
    {
        JPanel panel1 = new Start(this);
        panel1.setBounds(0,0,1000,600);
        this.getContentPane().add(panel1);
    }
}
