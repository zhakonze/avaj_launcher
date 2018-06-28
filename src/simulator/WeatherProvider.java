package simulator;

import java.util.Random;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();;
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider()
    {

    }

    public static WeatherProvider getProvider()
    {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        //int pin = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
        Random rand = new Random();

        int randWeather = rand.nextInt(4);
        return weather[randWeather];
    }
}
