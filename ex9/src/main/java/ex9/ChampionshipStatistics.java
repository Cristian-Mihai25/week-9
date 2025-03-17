package ex9;

import java.util.List;

public class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(List<Driver> drivers){
        double result=0;
        for (Driver driver : drivers) {
            result += driver.getPoints();
        }
        result = result/drivers.size();
        return result;
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers){
        String mostSuccessfulCountry="";
        int largestPoints=0;
        for (Driver driver : drivers) {
            if(driver.getPoints()>=largestPoints){
                largestPoints = driver.getPoints();
                mostSuccessfulCountry = driver.getCountry();
            }
        }
        return mostSuccessfulCountry;
    }

    public static int getTotalRacesHeld(){
        return ChampionshipManager.totalRaces;
    }

}
