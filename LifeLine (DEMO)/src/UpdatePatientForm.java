import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdatePatientForm extends JFrame implements ActionListener {

		//initializing the labels
		JLabel idLabel= new JLabel("  ID: ");
		JLabel nameLabel = new JLabel("  Name: ");
		JLabel surnameLabel = new JLabel("  Surname: ");
		JLabel dateOfBirthLabel = new JLabel("  Date of Birth (yyyy-mm-dd): ");
		JLabel bloodTypeLabel = new JLabel("  Blood Type: ");
		JLabel phoneLabel = new JLabel("  Phone Number: ");
		JLabel emailLabel = new JLabel ("  Email account: ");
		JLabel countryLabel = new JLabel("  Country: ");
		//End of initializing labels
		
		//initializing the text fields
		JTextField idText = new JTextField(20);
		JTextField nameText= new JTextField(20);
		JTextField surnameText= new JTextField(20);
		JTextField birthText = new JTextField(8);
		JTextField bloodText= new JTextField(3);
		JTextField phoneText= new JTextField(20);
		JTextField emailText= new JTextField(20);
		JTextField countryText= new JTextField(20);
		//End of initializing labels
		
		//initializing the buttons
		JButton submit = new JButton("Update");
		JButton reset = new JButton("Clear");
		//End of initializing buttons
		
		boolean externalForm =false;
		public UpdatePatientForm(){
			
			setTitle("Updating an existing patient");
			setLayout(new GridLayout(10,2,10,10));
			setSize(640,480);
			setLocationRelativeTo(null);
			setVisible(true);
			setResizable(false);
			
			add(idLabel);
			add(idText);
			add(nameLabel);
			add(nameText);
			add(surnameLabel);
			add(surnameText);
			add(dateOfBirthLabel);
			add(birthText);
			add(bloodTypeLabel);
			add(bloodText);
			add(phoneLabel);
			add(phoneText);
			add(emailLabel);
			add(emailText);
			add(countryLabel);
			add(countryText);
			add(submit);
			add(reset);
			submit.addActionListener(this);
			reset.addActionListener(this);
		}
		
		
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit){
			
			if(!( (nameText.getText().equals("")) || (surnameText.getText().equals("")) || (birthText.getText().equals("")) || (bloodText.getText().equals("")) || (phoneText.getText().equals("")) || (emailText.getText().equals("")) || (countryText.getText().equals("")))){
			Lifeliner user = new Lifeliner(nameText.getText(),surnameText.getText(), birthText.getText(), bloodText.getText(), phoneText.getText(), emailText.getText(), countryText.getText());
			updateToDatabase(user);
			dispose();
			}
			else{
				JOptionPane.showMessageDialog(null,"You have to fill all the required fields!","Warning",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(e.getSource()==reset){
			
			if(externalForm==true){
				nameText.setText("");
				surnameText.setText("");
				birthText.setText("");
				bloodText.setText("");
				phoneText.setText("");
				emailText.setText("");
				countryText.setText("");
				
			}
			else{
				idText.setText("");
				nameText.setText("");
				surnameText.setText("");
				birthText.setText("");
				bloodText.setText("");
				phoneText.setText("");
				emailText.setText("");
				countryText.setText("");
			}
			
		}
	}
	
	
public void updateToDatabase(Lifeliner user){
	
	//Connecting to the database
		final String DATABASE_URL="jdbc:mysql://localhost/javaproject";
		Connection connection = null;
		Statement statement = null;
		//End of database connection
		
	try{
			
			connection=DriverManager.getConnection(DATABASE_URL,"root","");
			statement = connection.createStatement();
			statement.executeUpdate("update lifeliners set p_name='"+user.getName()+"', p_surname= '"+user.getSurname()+"',p_date_of_birth= '"+user.getBirthdate()+"', p_blood_type= '"+user.getBloodType()+"', p_phone= '"+user.getPhoneNumber()+"', p_email= '"+user.getEmail()+"', p_country= '"+user.getCountry()+"' where p_id = '"+idText.getText()+"'");
			
		}

		
		catch(Exception exc){
			
			exc.printStackTrace();
			
		}
}

public void setAllText(String id, String name, String surname, String birthText, String bloodText, String phoneText, String emailText, String countryText){
	
	this.idText.setText(""+id);
	this.idText.setEditable(false);
	this.nameText.setText(name);
	this.surnameText.setText(surname);
	this.birthText.setText(birthText);
	this.bloodText.setText(bloodText);
	this.phoneText.setText(phoneText);
	this.emailText.setText(emailText);
	this.countryText.setText(countryText);
	this.externalForm=true;
}


	
	
	
	

}
