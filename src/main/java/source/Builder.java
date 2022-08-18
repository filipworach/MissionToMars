package source;

public class Builder {
    private Base base = new Base();
    private Spaceship spaceship = new Spaceship();
    public void placeBuildings(int mapaSize){
        base.placeBase(mapaSize);
        spaceship.placeSpaceship();
    }

    public Base getBase(){
        return base;
    }

    public Spaceship getSpaceship(){
        return spaceship;
    }
    /* metoda odpowiedzialna za budowanie bazy, a gdy ta zostanie ukończona, to buduje statek, by wrócić do na Ziemię */
    public void build(){
        int progressScaling = (Main.mapaSize-1)/2;
        if(Mapa.getAstronaut().getAmountOfIron()>0) {
            if (!base.isFinished()) {
                base.setProgress(base.getProgress() + (Mapa.getAstronaut().getAmountOfIron() / progressScaling));
                Printer.print("Base build progress: "+base.getProgress());
            } else {
                spaceship.setProgress(spaceship.getProgress() + (Mapa.getAstronaut().getAmountOfIron() / progressScaling));
                Printer.print("Spaceship repair progress: "+spaceship.getProgress());
            }
            Mapa.getAstronaut().setAmountOfIron(0);
        }
    }
}
