package training.weather;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherForecast {

	public static String getCityWeather(String city, LocalDate datetime) throws IOException {
		if (datetime == null) {
			datetime = LocalDate.now();
		}

		if (datetime.isAfter(LocalDate.now())) {
			JSONObject object = getJsonObject(city);

			JSONArray dailyResults = object.getJSONArray("time");
			JSONArray weatherCodeResults = object.getJSONArray("weathercode");

			int code = Integer.parseInt(initMap(dailyResults, weatherCodeResults).get(datetime.toString()));

			return ForecastEnum.getEnumByCode((code)).getDescription();
		}

		return "";
	}

	private static JSONObject getJsonObject(String city) throws IOException {
		RequestApi request = new RequestApi();
		JSONObject objectResponse = new JSONObject(request.getResponseGeoCode(city));
		JSONObject object = new JSONObject(request.getResponseForecast(objectResponse.get("longt").toString(), objectResponse.get("latt").toString())).getJSONObject("daily");

		return object;
	}

	private static Map<String, String> initMap(JSONArray dailyResults, JSONArray weatherCodeResults) throws IOException {
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < dailyResults.length(); i++)
			map.put(dailyResults.get(i).toString(), weatherCodeResults.get(i).toString());

		return map;
	}
}
