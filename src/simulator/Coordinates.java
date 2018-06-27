package simulator;


public class Coordinates
{
    int longitude;
    int latitude;
    int height;

    Coordinates(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;

    }
    public int getLongitude()
    {
        return longitude;
    }

    public int getLatitude()
    {
        return latitude;
    }

    public int getHeight()
    {
        return height;
    }
}
