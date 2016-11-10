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
		
		//////////////////////////////////////////// JSON POST ///////////////////////////
		String json = "{\"beat\":{\"id\":1,\"message\":\"epa\",\"idto\":1,\"latitude\":6,\"longitude\":1}}";
		
		String urlPost = "http://localhost/2dam-project-multisite/web/app_dev.php/admin/api/form/beat/create";

			if (webRequest.postJson(urlPost, json)) {
				System.out.println("OK POST: " + webRequest.getResponseString() + "\n" + webRequest.getResponseCode());
			} else {
				System.out.println("Error: " + webRequest.getExceptionMessage() + "\n" + webRequest.getResponseCode());			
			}
			
			// "{\"item\":{\"id\":1,\"name\":\"yeah\",\"description\":\"Ok\",\"status\":1}}"
			// /admin/api/form/item/create
			
			// {\"beat\":{\"id\":1,\"message\":\"aaaa\",\"idto\":1,\"latitude\":6,\"longitude\":1}}
			// /admin/api/form/beat/create
			
			// {\"class\":{\"id\":1,\"name\":\"aaaa\",\"description\":\"aaaabbbb\",\"latitude\":6,\"longitude\":1}}
			// /admin/api/form/class/create
			
			// {\"event\":{\"id\":1,\"name\":\"aaaa\",\"description\":\"aaaabbbb\",\"latitude\":6,\"longitude\":1}}
			// /admin/api/form/event/create
			
			// {\"meetup\":{\"id\":1,\"name\":\"aaaa\",\"description\":\"aaaabbbb\",\"latitude\":6,\"longitude\":1,\"open\":1}}
			// /admin/api/form/meetup/create
	}
}
