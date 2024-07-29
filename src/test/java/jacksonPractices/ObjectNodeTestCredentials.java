package jacksonPractices;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectNodeTestCredentials {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		
		
		ObjectMapper objectMapper = new ObjectMapper();

		Map<String,Object> map = objectMapper.readValue(
				Paths.get("src/test/resources/user_credentials.json").toFile(), new TypeReference<Map<String, Object>>(){});

		System.out.println(map);
		System.out.println(map.get("credentials"));


		
		
	}

}
