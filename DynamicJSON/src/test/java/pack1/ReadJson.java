package pack1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadJson {

	public static void parseObject(JSONObject json, String key) {
		System.out.println(json.get(key));
	}

	public static void getKey(JSONObject json,String key)
	{
		boolean exists=json.has(key);
		Iterator<?> keys;
		String nextKeys;
		if(!exists) {
			keys=json.keys();
			while(keys.hasNext())
			{
				nextKeys=(String)keys.next();
				try {
					if(json.get(nextKeys) instanceof JSONObject){
						if(exists==false) {
							getKey(json.getJSONObject(nextKeys),key);
						}
					}
					else if(json.get(nextKeys) instanceof JSONArray){
						JSONArray jsonarray=json.getJSONArray(nextKeys);
						for(int i=0;i<jsonarray.length();i++)
						{
							String jsonarrayString=jsonarray.get(i).toString();
							JSONObject innerjson=new JSONObject(jsonarrayString);
							if(exists==false)
							{
								getKey(innerjson,key);
							}
						}
					}
				}catch(Exception e){

				}
			}
		}
		else {
			parseObject(json,key);
		}
	}
	public static void main(String[] args) throws Throwable {

		String resourceName = "data.json";
		InputStream is = new FileInputStream(resourceName);
		JSONTokener tokener = new JSONTokener(is);
		JSONObject obj = new JSONObject(tokener);
		getKey(obj,"state");
	}

}
