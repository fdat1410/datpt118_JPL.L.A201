package fa.training.entities;

public class Helicopter extends Airplane {
    private double range;

    public Helicopter() {
    }

    public Helicopter(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight, double range) {
        super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
        this.range = range;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
}
