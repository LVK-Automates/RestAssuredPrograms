package jacksonPractices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ObjectNodeTest {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		
		File file = new File(".\\src\\test\\resources\\user_credentials.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode node = objMapper.readValue(fileReader, ObjectNode.class);
	//	if(node.has("username"))
			System.out.println(node.get("username"));
			System.out.println(node.get("password"));

		
/*		System.out.println("*** NODES ***");
		
		
		
		Iterator<Map.Entry<String, JsonNode>> fields = node.fields();

		while(fields.hasNext()) {
		    Map.Entry<String, JsonNode> field = fields.next();
		    String   fieldName  = field.getKey();
		    JsonNode fieldValue = field.getValue();

		    System.out.println(fieldName + " = " + fieldValue.asText());
		}
		
		*/
		
		
	}

}
