package training.weather;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RequestTest {
    Request request = new Request();

    @Test
    public void getResponseGeoCode() throws IOException {
        JSONObject response = request.getResponseGeoCode("Madrid");
        Assert.assertNotEquals(null, response);
    }

    @Test
    public void getLongt() throws IOException {
        JSONObject response = request.getResponseGeoCode("Madrid");
        Assert.assertEquals(response.get("longt").toString(), "-3.67930");
    }

    @Test
    public void getLatt() throws IOException {
        JSONObject response = request.getResponseGeoCode("Madrid");
        Assert.assertEquals(response.get("latt").toString(), "40.42955");
    }

    @Test
    public void getResponseForecast() throws  IOException {
        String response = request.getResponseForecast("-3.67930", "40.4288161347569");
        Assert.assertNotEquals(null, response);
    }
}
