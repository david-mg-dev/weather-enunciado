package training.weather;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherForecast {

	public static String getCityWeather(String city, Date datetime) throws IOException {
 		if (datetime == null) {
			datetime = new Date();
		}

		if  (datetime.before(new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 6)))) {
			JSONObject object = getJsonObject(city);

			JSONArray dailyResults = object.getJSONArray("time");
			JSONArray weatherCodeResults = object.getJSONArray("weathercode");

			for (int i = 0; i < dailyResults.length(); i++) {
				if (
						new SimpleDateFormat("yyyy-MM-dd")
								.format(datetime)
								.equals(dailyResults.get(i).toString()))
				{
					return ForecastEnum.getEnumByCode((int) weatherCodeResults.get(i)).getDescription();
				}
			}
		}
		return "";
	}
	private static JSONObject getJsonObject(String city) throws IOException {
		RequestApi request = new RequestApi();
		JSONObject objectResponse = new JSONObject(request.getResponseGeoCode(city));
		JSONObject object = new JSONObject(request.getResponseForecast(objectResponse.get("longt").toString(), objectResponse.get("latt").toString())).getJSONObject("daily");

		return object;
	}
}
