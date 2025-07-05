package fa.training.services;

import fa.training.entities.Airport;
import fa.training.entities.Fixedwing;

import java.util.*;

public class FixedwingService {
    private List<Fixedwing> fixedwingList = new ArrayList<>();

    // Lấy danh sách Fixedwing
    public List<Fixedwing> getFixedwingList() {
        return fixedwingList;
    }

    // Thêm Fixedwing vào danh sách
    public void addFixedwing(Fixedwing fixedwing) {
        fixedwingList.add(fixedwing);
    }

    // Thêm Fixedwing chưa có sân bay vào airport, kiểm tra điều kiện
    public void addFixedwingToAirport(Scanner sc, AirportService airportService) {
        List<Fixedwing> unparked = new ArrayList<>();
        for (Fixedwing f : fixedwingList) {
            if (f.getAirportId() == null) unparked.add(f);
        }

        if (unparked.isEmpty()) {
            System.out.println("No fixedwing available to assign!");
            return;
        }

        System.out.println("Available fixedwing:");
        for (int i = 0; i < unparked.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, unparked.get(i));
        }

        System.out.print("Select fixedwing to assign (index): ");
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

        Fixedwing selected = unparked.get(idx);

        System.out.print("Enter Airport ID: ");
        String airportId = sc.nextLine();
        Airport airport = airportService.getAirportById(airportId);
        if (airport == null) {
            System.out.println("Airport not found!");
            return;
        }

        if (airport.getFixedwingIDs().size() >= airport.getMaxFixedwingParkingPlace()) {
            System.out.println("No parking slot for fixedwing in this airport!");
            return;
        }

        if (selected.getMinNeededRunway() > airport.getRunwaySize()) {
            System.out.println("Fixedwing's min needed runway exceeds airport's runway size!");
            return;
        }

        // OK: add
        selected.setAirportId(airportId);
        airport.getFixedwingIDs().add(selected.getId());
        System.out.println("Fixedwing assigned to airport successfully!");
    }

    // Thay đổi loại máy bay và minNeededRunway của Fixedwing
    public void changeTypeOrMinRunway(Scanner sc) {
        if (fixedwingList.isEmpty()) {
            System.out.println("No fixedwing available!");
            return;
        }

        System.out.println("Fixedwing list:");
        for (int i = 0; i < fixedwingList.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, fixedwingList.get(i));
        }

        System.out.print("Select fixedwing to update (index): ");
        int idx = -1;
        try {
            idx = Integer.parseInt(sc.nextLine()) - 1;
        } catch (Exception e) {
            idx = -1;
        }

        if (idx < 0 || idx >= fixedwingList.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Fixedwing fw = fixedwingList.get(idx);

        System.out.print("Enter new plane type (CAG/LGR/PRV): ");
        String type = sc.nextLine();
        if (!type.equals("CAG") && !type.equals("LGR") && !type.equals("PRV")) {
            System.out.println("Invalid plane type!");
            return;
        }
        fw.setPlaneType(type);

        System.out.print("Enter new min needed runway size: ");
        double minRunway;
        try {
            minRunway = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid number!");
            return;
        }
        fw.setMinNeededRunway(minRunway);
        System.out.println("Update success!");
    }

    // Hiển thị tất cả Fixedwing với thông tin airport đang đậu
    public void displayAllFixedwingWithAirport(AirportService airportService) {
        System.out.println("List of Fixedwing airplanes:");
        for (Fixedwing f : fixedwingList) {
            String airportName = "None";
            if (f.getAirportId() != null) {
                Airport ap = airportService.getAirportById(f.getAirportId());
                if (ap != null) airportName = ap.getName();
            }
            System.out.printf("%s - Parking Airport: %s (%s)\n", f, f.getAirportId(), airportName);
        }
    }
}
