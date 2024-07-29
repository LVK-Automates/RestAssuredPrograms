package jacksonPractices;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreatingAJsonFile {

	public static void main(String[] args) {

		 // create instance of JSONObject  
        JSONObject jsonObject = new JSONObject();  
          
        // use put() method for inserting the data into JSON object  
        jsonObject.put("college name", "TVK College of Engineering");  
        jsonObject.put("department","B.E");  
        jsonObject.put("branch", "C.S.E");  
        jsonObject.put("year", 3);  
          
        //create JSON Array and store record into JSONObject  
        JSONArray list1 = new JSONArray(); 
        
        list1.put("Rajinikanth");
        list1.put("KamalHaasan");
        list1.put("Shahrukh Khan");
  
        jsonObject.put("Student Names", list1);  
          
        JSONArray list2 = new JSONArray();  
        list2.put("Python");
        list2.put("Javascript");
        list2.put("JAVA"); 
  
        jsonObject.put("Courses", list2);  
          
        JSONArray list3 = new JSONArray();  
        list3.put(1);
        list3.put(2);
        list3.put(3);  
        
  
        jsonObject.put("Year", list3);  
          
        // create instance of the FileWriter class by passing the path of the file in the constructor  
        try (FileWriter file = new FileWriter("src/test/resources/stu.json")) {  
              
            // use write() method to add JSONObject into file   
            file.write(jsonObject.toString());  
            file.flush();  
  
        }  
        catch (IOException e) {  
            e.printStackTrace();  
        }  
          
        // get locations array from the JSON Object and store it into JSONArray  
        JSONArray jsonArray = (JSONArray) jsonObject.get("Courses");  
          
          
        // Iterate jsonArray using for loop   
        for (int i = 0; i < jsonArray.length(); i++) {  
              
            // get field value from JSON Array  
            System.out.println(jsonArray.get(i));  
        }  
    }  
		
		
}
