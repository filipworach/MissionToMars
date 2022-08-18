package source;

import java.util.List;
import java.util.Map;

import static java.lang.Math.*;

public class Mapa {
    private static int mapaSize;
    private static Astronaut astronaut = new Astronaut();
    private static List<Resources> resources;
    Builder builder = new Builder();
    /* metoda uruchamiana na samym początku symulacji, aby nadać imię Astronaucie oraz ustawić wartości początkowe poszczególnych
    parametrów */
    public Mapa(String astronautName, int mapaSize,int numberOfStartingResources, int fortune) {
        Mapa.astronaut.setAstronautName(astronautName);
        Mapa.mapaSize =mapaSize;
        resources = ResourcesCreator.createResources(mapaSize);
        builder.placeBuildings(mapaSize);
        astronaut.setAstronautFortune(fortune);
        astronaut.setAmountOfIron(numberOfStartingResources);
    }


    // metoda sprawdzająca, czy Astronauta nie zginął
    public boolean astronautIsAlive() {
        boolean isAlive;
        isAlive = astronaut.getAstronautHp() > 0;
        return isAlive;
    }
    // metoda odpowiedzialna za poruszanie się Astronauty
    public void astronautMove(){
        int moveToX = astronaut.getAstronautLocation().getCoordinateX(), moveToY = astronaut.getAstronautLocation().getCoordinateY();
        astronaut.moveAstronaut(moveToX, moveToY);
    }
    // metoda odpowiedzialna za podjęcie decyzji, czego teraz najbardziej potrzebuje Astronauta
    public boolean astronautMakeDecision(){
        boolean result;
        // jeśli życie Astronauty znajduje się na poziomie 50 lub niższym, to Astronauta idzie po wodę, aby ją sobie odnowić
        if (astronaut.getAstronautHp()<=(50/astronaut.getAstronautFortune())){
            Printer.print(astronaut.getAstronautName()+" has not enough HP to fight with Marsians, so he chose to go for the water");
            result = astronautGoFor("Water");
        }
        else{ //w przeciwnym wypadku idzie po żelazo
            Printer.print(astronaut.getAstronautName()+" chose to go for the iron");
            result = astronautGoFor("Iron");
        }
        return result;
    }

    public boolean astronautGoFor(String targetResource){
        Location locationOfClosestResource = findTheClosestResource(targetResource);
        if (astronaut.getAmountOfOxygen()<(countDistance(astronaut.getAstronautLocation(), locationOfClosestResource))*10){
            locationOfClosestResource = findTheClosestResource("Oxygen"); //jeśli Astronaucie nie wystarczy tlenu, aby dojść po zasób, to idzie po tlen
            targetResource = "Oxygen";
            Printer.print(astronaut.getAstronautName()+" has not enough oxygen, so he has to restore it");
        }
        //metoda odpowiedzialna za "zużycie" odpowiedniej ilości tlenu, aby Astronauta dostał się do celu
        astronaut.setAmountOfOxygen(astronaut.getAmountOfOxygen()-((countDistance(astronaut.getAstronautLocation(), locationOfClosestResource))*10));
        astronaut.moveAstronaut(locationOfClosestResource);
        if(targetResource.equals("Iron")){
            if(!astronaut.fight()) return false;
        }
        takeResources(locationOfClosestResource);
        return true;
    }
    // metoda odpowiedzialna za znalezienie najbliższego surowca danego typu
    public Location findTheClosestResource(String targetResource){
        Location locationOfClosestResource = builder.getBase().getLocation();
        int currentDistance, shortestDistance=99999999;
        if(builder.getBase().isFinished()&&targetResource.equals("Oxygen")){
            shortestDistance=countDistance(builder.getBase().getLocation(), astronaut.getAstronautLocation());
        }
        for (int i=0; i<resources.size(); i++) {
            if((resources.get(i).getName().equals(targetResource))){
                currentDistance = countDistance(resources.get(i).getLocation(),astronaut.getAstronautLocation());
                if(currentDistance<shortestDistance){
                    shortestDistance = currentDistance;
                    locationOfClosestResource = resources.get(i).getLocation();
                }
            }
        }
        return locationOfClosestResource;
    }
    // metoda odpowiedzialna za zbieranie zasobów
    public void takeResources(Location locationOfCollectingResources) {
        if ((locationOfCollectingResources == builder.getBase().getLocation() && builder.getBase().isFinished())) {
            builder.getBase().refillAstronautOxygen();
            Printer.print(astronaut.getAstronautName()+" restored oxygen in base");
        } else {
            int i;
            for (i = 0; i < resources.size(); i++) {
                if (resources.get(i).getLocation() == locationOfCollectingResources) {
                    String toCollect = resources.get(i).getName();
                    switch (toCollect) {
                        case "Iron" -> {
                            astronaut.setAmountOfIron(astronaut.getAmountOfIron() + 50);
                        }
                        case "Water" -> astronaut.setAstronautHp(astronaut.getAstronautHp() + 50);
                        case "Oxygen" -> astronaut.setAmountOfOxygen(astronaut.getAmountOfOxygen() + 100);
                    }
                    Printer.print( astronaut.getAstronautName()+" successfully picked "+toCollect);
                    resources.remove(i);
                }
            }

        }
    }

    public int countDistance(Location location1, Location location2) { //metoda licząca odległość do wskazanego miejsca
        int distance;
        distance = (abs(location2.getCoordinateX()-location1.getCoordinateX())+abs(location2.getCoordinateY()-location1.getCoordinateY()));
        //System.out.println("Dystans do surowca: "+distance);
        return distance;
    }

    public boolean astronautBuild(){
        builder.build();
        if (builder.getSpaceship().isFinished()) return true;
        return false;
    }
    public static Astronaut getAstronaut(){
        return astronaut;
    }
}
