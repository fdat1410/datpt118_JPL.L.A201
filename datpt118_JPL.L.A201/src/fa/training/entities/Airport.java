package fa.training.entities;

import java.util.*;

public class Airport {
    private String id;
    private String name;
    private double runwaySize;
    private int maxFixedwingParking;
    private int maxHelicopterParking;
    private List<String> fixedwingIDs;
    private List<String> helicopterIDs;

    public Airport() {
        fixedwingIDs = new ArrayList<>();
        helicopterIDs = new ArrayList<>();
    }

    public Airport(String id, String name, double runwaySize, int maxFixedwingParking, int maxHelicopterParking) {
        this.id = id;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedwingParking = maxFixedwingParking;
        this.maxHelicopterParking = maxHelicopterParking;
        this.fixedwingIDs = new ArrayList<>();
        this.helicopterIDs = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRunwaySize() {
        return runwaySize;
    }

    public void setRunwaySize(double runwaySize) {
        this.runwaySize = runwaySize;
    }

    public int getMaxFixedwingParking() {
        return maxFixedwingParking;
    }

    public void setMaxFixedwingParking(int maxFixedwingParking) {
        this.maxFixedwingParking = maxFixedwingParking;
    }

    public int getMaxHelicopterParking() {
        return maxHelicopterParking;
    }

    public void setMaxHelicopterParking(int maxHelicopterParking) {
        this.maxHelicopterParking = maxHelicopterParking;
    }

    public List<String> getFixedwingIDs() {
        return fixedwingIDs;
    }

    public void setFixedwingIDs(List<String> fixedwingIDs) {
        this.fixedwingIDs = fixedwingIDs;
    }

    public List<String> getHelicopterIDs() {
        return helicopterIDs;
    }

    public void setHelicopterIDs(List<String> helicopterIDs) {
        this.helicopterIDs = helicopterIDs;
    }
}
