import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class addPatientForm extends JFrame implements ActionListener {

	//initializing the labels
	JLabel nameLabel = new JLabel("  Name: ");
	JLabel surnameLabel = new JLabel("  Surname: ");
	JLabel dateOfBirthLabel = new JLabel("  Date of Birth (yyyy-mm-dd): ");
	JLabel bloodTypeLabel = new JLabel("  Blood Type: ");
	JLabel phoneLabel = new JLabel("  Phone Number: ");
	JLabel emailLabel = new JLabel ("  Email account: ");
	JLabel countryLabel = new JLabel("  Country: ");
	//End of initializing labels
	
	//initializing the text fields
	JTextField nameText= new JTextField(20);
	JTextField surnameText= new JTextField(20);
	JTextField birthText = new JTextField(8);
	JTextField bloodText= new JTextField(3);
	JTextField phoneText= new JTextField(15);
	JTextField emailText= new JTextField(20);
	JTextField countryText= new JTextField(20);
	//End of initializing labels
	
	//initializing the buttons
	JButton submit = new JButton("Submit");
	JButton reset = new JButton("Clear");
	//End of initializing buttons
	
	
	public addPatientForm(){
		
		setTitle("Adding a new Patient");
		setLayout(new GridLayout(8,2,10,10));
		setSize(640,480);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
	
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
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		

		//TODO add error checker
		
		if (arg0.getSource()==submit){
			
			if(!( (nameText.getText().equals("")) || (surnameText.getText().equals("")) || (birthText.getText().equals("")) || (bloodText.getText().equals("")) || (phoneText.getText().equals("")) || (emailText.getText().equals("")) || (countryText.getText().equals("")))){
			Lifeliner user = new Lifeliner(nameText.getText(),surnameText.getText(), birthText.getText(), bloodText.getText(), phoneText.getText(), emailText.getText(), countryText.getText());
			insertToDatabase(user);
			dispose();
			}
			else{
				JOptionPane.showMessageDialog(null,"You have to fill all the required fields!","Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (arg0.getSource()==reset){
			
			nameText.setText("");
			surnameText.setText("");
			birthText.setText("");
			bloodText.setText("");
			phoneText.setText("");
			emailText.setText("");
			countryText.setText("");
			
		}
		
	}
	
	
	
	
public void insertToDatabase(Lifeliner user){
	
	//Connecting to the database
	final String DATABASE_URL="jdbc:mysql://localhost/javaproject";
	Connection connection = null;
	Statement statement = null;
	//End of database connection
	
try{
		
		connection=DriverManager.getConnection(DATABASE_URL,"root","");
		statement = connection.createStatement();
		statement.executeUpdate("insert into lifeliners (p_name, p_surname, p_date_of_birth,p_blood_type, p_phone, p_email, p_country) values( '"+user.getName()+"','"+user.getSurname()+"','"+user.getBirthdate()+"','"+user.getBloodType()+"', '"+user.getPhoneNumber()+"', '"+user.getEmail()+"','"+user.getCountry()+"')");
		
	}

	
	catch(Exception exc){
		
		exc.printStackTrace();
		
	}
	
}

	
	
}
