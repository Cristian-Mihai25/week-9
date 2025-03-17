package ex9;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
       

        AsphaltCar sebAsphaltCar = new AsphaltCar("Hyundai", "i20 Coupe WRC", 600, 1.3);
        Driver sebastienDriver = new Driver("Sébastien Ogier", "France", sebAsphaltCar);

        GravelCar kallGravelCar = new GravelCar("Honda", "NSX GT3", 400, 1.2);
        Driver kalleDriver = new Driver("Kalle Rovanperä", "Finland", kallGravelCar);

        AsphaltCar ottAsphaltCar = new AsphaltCar("Chevrolet", "Camaro GT4.R", 600, 1.5);
        Driver ottDriver = new Driver("Ott Tänak", "Estonia", ottAsphaltCar);

        GravelCar thierryGravelCar = new GravelCar("Toyota", "Supra GT4", 550, 1.2);
        Driver thierryDriver = new Driver("Thierry Neuville", "Belgium", thierryGravelCar);

        RallyRaceResult firstRaceResult = new RallyRaceResult("Rally Finland", "Jyväskylä");
        firstRaceResult.recordResult(sebastienDriver, 1, 25);
        firstRaceResult.recordResult(ottDriver, 2, 18);
        firstRaceResult.recordResult(kalleDriver, 3, 15);
        firstRaceResult.recordResult(thierryDriver, 4, 12);

        RallyRaceResult secondRaceResult = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        secondRaceResult.recordResult(sebastienDriver, 3, 15);
        secondRaceResult.recordResult(ottDriver, 4, 12);
        secondRaceResult.recordResult(kalleDriver, 1, 25);
        secondRaceResult.recordResult(thierryDriver, 2, 18);

        ChampionshipManager championshipManager = ChampionshipManager.getInstance();
        championshipManager.registerDriver(sebastienDriver);
        championshipManager.registerDriver(thierryDriver);
        championshipManager.registerDriver(kalleDriver);
        championshipManager.registerDriver(ottDriver);

        championshipManager.addRaceResult(firstRaceResult);
        championshipManager.addRaceResult(secondRaceResult);

        List<Driver> driversStanding = championshipManager.getDriverStandings();
        for (Driver driver : driversStanding) {
            
            System.out.println(String.format("%s, (%s): %d", driver.getName(), driver.getCountry(), driver.getPoints()));
        }

        Driver leadingDriver = championshipManager.getLeadingDriver();
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(String.format("%s with %d points",leadingDriver.getName(), leadingDriver.getPoints()));

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println(String.format("Total Drivers: %d", championshipManager.totalDrivers));
        System.out.println(String.format("Total Races: %d", ChampionshipStatistics.getTotalRacesHeld()));
        System.out.println(String.format("Average Points Per Driver: %.2f", ChampionshipStatistics.calculateAveragePointsPerDriver(championshipManager.getDriverStandings())));
        System.out.println(String.format("Most Successful Country: %s", ChampionshipStatistics.findMostSuccessfulCountry(championshipManager.getDriverStandings())));
        System.out.println(String.format("Total Championship Points: %d", ChampionshipManager.getTotalChampionshipPoints()));

        System.out.println("\n===== RACE RESULTS =====");
        List<Driver> firstRaceResultsDrivers = firstRaceResult.getResults();
        System.out.println(String.format("Race: %s (%s)", firstRaceResult.getRaceName(), firstRaceResult.getLocation()));
        int i = 1;
        for (Driver driver : firstRaceResultsDrivers) {
            
            System.out.println(String.format("    Position %d: %s - %d points",i, driver.getName(), firstRaceResult.getDriverPoints(driver)));
            i=i+1;
        }

        List<Driver> secondRaceResultsDrivers = secondRaceResult.getResults();
        System.out.println(String.format("\nRace: %s (%s)", secondRaceResult.getRaceName(), secondRaceResult.getLocation()));
        i=1;
        for (Driver driver : secondRaceResultsDrivers) {
            System.out.println(String.format("    Position %d: %s - %d points",i, driver.getName(), secondRaceResult.getDriverPoints(driver)));
            i = i+1;
        }

        System.out.println("\n=====  CAR PERFORMANCE RATINGS =====");
        double graverCarPerformance = (kallGravelCar.calculatePerformance() + thierryGravelCar.calculatePerformance())/2;
        double asphaltCarPerformance = (sebAsphaltCar.calculatePerformance() + ottAsphaltCar.calculatePerformance())/2;
        System.out.println(String.format("Graver Car Performance: %.1f",graverCarPerformance));
        System.out.println(String.format("Asphalt Car Performance: %.1f",asphaltCarPerformance));
    }
}
