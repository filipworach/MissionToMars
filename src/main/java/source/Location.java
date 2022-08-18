package source;

public class Location {
    private int coordinateX = 0;
    private int coordinateY = 0;

    public Location(){}

    public Location(int x, int y) {
        coordinateX=x;
        coordinateY=y;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }


}
