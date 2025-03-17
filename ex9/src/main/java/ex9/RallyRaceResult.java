package ex9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RallyRaceResult implements RaceResult{

    String raceName;
    String location;
    Map<Driver, Integer> results = new LinkedHashMap();

    public RallyRaceResult(String raceName, String location){
        this.raceName = raceName;
        this.location = location;
    }

    public String getRaceName(){
        return raceName;
    }

    public String getLocation(){
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        driver.addPoints(points);
        results.put(driver, points);
        List<Map.Entry<Driver, Integer>> list = new ArrayList<>(results.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        Map<Driver, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Driver, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        results = sortedMap;
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return results.get(driver);
    }

    @Override
    public List<Driver> getResults() {
        return new ArrayList<>(results.keySet());
    }
    
}
