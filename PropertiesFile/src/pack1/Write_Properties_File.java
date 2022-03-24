package pack1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Write_Properties_File {

	public static void main(String[] args) throws IOException {
		File file=new File("configuration.properties");
		FileInputStream fileInput=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fileInput);
		prop.setProperty("RollNo","1813310232");
		prop.setProperty("BrowserName","FireFox");
		FileOutputStream FileOutput=new FileOutputStream(file);
		prop.store(FileOutput, null);

	}

}
