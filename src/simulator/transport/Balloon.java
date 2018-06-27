package simulator.transport;

import simulator.Coordinates;
import simulator.WeatherTower;

import java.util.HashMap;
import java.util.Map;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        Map<String, String> map = new HashMap<String, String>()
        {{
            put("SUN", "We'll be baked in this ballon with this heat");
            put("RAIN", "The rain, just what i've been waiting for");
            put("FOG", "Its 10am now and the fog still hasn't cleared");
            put("SNOW", "What time till the snow clears weatherman?");
        }};
        if(weather == "SUN")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 4
            );

        }
        else if (weather == "RAIN")
        {
            this.coordinates = new Coordinates(
              coordinates.getLongitude() + 0,
              coordinates.getLatitude() + 0,
              coordinates.getHeight() - 5
            );

        }
        else if (weather == "FOG")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 3
            );

        }
        else if (weather == "SNOW")
        {
            this.coordinates = new Coordinates(
              coordinates.getLongitude() + 0,
              coordinates.getLatitude() + 0,
              coordinates.getHeight() - 15
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
