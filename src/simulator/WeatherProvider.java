package simulator;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider()
    {

    }

    public static WeatherProvider getProvider()
    {
        WeatherProvider weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        int pin = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() % 4;
        return weather[pin];

    }
}
