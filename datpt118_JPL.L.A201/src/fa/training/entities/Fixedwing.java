package fa.training.entities;

public class Fixedwing extends Airplane {
    private String planeType;
    private double minNeededRunway;

    public Fixedwing() {
    }

    public Fixedwing(String id, String model, String planeType, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight, double minNeededRunway) {
        super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
        this.planeType = planeType;
        this.minNeededRunway = minNeededRunway;
    }

    @Override
    public String fly() {
        return "fixed wing";
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

    @Override
    public String toString() {
        return "Fixedwing{" +
                "planeType='" + planeType + '\'' +
                ", minNeededRunway=" + minNeededRunway +
                ", id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", cruiseSpeed=" + cruiseSpeed +
                ", emptyWeight=" + emptyWeight +
                ", maxTakeoffWeight=" + maxTakeoffWeight +
                ", airportId='" + airportId + '\'' +
                '}';
    }
}
