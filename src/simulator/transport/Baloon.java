package simulator.transport;

import simulator.Coordinates;
import simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        if(weather == "SUN")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude() ,
                    coordinates.getHeight() + 4
            );
            log.writeToFile("Baloon#" + this.name + "(" + this.id + ") We'll be baked in this ballon with this heat");
    }
        else if (weather == "RAIN")
        {
            this.coordinates = new Coordinates(
              coordinates.getLongitude() ,
              coordinates.getLatitude(),
              coordinates.getHeight() - 5
            );
            log.writeToFile("Baloon#" + this.name + "(" + this.id + ") The rain, just what i've been waiting for");
        }
        else if (weather == "FOG")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 3
            );
            log.writeToFile("Baloon#" + this.name + "(" + this.id + ") Its 10am now and the fog still hasn't cleared");
        }
        else if (weather == "SNOW")
        {
            this.coordinates = new Coordinates(
              coordinates.getLongitude(),
              coordinates.getLatitude(),
              coordinates.getHeight() - 15
            );
            log.writeToFile("Baloon#" + this.name + "(" + this.id + ") What time till the snow clear weatherman?");
        }
        if (this.coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            log.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower");
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        log.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower");
    }
}
