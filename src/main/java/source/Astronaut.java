package source;

public class Astronaut {
    private String astronautName;
    private int astronautHp = 100;
    private int astronautFortune;
    private int amountOfOxygen = 100;
    private int amountOfIron;
    private Location astronautLocation = new Location();

    public String getAstronautName() {
        return astronautName;
    }

    public void setAstronautName(String astronautName) {
        this.astronautName = astronautName;
    }

    public int getAstronautHp() {
        return astronautHp;
    }

    public void setAstronautHp(int astronautHp) {
        this.astronautHp = astronautHp;
    }

    public int getAstronautFortune() {
        return astronautFortune;
    }

    public void setAstronautFortune(int astronautFortune) {
        this.astronautFortune = astronautFortune;
    }

    public int getAmountOfOxygen() {
        return amountOfOxygen;
    }

    public void setAmountOfOxygen(int amountOfOxygen) {
        this.amountOfOxygen = amountOfOxygen;
    }

    public int getAmountOfIron() {
        return amountOfIron;
    }

    public void setAmountOfIron(int amountOfIron) {
        this.amountOfIron = amountOfIron;
    }

    public Location getAstronautLocation() {
        return astronautLocation;
    }

    public void setAstronautLocation(Location astronautLocation) {
        this.astronautLocation = astronautLocation;
    }

    public void moveAstronaut(int moveX, int moveY){
        astronautLocation.setCoordinateX(moveX);
        astronautLocation.setCoordinateY(moveY);
    }
    public void moveAstronaut(Location newLocation){
        this.setAstronautLocation(newLocation);
    }
    /* metoda fight jest odpowiedzialna za walkę Astronauty z Marsjankiem (gracz ustawia na początku parametr fortune - im większa
    wartość tym mniejsze obrażenia zadaje Marsjanek Astronaucie) */
    public boolean fight(){
        Printer.print(astronautName+" is during the fight");
        this.setAstronautHp(this.getAstronautHp()- (50/ Main.fortune));
        if (this.getAstronautHp()>0)Printer.print(astronautName+" won fight and can continue picking this resource");
        return this.getAstronautHp() > 0;
    }

}
