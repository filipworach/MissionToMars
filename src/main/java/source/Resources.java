package source;

public class Resources {
    private String name;
    private Location location = new Location();
    private Marsjan marsjan = new Marsjan();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Marsjan getMarsjan() {
        return marsjan;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
