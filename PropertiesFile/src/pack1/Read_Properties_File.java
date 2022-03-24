package pack1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Read_Properties_File {

	public static void main(String[] args) throws IOException {
		
		File file=new File("configuration.properties");// Create the File object and pass the 'properties file location in File constructor.
		FileInputStream fileInput=new FileInputStream(file);//Create FileInputstream object to read the file
		Properties prop=new Properties();// Create properties class object
		prop.load(fileInput);// Load the property file in Inputstream
		
		// fetching the value from properties file
		String Name_Value=prop.getProperty("Name");
		String BrowserName_Value=prop.getProperty("BrowserName");
		String Id_Value=prop.getProperty("Id");
		String Password_Value=prop.getProperty("Password");
		String Fly_Value=prop.getProperty("Fly");
		
		//Print the value of key 'Name' 
		System.out.println(Name_Value); //output-> selenium tutorial
		System.out.println(BrowserName_Value);//output-> chrome
		System.out.println(Id_Value);//output-> Test
		System.out.println(Password_Value);//output-> Test123
		System.out.println(Fly_Value);
		
	}
}
