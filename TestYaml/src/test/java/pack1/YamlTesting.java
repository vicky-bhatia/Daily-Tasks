package pack1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlTesting {

	public static void main(String[] args) throws Throwable, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		User user = mapper.readValue(new File("user.yml"), User.class);
		//System.out.println(ReflectionToStringBuilder.toString(user,ToStringStyle.MULTI_LINE_STYLE));

		//System.out.println(Arrays.toString(user.getRolls()));
		System.out.println(user.getAddress().get("lineA"));
		System.out.println(user.getName());

	}
}
