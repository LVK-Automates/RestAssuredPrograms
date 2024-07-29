package day10javaprograms;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreatingAJSON {

	public static void main(String[] args) throws IOException {

		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("college name", "xxx college of engineering");
		jsonObject.put("course", "BE");
		jsonObject.put("department", "CSE");
		jsonObject.put("year", "III");
		
		
		JSONArray list1 = new JSONArray();
		
		list1.put("Rahul");
		list1.put("Sachin");
		list1.put("Kohli");
		
		jsonObject.put("StudentNames", list1);
		
		JSONArray list2 = new JSONArray();
		
		list2.put("JAVA");
		list2.put("Python");
		list2.put("Javascript");
		
		jsonObject.put("Subjects", list2);
		
		FileWriter fileWriter = new FileWriter("src/test/resources/StudentsData.json");
		fileWriter.write(jsonObject.toString());
		fileWriter.flush();
		fileWriter.close();
		
		
		
		
		
	}

}
