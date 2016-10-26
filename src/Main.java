import java.util.Hashtable;

import org.json.JSONArray;
import org.json.JSONObject;




public class Main {
	public static void main (String args[]) {
		WebRequest webRequest = new WebRequest();
		
		if (webRequest.get("http://it-ebooks-api.info/v1/search/php")) {
			System.out.println("OK Total: " + webRequest.getResponseString());
		} else {
			System.out.println("Error: " + webRequest.getExceptionMessage());			
		}
		  
		JSONObject jsonResponse = new JSONObject(webRequest.getResponseString());
		JSONArray books = jsonResponse.getJSONArray("Books");
		
		for (int i = 0; i < books.length(); i++) {
			System.out.println(books.getJSONObject(i).getString("Title"));
		}
	}
}
