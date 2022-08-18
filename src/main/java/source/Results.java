package source;

public class Results {
    public static String showResults(int resultIndex, int numberOfDay){
        String result = " ";

        switch (resultIndex){
            case 0 -> result = "In "+numberOfDay+ " day Astronaut died during his mission :(";

            case 1 -> result = Mapa.getAstronaut().getAstronautName()+" died during heroic fight with Marsian in "+numberOfDay+" day of mission";

            case 11 -> {
                result = "Well done "+Mapa.getAstronaut().getAstronautName()+", You have survived. You repaired spaceship in "+numberOfDay+" days. You are on your way to the Earth.";
                Main.averageCompleteTime = Main.averageCompleteTime+numberOfDay;
                Main.numberOfSuccessfullyMissions++;
            }

            case 99 -> result = numberOfDay+" days are not enough for "+Mapa.getAstronaut().getAstronautName()+" to finish his mission :(";
        }

        return result;
    }
}
