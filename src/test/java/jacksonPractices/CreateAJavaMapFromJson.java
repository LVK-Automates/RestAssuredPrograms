package jacksonPractices;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class CreateAJavaMapFromJson {

	public static void main(String[] args) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String,Object> map = objectMapper.readValue(
				Paths.get("src/test/resources/payments_payload.json").toFile(), 
				new TypeReference<Map<String, Object>>(){});

		//System.out.println(map);
		System.out.println(map.get("transactions"));

	}

}
