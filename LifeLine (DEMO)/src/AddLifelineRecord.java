import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddLifelineRecord extends JFrame implements ActionListener {

	JLabel idLabel = new JLabel("  Patient's ID: ");
	JLabel bloodPressureLabel = new JLabel("  Blood Pressure (mm Hg): ");
	JLabel bodyTemperatureLabel = new JLabel("  Body Temperature (Degree Celsius): ");
	JLabel bloodSugarLevelLabel = new JLabel("  Blood Sugar Level (mg/dL): ");
	JLabel heartRateLabel = new JLabel("  Heart Rate (bpm): ");
	JLabel caloriesBurnedLabel = new JLabel("  Calories Burned (cal): ");
	JLabel note = new JLabel("Please note that each record will have a Timestamp.");
	
	
	JTextField idText= new JTextField(20);
	JTextField bloodPressureText= new JTextField(20);
	JTextField bodyTemperatureText = new JTextField(8);
	JTextField bloodSugarLevelText= new JTextField(3);
	JTextField heartRateText= new JTextField(15);
	JTextField caloriesBurnedText= new JTextField(20);
	
	JButton submit = new JButton("Submit");
	JButton reset = new JButton("Clear");
	
	boolean externalForm = false;
	
	
	
	
	
	public AddLifelineRecord(){
		
		setTitle("Adding a Lifeline Record");
		setLayout(new GridLayout(8,2,10,10));
		setSize(640,480);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		add(idLabel);
		add(idText);
		add(bloodPressureLabel);
		add(bloodPressureText);
		add(bloodSugarLevelLabel);
		add(bloodSugarLevelText);
		add(bodyTemperatureLabel);
		add(bodyTemperatureText);
		add(heartRateLabel);
		add(heartRateText);
		add(caloriesBurnedLabel);
		add(caloriesBurnedText);
		add(submit);
		add(reset);
		add(note);
		
		submit.addActionListener(this);
		reset.addActionListener(this);
		
		
		
		
	}





	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		
		if(arg0.getSource()==submit){
			
			
			boolean x = idText.getText().equals("");
			int id= -1;
			
			if(!x){
				id=Integer.parseInt(idText.getText());
			} //Error checking
			
		
			
			if(searchForId(id)) {
				
				if(!( (idText.getText().equals("")) || (bloodPressureText.getText().equals("")) || (bodyTemperatureText.getText().equals("")) || (bloodSugarLevelText.getText().equals("")) || (heartRateText.getText().equals("")) || (caloriesBurnedText.getText().equals("")))){
				insertLifelineToDatabase();
				JOptionPane.showMessageDialog(null, "The record has been added successfully!");
				dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"You have to fill all the required fields!","Warning",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			
			
			else{
				JOptionPane.showMessageDialog(null,"The ID number is not present within your Patients' records!","Warning",JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			
			
			}//submit button
		if(arg0.getSource()==reset){
			
			if(externalForm == false){
			idText.setText("");
			bloodPressureText.setText("");
			bodyTemperatureText.setText("");
			bloodSugarLevelText.setText("");
			heartRateText.setText("");
			caloriesBurnedText.setText("");
			}
			else{
				bloodPressureText.setText("");
				bodyTemperatureText.setText("");
				bloodSugarLevelText.setText("");
				heartRateText.setText("");
				caloriesBurnedText.setText("");
				
			}
			
			
			
			
			
			
		}
		
			
			
}//Action performed
		
	
	public boolean searchForId(int id){
		
		//Connecting to the database
			final String DATABASE_URL="jdbc:mysql://localhost/javaproject";
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			boolean available = false;
			//End of database connection
			
		try{
				
				connection=DriverManager.getConnection(DATABASE_URL,"root","");
				statement = connection.createStatement();
				resultSet= statement.executeQuery("select p_id from lifeliners");
				while(resultSet.next()){
					
					if (id==resultSet.getInt("p_id"))
						available=true;
				
				}
				
				
			}

			
			catch(Exception exc){
				
				exc.printStackTrace();
			
				
			}
			
		
		return available;
	}
	
	public void insertLifelineToDatabase(){
		
		//Connecting to the database
		final String DATABASE_URL="jdbc:mysql://localhost/javaproject";
		Connection connection = null;
		Statement statement = null;
		//End of database connection
		
	try{
			
			connection=DriverManager.getConnection(DATABASE_URL,"root","");
			statement = connection.createStatement();
			statement.executeUpdate("insert into lifeliners_records (p_id, blood_pressure, body_temperature, blood_sugar_level, heart_rate, calories_burned) values( '"+Integer.parseInt(idText.getText())+"','"+Double.parseDouble(bloodPressureText.getText())+"','"+Double.parseDouble(bodyTemperatureText.getText())+"','"+Double.parseDouble(bloodSugarLevelText.getText())+"', '"+Double.parseDouble(heartRateText.getText())+"', '"+Double.parseDouble(caloriesBurnedText.getText())+"')");
			
		}

		
		catch(Exception exc){
			
			exc.printStackTrace();
			
		}
		
	}
	
	public void setId(String id){
		
		this.idText.setText(""+id);
		this.idText.setEditable(false);
		this.externalForm=true;
	}
	
	
	
}
