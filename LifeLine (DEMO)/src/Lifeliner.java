//import java.util.*;

public class Lifeliner {
	
	private String name;
	private String surname;
	private String birthdate;
	private String bloodType;
	private String phoneNumber;
	private String email;
	private String country;
	//protected static ArrayList<Lifeliner> LifelinersList = new ArrayList<Lifeliner>();
	

	
	public Lifeliner(String name, String surname, String birthdate, String bloodType, String phoneNumber, String email, String country){
		
		this.name=name;
		this.surname=surname;
		this.birthdate=birthdate;
		this.bloodType=bloodType;
		this.phoneNumber=phoneNumber;
		this.email=email;
		this.country=country;
		
		//LifelinersList.add(this);
		
}
	
	public Lifeliner(){
		
	}
	
	

public String getName(){
	
	return this.name;
}

public String getSurname(){
	
	return this.surname;
}

public String getBirthdate(){
	
	return this.birthdate;
}

public String getBloodType(){
	
	return this.bloodType;
}

public String getPhoneNumber(){
	
	return this.phoneNumber;
}

public String getEmail(){
	
	return this.email;
}

public String getCountry(){
	
	return this.country;
}


public void setName(String name){
	
	this.name=name;
	
}

public void setSurname(String surname){
	
	this.surname=surname;
}

public void setBirthdate(String birthdate){
	
	this.birthdate=birthdate;
}

public void setBloodType(String bloodType){
	
	this.bloodType=bloodType;
	
}

public void setPhoneNumber(String phoneNumber){
	
	this.phoneNumber=phoneNumber;

}

public void setEmail(String email){
	
	this.email=email;
}

public void setCountry(String country){
	
	this.country=country;
}

/* public  ArrayList<Lifeliner> getList() {
	
	return LifelinersList;
}
*/

}



