package ex9;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    
    List<Driver> drivers;
    List<RallyRaceResult> races;
    static int totalDrivers;
    static int totalRaces;

    private ChampionshipManager(){
        this.drivers = new ArrayList<>();
        this.races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance(){
        if(instance == null){
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver){
        totalDrivers += 1;
        drivers.add(driver);
    }

    public void addRaceResult(RallyRaceResult result){
        totalRaces += 1;
        races.add(result);
    }

    public List<Driver> getDriverStandings(){
        List<Driver> sortedDrivers = new ArrayList<>(drivers);
        sortedDrivers.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
        return sortedDrivers;
    }

    public static Driver getLeadingDriver(){
        ChampionshipManager championshipManager = ChampionshipManager.getInstance(); 
        List<Driver> sortedDrivers = championshipManager.getDriverStandings();
        return sortedDrivers.get(0);
    }

    public static int getTotalChampionshipPoints(){
        ChampionshipManager championshipManager = ChampionshipManager.getInstance(); 
        List<Driver> sortedDrivers = championshipManager.getDriverStandings();
        int totalChampionshipPoints=0;
        for (Driver driver : sortedDrivers) {
            totalChampionshipPoints += driver.getPoints();
        } 
        return totalChampionshipPoints;
    }

}
