package jacksonPractices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class IterateOverAnArray {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		String username = "";
		String password = "";
		File file = new File("src/test/resources/user_credentials.json");
		
		FileReader fileReader = new FileReader(file);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		
		
		// convert JSON string into JSON Object using JSONObject() method  
        JSONObject json = new JSONObject(jsonTokener);   
          
        // get locations array from the JSON Object and store it into JSONArray  
        JSONArray jsonArray = json.getJSONArray("credentials");  
          
        JSONArray jsonArray1 = new JSONArray();
        JSONObject explrObject = null;
        // Iterate jsonArray using for loop   
        for (int i = 0; i < jsonArray.length(); i++) {  
              
            // store each object in JSONObject  
            explrObject = jsonArray.getJSONObject(i);  
              
        }  
        
        System.out.println(explrObject.get("username"));
        
        
	/*	Base64.Encoder encoder = Base64.getEncoder();  
		String str = encoder.encodeToString(password.getBytes());  
		System.out.println("Encoded string: "+str);  */


/*		Base64.Decoder decoder = Base64.getDecoder();  
		String decodedPassword = new String(decoder.decode(password));  
		System.out.println("Decoded string: "+decodedPassword);  
	

        System.out.println(username); 
        System.out.println(decodedPassword); 
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/login");
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(decodedPassword);
        driver.findElement(By.name("commit")).click();
        
        */
        
        

	}

}
