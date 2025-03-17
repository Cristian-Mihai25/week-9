package ex9;

public class GravelCar extends RallyCar{

    double suspensionTravel;

    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
        
    }

    public double getSuspensionTravel(){
        return suspensionTravel;
    }
    public double calculatePerformance(){
        return horsepower * (1/suspensionTravel);
    }
}
