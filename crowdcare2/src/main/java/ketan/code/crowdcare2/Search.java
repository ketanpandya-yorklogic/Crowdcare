package ketan.code.crowdcare2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Search {
	private final static String pre_url="https://en.wikipedia.org/w/api.php?action=opensearch&format=json&search=%s&limit=3";
	
	private final String urlstr;
	
	Search(String title){
		urlstr = String.format(pre_url, title);
	}
			
	ArrayList<SearchResult> doWikiQuery(){
		ArrayList<SearchResult> list = new ArrayList<SearchResult>();
		try {
			URL url = new URL(urlstr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			
			readSearchResult(in, list);
			in.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	private void readSearchResult(java.io.Reader reader, ArrayList<SearchResult> list){
	       JSONParser parser = new JSONParser();

	        try {

	            Object obj = parser.parse(reader);
	            
	            JSONArray jarray = (JSONArray) obj;
	            JSONArray titles= (JSONArray)jarray.get(1);
	            JSONArray urls= (JSONArray)jarray.get(3);
	            
	            for (int idx=0; idx < titles.size(); idx++){
	            	list.add(new SearchResult(titles.get(idx).toString(), urls.get(idx).toString()));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	}
}
