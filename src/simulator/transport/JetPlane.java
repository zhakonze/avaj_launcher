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

//    public void changeCoordinates (int longitude, int latitude, int height) {
//        this.coordinates.longtitude += longitude;
//        this.coordinates.latitude += latitude;
//        this.coordinates.height += height;
//    }
    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);

        if(weather == "SUN")
        {
            //this.coordinates.changeCoordinates(0, 0, 5);
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2
            );
            log.writeToFile("JetPlane#" + this.name + "(" + this.id + ") Dam its really hitting up in here");
        }
        else if (weather == "RAIN")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight() + 0
            );
            log.writeToFile("JetPlane#" + this.name + "(" + this.id + ") This rain is making hard for me to see");
        }
        else if (weather == "FOG")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight() + 0
            );
            log.writeToFile("JetPlane#" + this.name + "(" + this.id + ") I wish i could use something to blow away this");
        }
        else if (weather == "SNOW")
        {
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 7
            );
            log.writeToFile("JetPlane#" + this.name + "(" + this.id + ") Landing will be hard in this weather");
        }
        if (this.coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            log.writeToFile("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower");
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        log.writeToFile("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower");
    }

}
