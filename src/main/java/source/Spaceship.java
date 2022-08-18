package source;

public class Spaceship extends AbstractBuilding{


    public void placeSpaceship() {
        location = new Location(0,0);
    }

    public boolean isFinished() {
        return this.getProgress() >= 100;
    }

}
