package training.weather;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static training.weather.ForecastEnum.PARTLY_CLOUDY;

public class ForecastEnumTest {

    @Test
    public void getEnumByCode() throws IOException {
        Assert.assertEquals(PARTLY_CLOUDY, ForecastEnum.getEnumByCode(2));
    }

    @Test
    public void getDescription() throws IOException {
        Assert.assertEquals("Overcast", ForecastEnum.OVERCAST.getDescription());
    }
}
