package fa.training.services;

import fa.training.entities.Airport;

import java.util.*;

public class AirportService {
    private List<Airport> airportList = new ArrayList<>();

    public boolean addAirport(Airport airport) {
        for (Airport ap : airportList)
            if (ap.getId().equals(airport.getId())) return false; // ID unique
        airportList.add(airport);
        return true;
    }

    public List<Airport> getAirportList() {
        return airportList;
    }

    public Airport getAirportById(String id) {
        for (Airport ap : airportList)
            if (ap.getId().equals(id)) return ap;
        return null;
    }

    public void displayAllAirports() {
        airportList.sort(Comparator.comparing(Airport::getId));
        for (Airport ap : airportList) {
            System.out.printf("AirportID: %s, Name: %s, Runway: %.2f\n", ap.getId(), ap.getName(), ap.getRunwaySize());
        }
    }

}
