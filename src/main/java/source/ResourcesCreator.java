package source;

import java.util.*;


public class  ResourcesCreator {
    private static List<Location> notEmptyLocations = new ArrayList<>(); //lista przechowująca wolne lokalizacje
    public Location generateLocation(int mapaSize){ //metoda odpowiedzialna za wygenerowanie losowej lokalizacji dla zasobów
        Location resourceLocation = new Location();
        Random r = new Random();

        do {
            resourceLocation.setCoordinateX(r.nextInt(mapaSize-1));
            resourceLocation.setCoordinateY(r.nextInt(mapaSize-1));
        }while(((resourceLocation.getCoordinateX()==mapaSize/2) && (resourceLocation.getCoordinateY()==mapaSize/2))||((resourceLocation.getCoordinateX()==0) && (resourceLocation.getCoordinateY()==0)));

        return resourceLocation;
    }


    public static List<Resources> createResources(int mapaSize) { //metoda odpowiedzialna za tworzenie surowców
        List<Resources>resources = new ArrayList<>();
        ResourcesCreator rC = new ResourcesCreator();
        String nameOfResource = "Iron";

        for(int k = 0; k<3; k++) {
            switch (k) {
                case 1 -> nameOfResource = "Water";
                case 2 -> nameOfResource = "Oxygen";
            }
            for (int i = (mapaSize * mapaSize) / 4; i > 0; i--) {
                Location location;
                do {
                    location = rC.generateLocation(mapaSize);
                } while (isNotEmpty(location));

                Resources resource = new Resources();
                if(k==0){
                    resource.getMarsjan().setHp(100); //jeśli astronauta zbiera żelazo, to musi stoczyć walkę z Marsjankiem
                    resource.getMarsjan().setDamage(50);
                }
                resource.setName(nameOfResource);
                resource.setLocation(location);
                resources.add(resource);
                //System.out.println("Nr "+ i + "   Typ surowca: " + resources.get(i).getName()+"    Lokalizacja: ["+resources.get(i).getLocation().getCoordinateX()+" , "+resources.get(i).getLocation().getCoordinateY()+"]");
            }
        }
        Printer.print("Resource placed \n");
        return resources;
    }

    public static boolean isNotEmpty(Location location) { //metoda sprawdzająca, czy dana lokalizacja nie jest już zajęta przez surowiec
        int i;
        for ( i = 0; i<notEmptyLocations.size(); i++) {
            if(notEmptyLocations.get(i)==location) return true;
        }
        notEmptyLocations.add(location);
        return false;
    }
}
