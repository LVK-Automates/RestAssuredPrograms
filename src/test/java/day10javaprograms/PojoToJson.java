package day10javaprograms;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoToJson {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		
		JsonPOJO obj = new JsonPOJO("Black", "Benz");
		
		mapper.writeValue(new File("src/test/resources/carcolors.json"), obj);
	}

}
