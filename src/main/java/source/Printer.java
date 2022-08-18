package source;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Printer {
    static boolean isToFile;
    static PrintWriter writer;
    static String path = "Simulation logs";
    public static void createFile() throws FileNotFoundException {
        if(isToFile){
            createFolder();
            writer = new PrintWriter(path+generateFileName());
            writer.println("Hello. Welcome to 'Mission to Mars' simulation! \n");
        }
    }
    public static void print(String informationToPrint){
        System.out.println(informationToPrint);
        if(isToFile) {
            writer.println(informationToPrint);
            writer.flush();
        }
    }

    public static void closeFile(){
        writer.close();
    }

    private static String generateFileName(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH,mm,ss");
        String actualDate = sdf.format(date);
        System.out.println(actualDate);
        return "/Simulation_results_"+actualDate+".txt";
    }

    private static void createFolder(){
        boolean success = (new File(path)).mkdirs();
        if (!success) System.out.println("Folder already exists");
        else System.out.println("Folder created");
    }
}
