package simulator.transport;

import java.util.HashMap;
import java.util.Map;

import simulator.Coordinates;
import simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        Map<String, String> map = new HashMap<String, String>()
        {{
            put("SUN", "Dam its really hitting up in here");
            put("RAIN", "This rain is making hard for me to see");
            put("FOG", "I wish i could use something to blow away this");
            put("SNOW", "Landing will be hard in this weather");

        }};
        if(weather == "SUN")
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
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight() + 0
            );
        }
        else if (weather == "FOG")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight() + 0
            );
        }
        else if (weather == "SNOW")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 7
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
