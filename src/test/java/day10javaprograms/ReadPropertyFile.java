package day10javaprograms;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {

		
		FileReader reader = new FileReader("src/test/resources/TestFile.properties");
		
		Properties properties = new Properties();
		
		properties.load(reader);
	String user = 	properties.getProperty("user");
	String password =	properties.getProperty("password");
	System.out.println("User name is : "+user);
	System.out.println("Password is: "+password);
		
		
	}

}
