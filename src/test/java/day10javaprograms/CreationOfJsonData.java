package day10javaprograms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreationOfJsonData {

	public static void main(String[] args) throws JsonProcessingException {

		JsonNodeFactory factory = new JsonNodeFactory(false);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode employee = factory.objectNode();
		employee.put("EmpID", 100);
		employee.put("FirstName", "Kirthivasan");
		employee.put("LastName", "LV");
		
		ArrayNode technologies = factory.arrayNode();
		technologies.add("Python").add("Java").add("Javascript");
		
		employee.set("technologies", technologies);
		
		String employeeData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		System.out.println(employeeData);
		
		
	}

}
