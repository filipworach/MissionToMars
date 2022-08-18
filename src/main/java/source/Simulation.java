package source;

public class Simulation {
    public static String simulation(String astronautName, int mapaSize, int numberOfStartingResources, int missionLength, int fortune){
        Mapa mapa = new Mapa(astronautName, mapaSize, numberOfStartingResources, fortune); // metoda odpowiadająca za tworzenie mapy
        for(int i=1; i<=missionLength; i++) { // pętla iterująca się tak długo, ile dni symulacji ustawi gracz na początku
            Printer.print("   Day nr "+i); // informacja zwrotna dla gracza o tym, który dzień z kolei trwa symulacja
            Printer.print("Astronaut HP: "+Mapa.getAstronaut().getAstronautHp()); // informacja zwrotna dla gracza, o zdrowiu Astronauty
            Printer.print("Astronaut Oxygen: "+Mapa.getAstronaut().getAmountOfOxygen()); // informacja zwrotna dla gracza o tlenie Astronauty
            if(!mapa.astronautIsAlive()) return Results.showResults(0, i); //informacja zwrotna o tym, że Astronauta nie żyje
            if(!mapa.astronautMakeDecision()) return Results.showResults(1, i); //zwraca informację o tym, jaką decyzję podjął Astronauta
            if(mapa.astronautBuild()) return Results.showResults(11, i); //zwraca informację o tym, co aktualnie buduje Astronauta
            Printer.print(" ");
        }
        return Results.showResults(99, missionLength);
    }
}
