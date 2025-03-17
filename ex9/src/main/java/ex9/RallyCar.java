package ex9;

public abstract class RallyCar {
    String make;
    String model;
    int horsepower;

    public RallyCar(String make, String model, int horsepower){
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }
    public int getHorsepower(){
        return horsepower;
    }
    public abstract double calculatePerformance();
    
    
}
