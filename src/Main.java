import java.util.Hashtable;

import org.json.JSONArray;
import org.json.JSONObject;




public class Main {
	public static void main (String args[]) {
		WebRequest webRequest = new WebRequest();
		
		if (webRequest.get("http://wzw.io/web/admin/api/meetup")) {
			System.out.println("OK Total: " + webRequest.getResponseString());
		} else {
			System.out.println("Error: " + webRequest.getExceptionMessage());			
		}
		  
		//JSONObject jsonResponse = new JSONObject(webRequest.getResponseString());
		JSONArray meetups = new JSONArray(webRequest.getResponseString());
		
		for (int i = 0; i < meetups.length(); i++) {
			System.out.println(meetups.getJSONObject(i).getString("name"));
		}
	}
}
