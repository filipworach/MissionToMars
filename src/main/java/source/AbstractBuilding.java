package source;

public abstract class AbstractBuilding {
    protected Location location;
    protected int progress;

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location=location;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
