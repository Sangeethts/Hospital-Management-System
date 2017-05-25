import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ContactUs extends JFrame {
	
	JLabel websiteLabel = new JLabel("<html> Wesbite: <a href=\"http://www.yasserkabbout.com\">www.yasserkabbout.com</a> </html>");
		
		public ContactUs(){
					
					setLayout(new FlowLayout());
					 setSize(300,60);
					 setTitle("About Us");
					 setLocationRelativeTo(null);
					 setVisible(true);
					 setResizable(false);
					 add(websiteLabel);
					 goWebsite(websiteLabel);
					 }
		
				
		
private void goWebsite(JLabel website){
	
	website.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                Desktop.getDesktop().browse(new URI("http://www.yasserkabbout.com"));
            } catch (URISyntaxException | IOException ex) {
                //It looks like there's a problem
            }
        }
    });
	
}

				
				
	}



