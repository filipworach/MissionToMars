package source;

import java.io.FileNotFoundException;

public class Main {

    static String astronautName;
    static int missionLength;
    static int mapaSize;
    static int numberOfStartingResources;
    static int fortune;
    static int numberOfSuccessfullyMissions = 0;
    static int averageCompleteTime = 0;

    public static void main(String[] args) throws FileNotFoundException {
        for (int i = 0; i<5; i++){
            String simulationResult;
            Parameters.askForParameters();
            simulationResult = Simulation.simulation(astronautName, mapaSize, numberOfStartingResources, missionLength, fortune);
            Printer.print(simulationResult);
            //if (Printer.isToFile) Printer.closeFile();
        }
       summaryResults();
    }

    public static void summaryResults(){
        System.out.println("\n For parameters: ");
        System.out.println("   Mission length - "+missionLength);
        System.out.println("   Map size - "+((mapaSize-1)/10));
        System.out.println("   Number of starting resources - "+numberOfStartingResources);
        System.out.println("   Fortune - "+fortune);

        System.out.println("Number of completed missions: "+numberOfSuccessfullyMissions);
        if(numberOfSuccessfullyMissions!=0)averageCompleteTime = averageCompleteTime/numberOfSuccessfullyMissions;
        System.out.println("Average complete time: "+averageCompleteTime);
        Printer.closeFile();
    }
}
