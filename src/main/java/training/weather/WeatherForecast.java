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

		if (datetime.before(new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 6)))) {
			RequestApi request = new RequestApi();

			String response = request.getResponseGeoCode(city);

			JSONObject objectResponse = new JSONObject(response);
			String longt = objectResponse.get("longt").toString();
			String latt = objectResponse.get("latt").toString();

			response = request.getResponseForecast(longt, latt);

			JSONArray dailyResults = new JSONObject(response).getJSONObject("daily").getJSONArray("time");
			JSONArray weatherCodeResults = new JSONObject(response).getJSONObject("daily").getJSONArray("weathercode");

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
}


