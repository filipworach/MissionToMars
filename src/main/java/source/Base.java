package source;

public class Base extends AbstractBuilding {
    private boolean isFinished;
    //baza umieszczana jest w centrum mapy
    public void placeBase(int mapaSize) {
        location = new Location(mapaSize/2, mapaSize/2);
    }

    public Location getLocation() {
        return location;
    }
    //metoda zwracająca informację, czy baza jest ukończona
    public boolean isFinished() {
        isFinished = this.progress >= 100;
        return isFinished;
    }
    //gdy Astronauta ukończy bazę, to może tam odnawiać sobie tlen
    public void refillAstronautOxygen() {
        if(isFinished)Mapa.getAstronaut().setAmountOfOxygen(Mapa.getAstronaut().getAmountOfOxygen()+100);
    }
}
