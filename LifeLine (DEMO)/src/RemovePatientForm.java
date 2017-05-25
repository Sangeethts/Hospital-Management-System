import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemovePatientForm extends JFrame implements ActionListener {
	
	
	JPanel northPanel = new JPanel();
	JPanel southPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JLabel removeLabel = new JLabel("Please type in the ID of the patient to be removed");
	JLabel idLabel= new JLabel("ID");
	JTextField idText=new JTextField();
	JButton submit = new JButton("Submit");
	JButton reset = new JButton("Clear");
	boolean externalForm = false;
	
	
	
	public RemovePatientForm(){
		
		setTitle("Removing a patient");
		setLayout(new BorderLayout());
		setSize(400,200);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		add("North", northPanel);
		add("South", southPanel);
		northPanel.add(removeLabel);
		southPanel.add(submit);
		southPanel.add(reset);
	
		add(idLabel);
		add(idText);
		
		submit.addActionListener(this);
		reset.addActionListener(this);;
		
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==submit){
			
			if(!(idText.getText().equals(""))){
		int selectedvalue = JOptionPane.showConfirmDialog(null, "Do you want to proceed with the deletion?", "do you want to proceed with the deletion?", JOptionPane.YES_NO_OPTION);
		
		if(selectedvalue==JOptionPane.YES_OPTION){
			
			int id=Integer.parseInt(idText.getText());
			if(searchForId(id)){
			
		removeToDatabase();
		dispose();
			}
			else{
				JOptionPane.showMessageDialog(null,"This ID is not available!","Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else{
			JOptionPane.showMessageDialog(null, "Nothing is affected!");
			
		
		}
			}
			
			else{
				JOptionPane.showMessageDialog(null,"You have to fill the ID number!","Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(arg0.getSource()==reset && externalForm==false){
			idText.setText("");
		}
		
		
		
	}
	
	public void removeToDatabase(){
		
		//Connecting to the database
		final String DATABASE_URL="jdbc:mysql://localhost/javaproject";
		Connection connection = null;
		Statement statement = null;
		//End of database connection
		
	try{
			
			connection=DriverManager.getConnection(DATABASE_URL,"root","");
			statement = connection.createStatement();
			statement.executeUpdate("delete from lifeliners where p_id= "+idText.getText());
			statement.executeUpdate("delete from lifeliners_records where p_id= "+idText.getText());
		}

		
		catch(Exception exc){
			
			exc.printStackTrace();
			
		}
		
	}
	
	
public void setIdText(String id){
	this.idText.setText(id);
	this.idText.setEditable(false);
	this.externalForm=true;
}

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

	
	

}
