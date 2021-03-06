package simulator.transport;
import simulator.*;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0L;
    protected static LoggerWrite log = new LoggerWrite();

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId()
    {
        return (++idCounter);
    }

}
