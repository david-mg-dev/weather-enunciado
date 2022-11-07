package training.weather;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public class RequestApi {
    public String getResponseGeoCode(String city) throws IOException {
        String URL = "https://geocode.xyz/" + city + "?json=1";

        HttpRequestFactory httpRequestFactory = new NetHttpTransport()
                .createRequestFactory();
        HttpRequest httpRequest = httpRequestFactory
                .buildGetRequest(new GenericUrl(URL));

        String response = httpRequest.execute().parseAsString();

        return response;
    }
    public String getResponseForecast(String longt, String latt) throws IOException {
        String URL = "https://api.open-meteo.com/v1/forecast?latitude=" +
                latt + "&longitude=" + longt + "&daily=weathercode&current_weather=true&timezone=Europe%2FBerlin";

        HttpRequestFactory httpRequestFactory = new NetHttpTransport()
                .createRequestFactory();
        HttpRequest  httpRequest = httpRequestFactory
                .buildGetRequest(new GenericUrl(URL));

        String response = httpRequest.execute().parseAsString();

        return response;
    }
}

