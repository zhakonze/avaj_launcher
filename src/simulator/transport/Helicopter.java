package simulator.transport;


import simulator.Coordinates;
import simulator.WeatherTower;

import java.util.HashMap;
import java.util.Map;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, simulator.Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        Map<String, String> map = new HashMap<String, String>(){{
            put("SUN", " The sun is blinding me");
            put("RAIN", " Hope i left my clothes off the line ");
            put("FOG", " Hate waking up to a fogy weather ");
            put("SNOW", " Wow the snow, Zambia doesn't have such ");
        }};
        if (weather == "SUN")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2
            );

        }
        else if (weather == "RAIN")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 0
            );

        }
        else if (weather == "FOG")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 0
            );

        }
        else if (weather == "SNOW")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 12
            );

        }



    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says" + this.name + this.id + " registered to weather tower");
    }
}
