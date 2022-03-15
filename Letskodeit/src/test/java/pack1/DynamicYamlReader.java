package pack1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;


public class DynamicYamlReader {
	public static String yamlFilePath = "C:\\Users\\vicky.bhatia\\eclipse-workspace\\Letskodeit\\newlocators.yml";

    @SuppressWarnings("unchecked")
	public static String getData(String token) throws FileNotFoundException
    {
        Reader file = new FileReader(yamlFilePath);
        Yaml yaml = new Yaml();
        Map<String, Object> object = (Map<String, Object>) yaml.load(file);
        return getMapValue(object, token);
    }

    public static String getMapValue(Map<String, Object> object, String token)
    {
        String[] st = token.split("\\.");

        /*Note: Why double backward slash ?
        Using a . (dot) will be interpreted as a regex metacharacter which means "any character".
        Using \. will give a compiler error viz. Illegal Escape Character
        Using \\. will be interpreted as a simple . (dot) character, which is what you need to use.*/

        return parseMap(object, token).get(st[st.length - 1]).toString();
    }

    @SuppressWarnings("unchecked")
	public static Map<String, Object> parseMap(Map<String, Object> object, String token)
    {
        if (token.contains(".")) {
            String[] st = token.split("\\.");
            object = parseMap((Map<String, Object>) object.get(st[0]), token.replace(st[0] + ".", ""));
        }
        return object;
    }

}
