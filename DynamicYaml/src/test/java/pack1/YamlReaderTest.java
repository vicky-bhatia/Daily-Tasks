package pack1;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;

public class YamlReaderTest extends DynamicYamlReader
{
	@Test
	public void fileReader() throws FileNotFoundException
	{
		String url=getData("parent.child1");
		System.out.println(url);
	}
}

