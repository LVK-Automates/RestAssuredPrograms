package jacksonPractices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreatingAJsonData {

	public static void main(String[] args) throws JsonProcessingException {

	     JsonNodeFactory factory = new JsonNodeFactory(false);
	      ObjectMapper mapper = new ObjectMapper();
	      ObjectNode employee = factory.objectNode();
	      employee.put("empId", 125);
	      employee.put("firstName", "Raja");
	      employee.put("lastName", "Ramesh");
	      
	      ArrayNode technologies = factory.arrayNode();
	      technologies.add("Python").add("Java").add("SAP");
	      employee.set("technologies", technologies);
	      System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee));
	   }
		
		

}
