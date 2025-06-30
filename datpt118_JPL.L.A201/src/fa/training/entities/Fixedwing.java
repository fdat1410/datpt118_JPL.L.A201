package fa.training.entities;

public class Fixedwing extends Airplane {
    private String planeType;
    private double minNeededRunway;

    public Fixedwing() {
    }

    public Fixedwing(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight,
                     String planeType, double minNeededRunway) {
        super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
        this.planeType = planeType;
        this.minNeededRunway = minNeededRunway;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public double getMinNeededRunway() {
        return minNeededRunway;
    }

    public void setMinNeededRunway(double minNeededRunway) {
        this.minNeededRunway = minNeededRunway;
    }
}
