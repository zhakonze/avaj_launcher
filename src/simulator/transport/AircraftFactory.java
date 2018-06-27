package simulator.transport;


import simulator.Coordinates;

public class AircraftFactory
{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude,latitude,height);

        if(type.equals("Balloon"))
            return (new Balloon(name, coordinates));
        else if (type.equals("JetPlane"))
            return (new JetPlane(name, coordinates));
        else if (type.equals("Helicopter"))
            return (new Helicopter(name, coordinates));


        return null;
    }

}
