import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutUs extends JFrame {
	
	
	JLabel textLabel = new JLabel("This project was developped by Yasser EL Kabbout for an academic purpose. It is just a DEMO version.");

	
			public AboutUs(){
				
				setLayout(new FlowLayout());
				 setSize(590,70);
				 setTitle("About Us");
				 setLocationRelativeTo(null);
				 setVisible(true);
				 setResizable(false);
				 add(textLabel);
				 
				 
		
		
	}
}
