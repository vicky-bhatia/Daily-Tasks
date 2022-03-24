package pack2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class WriteJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		JSONObject obj=new JSONObject();
		Object key,value;
		int numberOfKeysAndValues;
		System.out.print("Enter the required number of keys & values: ");
		numberOfKeysAndValues=scn.nextInt();
		for(int i=0;i<numberOfKeysAndValues;i++)
		{
			System.out.print("Enter Key :");
			key=scn.next();
			System.out.print("Enter Value : ");
			value=scn.next();
			obj.put(key,value);
		}
		try {
			FileWriter fw=new FileWriter("C:\\Users\\vicky.bhatia\\eclipse-workspace\\DynamicJSON\\JSON Files\\writedata.json");
			fw.write(obj.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
