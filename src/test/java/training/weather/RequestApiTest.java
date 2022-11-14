package training.weather;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class RequestApiTest {
    RequestApi request = new RequestApi();

    @Test
    public void getResponseGeoCode() throws IOException {
        String response = request.getResponseGeoCode("Madrid");
        Assert.assertNotEquals(null, response);
    }

    @Test
    public void getLongt() throws IOException {
        String response = request.getResponseGeoCode("Madrid");
        JSONObject objectResponse = new JSONObject(response);
        Assert.assertEquals(objectResponse.get("longt").toString(), "-3.67930");
    }

    @Test
    public void getLatt() throws IOException {
        String response = request.getResponseGeoCode("Madrid");
        JSONObject objectResponse = new JSONObject(response);
        Assert.assertEquals(objectResponse.get("latt").toString(), "40.42955");
    }

    @Test
    public void getResponseForecast() throws  IOException {
        String response = request.getResponseForecast("-3.67930", "40.4288161347569");
        Assert.assertNotEquals(null, response);
    }
}


