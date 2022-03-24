package jsonPractice;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJsonWithoutJavaObj {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		JSONParser jp=new JSONParser();//Parse the whole JSON file
		FileReader fr=new FileReader("practiceData.json");//Loads the JSON file
		JSONObject jsonObj=(JSONObject) jp.parse(fr);//parse the JSON data which is present inside the "fr" and for that we have to use "jp"
									//jp.parse(fr) returns a java object
		
//Now we have to typeCast the above java object as a JSON object
		
		//JSONObject jsonObj=(JSONObject)javaObj;
		String fname=(String)jsonObj.get("firstName");
		String lname=(String)jsonObj.get("lastName");
		System.out.println(fname+"\n"+lname+"\n");
		JSONArray jsonArray=(JSONArray)jsonObj.get("address");

		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject address=(JSONObject)jsonArray.get(i);
			String city=(String)address.get("city");
			String state=(String)address.get("state");
			Long pincode=(Long)address.get("pincode");

			System.out.println(i+"'s address is :"+"\n"+city+"\n"+state+"\n"+pincode+"\n");
		}
		
		JSONArray fruit=(JSONArray)jsonObj.get("fruits");
		for(int i=0;i<fruit.size();i++)
		{
			System.out.println(fruit.get(i));
		}


	}

}
