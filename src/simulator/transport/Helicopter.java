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

        if (weather == "SUN")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2
            );
            log.writeToFile("Helicopter#" + this.name + "(" + this.id + ") The sun is blinding me");
        }
        else if (weather == "RAIN")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 0
            );
            log.writeToFile("Helicopter#" + this.name + "(" + this.id + ") Hope i left my clothes off the line");
        }
        else if (weather == "FOG")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 0
            );
            log.writeToFile("Helicopter#" + this.name + "(" + this.id + ") Hate waking up to a fogy weather");
        }
        else if (weather == "SNOW")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 12
            );
            log.writeToFile("Helicopter#" + this.name + "(" + this.id + ") Wow the snow, Zambia doesn't have such");
        }
        if (this.coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            log.writeToFile("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower");
        }
    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        log.writeToFile("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower");
    }
}
