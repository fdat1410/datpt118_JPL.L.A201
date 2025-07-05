package fa.training.services;

import fa.training.entities.Airport;
import fa.training.entities.Helicopter;

import java.util.*;

public class HelicopterService {
    private List<Helicopter> helicopterList = new ArrayList<>();

    // Lấy danh sách Helicopter
    public List<Helicopter> getHelicopterList() {
        return helicopterList;
    }

    // Thêm Helicopter vào danh sách
    public void addHelicopter(Helicopter helicopter) {
        helicopterList.add(helicopter);
    }

    // Thêm Helicopter chưa có airport vào airport (kiểm tra đầy đủ)
    public void addHelicopterToAirport(Scanner sc, AirportService airportService) {
        List<Helicopter> unparked = new ArrayList<>();
        for (Helicopter h : helicopterList) {
            if (h.getAirportId() == null) unparked.add(h);
        }

        if (unparked.isEmpty()) {
            System.out.println("No helicopter available to assign!");
            return;
        }

        System.out.println("Available helicopters:");
        for (int i = 0; i < unparked.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, unparked.get(i));
        }

        System.out.print("Select helicopter to assign (index): ");
        int idx = -1;
        try {
            idx = Integer.parseInt(sc.nextLine()) - 1;
        } catch (Exception e) {
            idx = -1;
        }

        if (idx < 0 || idx >= unparked.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Helicopter selected = unparked.get(idx);

        System.out.print("Enter Airport ID: ");
        String airportId = sc.nextLine();
        Airport airport = airportService.getAirportById(airportId);
        if (airport == null) {
            System.out.println("Airport not found!");
            return;
        }

        if (airport.getHelicopterIDs().size() >= airport.getMaxRotatedwingParkingPlace()) {
            System.out.println("No parking slot for helicopter in this airport!");
            return;
        }

        if (selected.getMaxTakeoffWeight() > 1.5 * selected.getEmptyWeight()) {
            System.out.println("Helicopter's max takeoff weight exceeds allowed limit!");
            return;
        }

        // OK: add
        selected.setAirportId(airportId);
        airport.getHelicopterIDs().add(selected.getId());
        System.out.println("Helicopter assigned to airport successfully!");
    }

    // Xóa Helicopter khỏi airport
    public void removeHelicopterFromAirport(Scanner sc, AirportService airportService) {
        List<Helicopter> parked = new ArrayList<>();
        for (Helicopter h : helicopterList) {
            if (h.getAirportId() != null) parked.add(h);
        }

        if (parked.isEmpty()) {
            System.out.println("No helicopter currently in any airport!");
            return;
        }

        System.out.println("Helicopters in airports:");
        for (int i = 0; i < parked.size(); i++) {
            System.out.printf("%d. %s (in %s)\n", i + 1, parked.get(i), parked.get(i).getAirportId());
        }

        System.out.print("Select helicopter to remove (index): ");
        int idx = -1;
        try {
            idx = Integer.parseInt(sc.nextLine()) - 1;
        } catch (Exception e) {
            idx = -1;
        }

        if (idx < 0 || idx >= parked.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Helicopter selected = parked.get(idx);
        Airport airport = airportService.getAirportById(selected.getAirportId());
        if (airport != null) {
            airport.getHelicopterIDs().remove(selected.getId());
        }
        selected.setAirportId(null);
        System.out.println("Helicopter removed from airport!");
    }

    // Hiển thị tất cả Helicopter với thông tin airport đang đậu
    public void displayAllHelicopterWithAirport(AirportService airportService) {
        System.out.println("List of Helicopters:");
        for (Helicopter h : helicopterList) {
            String airportName = "None";
            if (h.getAirportId() != null) {
                Airport ap = airportService.getAirportById(h.getAirportId());
                if (ap != null) airportName = ap.getName();
            }
            System.out.printf("%s - Parking Airport: %s (%s)\n", h, h.getAirportId(), airportName);
        }
    }
}
