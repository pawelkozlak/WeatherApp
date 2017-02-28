import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Klasa odpowiedzialna za parsowanie JSON-a do obiektu
 */
public class JSONParseToObject {

	private JSONObject json;
	private JSONObject jsonF;
	private JSONArray jArrayF;
	private double temperatura;
	private double temperaturaF;
	private double cisnienie;
	private double cisnienieF;
	private double wiatr;
	private int zachmurzenie;
	private String ikona;
	private String data;
	private double wiatrF;
	private int zachmurzenieF;
	
	
	public JSONParseToObject(String cityName) throws MalformedURLException, JSONException, IOException{
		json = new JSONObject(IOUtils.toString(new URL("http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&units=metric&appid=7cdcdbcb778c0662564707937081d1f7"), Charset.forName("UTF-8")));	
		jsonF = new JSONObject(IOUtils.toString(new URL("http://api.openweathermap.org/data/2.5/forecast?q="+cityName+"&units=metric&appid=7cdcdbcb778c0662564707937081d1f7"), Charset.forName("UTF-8")));
	}
	
	public double getTemperature() throws JSONException{
		temperatura = json.getJSONObject("main").getDouble("temp");
		return temperatura;
	}
	
	public double getCisnienie() throws JSONException{
		cisnienie = json.getJSONObject("main").getDouble("pressure");
		return cisnienie;
	}
	
	public double getWiatr() throws JSONException{
		wiatr = json.getJSONObject("wind").getDouble("speed");
		return wiatr;
	}
	
	public int getZachmurzenie() throws JSONException {
		zachmurzenie = json.getJSONObject("clouds").getInt("all");
		return zachmurzenie;
	}
	
	public String getIkona() throws JSONException {
		JSONArray jArray = json.getJSONArray("weather");
		JSONObject ikona = jArray.getJSONObject(0);
		return ikona.getString("icon");
	}
	
	//--------------------------------------------------------------
	
	
	public JSONArray getArray() throws JSONException {
		jArrayF = jsonF.getJSONArray("list");
		return jArrayF;
	}
	
	
	
}
