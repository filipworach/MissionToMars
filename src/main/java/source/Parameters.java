package source;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parameters {
    static void askForParameters() throws FileNotFoundException {
        System.out.println("Hello. Welcome to 'Mission to Mars' simulation");
        Parameters parameters = new Parameters();
        Printer.isToFile = true;
        Printer.createFile();
        Main.astronautName = "Astronaut";
        Main.mapaSize = 5;
        Main.missionLength = 999;
        Main.numberOfStartingResources = 300;
        Main.fortune = 3;


//        parameters.isToFile();
//        Main.astronautName = parameters.setAstronautName();
//        do {
//            Main.mapaSize = parameters.userSetParameters("map");
//            if(Main.mapaSize>0&&Main.mapaSize<11)break;
//            else Printer.print("You entered wrong amount of parameter, please try one more time");
//        }while(true);
//        Main.missionLength = parameters.userSetParameters("missionLength");
//        Main.numberOfStartingResources = parameters.userSetParameters("startingResources");
//        Main.fortune = parameters.userSetParameters("fortune");

        Main.mapaSize = (Main.mapaSize*10)+1;
    }

    private String setAstronautName(){
        Printer.print("Please name the Astronaut");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Printer.print(name+"\n");
        return name;
    }
    private int userSetParameters(String parameterAskingFor) { //metoda używana na początku symulacji do ustawienia parametrów
        Scanner scanner = new Scanner(System.in);
        int value = -1;
        do {
            switch (parameterAskingFor) {
                case "map" -> {
                    Printer.print("Please set the map size between 1 and 10:");
                }
                case "missionLength" -> {
                    Printer.print("Please set the mission length (in days):");
                }
                case "startingResources" -> {
                    Printer.print("Now set how many resources Astronaut will have in his spaceship:");
                }
                case "fortune" -> {
                    Printer.print("At the end please set how many fortune Astronaut will have during the fight with Marsians:");
                }
            }
            value = scanner.nextInt();
            Printer.print(String.valueOf(value));
        }while (value < 1);
        Printer.print("");
        return value;
    }

    private void isToFile() throws FileNotFoundException {
        String decision;
        do {
            System.out.println("Do You want to save logs to file? (y/n)");
            Scanner scanner = new Scanner(System.in);
            decision = scanner.nextLine();
        }while (!(decision.equals("y")||decision.equals("n")));
        Printer.isToFile = decision.equals("y");
        if(Printer.isToFile){Printer.createFile();}

        if(Printer.isToFile)System.out.println("Saving to file");
    }
}
