package day10javaprograms;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Map<?,?> map = objectMapper.readValue(Paths.get("src/test/resources/user_credentials.json").toFile(), Map.class);
		
		for(Map.Entry<?, ?> mapEntry : map.entrySet())
		{
			
			System.out.println(mapEntry.getKey() + "=" + mapEntry.getValue());
		}
	}

}
