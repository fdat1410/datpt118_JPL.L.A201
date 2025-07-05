package fa.training.entities;

import java.util.*;

public class Airport {
    private String id;
    private String name;
    private double runwaySize;
    private int maxFixedwingParkingPlace;
    private int maxRotatedwingParkingPlace;
    private List<String> fixedwingIDs;
    private List<String> helicopterIDs;

    public Airport() {
        fixedwingIDs = new ArrayList<>();
        helicopterIDs = new ArrayList<>();
    }

    public Airport(String id, String name, double runwaySize, int maxFixedwingParkingPlace, int maxRotatedwingParkingPlace) {
        this.id = id;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedwingParkingPlace = maxFixedwingParkingPlace;
        this.maxRotatedwingParkingPlace = maxRotatedwingParkingPlace;
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

    public int getMaxFixedwingParkingPlace() {
        return maxFixedwingParkingPlace;
    }

    public void setMaxFixedwingParkingPlace(int maxFixedwingParkingPlace) {
        this.maxFixedwingParkingPlace = maxFixedwingParkingPlace;
    }

    public int getMaxRotatedwingParkingPlace() {
        return maxRotatedwingParkingPlace;
    }

    public void setMaxRotatedwingParkingPlace(int maxRotatedwingParkingPlace) {
        this.maxRotatedwingParkingPlace = maxRotatedwingParkingPlace;
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
