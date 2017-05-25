import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class ShowLifelineRecords extends JFrame implements ActionListener {
	
	    //Initializing the Panels
		JPanel northPanel= new JPanel();
		JPanel southPanel= new JPanel();
		//End of Initializing Panels
		
		JLabel welcomeLabel = new JLabel("Here you can access the Lifelines of your patients!");
		JLabel idLabel = new JLabel("  Please enter the patient's ID: ");
		JTextField idText = new JTextField(20);
		JButton submit = new JButton("submit");
		
		
		//Initializing the Table
		static JTable lifelineTable = new JTable() {
		        private static final long serialVersionUID = 1L;

		        public boolean isCellEditable(int row, int column) {                
		                return false; //cells are set to be read-only              
		        };
		    };
		    
		static DefaultTableModel model = new DefaultTableModel(){};
		//End of initializing the Table
	
	
		
		
	public ShowLifelineRecords(){
		
		lifelineTable.setModel(model);
		
		//GUI specifications
		 setLayout(new BorderLayout());
		 setSize(700,500);
		 setTitle("Lifeline Records");
		 setLocationRelativeTo(null);
		 setVisible(true);
		 setResizable(false);
		 //End of GUI Specifications
		
		 add("North", northPanel);
		 add("South", southPanel);
		 northPanel.add(idLabel);
		 northPanel.add(idText);
		 northPanel.add(submit);
		 
		 southPanel.add(welcomeLabel);		 
		 //Adding the Table
		 add(new JScrollPane(lifelineTable));
		 //End of adding the Table
		 
		 submit.addActionListener(this);
		
		 
this.addWindowListener(new WindowAdapter() {
			 
			 public void windowClosing(WindowEvent e) {
				 
				 model.setRowCount(0);
				  
			      }
			 });
		
		
		
	}
	
	 


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource()==submit){
			
			if(searchForId(Integer.parseInt(idText.getText()))){
				
			
			loadLifelineData(Integer.parseInt(idText.getText()));
			
		}
			else{
				JOptionPane.showMessageDialog(null,"This ID is not having a lifeline yet!","Warning",JOptionPane.ERROR_MESSAGE);
			}
			}
		
	}
	
	
	public static void loadLifelineData(int id){
		
		//Connecting to the database
		final String DATABASE_URL="jdbc:mysql://localhost/javaproject";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		//End of database connection
		
		//Initializing the columns Names
		Object[] columnsName = new Object[7];
       
       columnsName[0] = "ID";
       columnsName[1] = "Blood Pressure";
       columnsName[2] = "Body Temperature";
       columnsName[3] = "Blood Sugar Level";
       columnsName[4]="Heart Rate";
       columnsName[5]="Calories Burned";
       columnsName[6]="TimeStamp";
       
       model.setColumnIdentifiers(columnsName);
       //End of initializing the columns Names
       
       //Getting the data from the database
       Object[] rowData = new Object[7];
       
       
try{
			
			connection=DriverManager.getConnection(DATABASE_URL,"root","");
			statement = connection.createStatement();
			resultSet= statement.executeQuery("select * from lifeliners_records where p_id='"+id+"'");
			
			model.setRowCount(0);
			
			while(resultSet.next()){
				
				            rowData[0] = resultSet.getString("p_id");
				            rowData[1] = resultSet.getString("blood_pressure");
				            rowData[2] = resultSet.getString("body_temperature");
				            rowData[3] = resultSet.getString("blood_sugar_level");
				            rowData[4] = resultSet.getString("heart_rate");
				            rowData[5] = resultSet.getString("calories_burned");
				            rowData[6] = resultSet.getString("record_time");
				         
				               
				               model.addRow(rowData);
				
			
				
			}
			
		}

		
		catch(Exception exc){
			
			exc.printStackTrace();
			
		}


	} //End of getting the data
	
public void showLifeline(String id){
	
	this.idText.setText(id);
	this.submit.doClick();
	
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
			resultSet= statement.executeQuery("select p_id from lifeliners_records");
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
