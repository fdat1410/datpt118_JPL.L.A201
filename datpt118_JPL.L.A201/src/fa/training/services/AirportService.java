package fa.training.services;

import fa.training.entities.Airport;
import fa.training.utils.Validator;

import java.util.*;

public class AirportService {
    private List<Airport> airportList = new ArrayList<>();

    // Thêm sân bay mới vào danh sách, kiểm tra trùng ID
    public boolean addAirport(Airport airport) {
        for (Airport ap : airportList)
            if (ap.getId().equals(airport.getId())) return false; // ID unique
        airportList.add(airport);
        return true;
    }

    // Lấy danh sách sân bay
    public List<Airport> getAirportList() {
        return airportList;
    }

    // Lấy sân bay theo ID
    public Airport getAirportById(String id) {
        for (Airport ap : airportList)
            if (ap.getId().equals(id)) return ap;
        return null;
    }

    // Hiển thị tất cả sân bay (sắp xếp theo ID)
    public void displayAllAirports() {
        airportList.sort(Comparator.comparing(Airport::getId));
        for (Airport ap : airportList) {
            System.out.printf("AirportID: %s, Name: %s, Runway: %.2f, Fixedwing: %d/%d, Helicopter: %d/%d\n",
                    ap.getId(), ap.getName(), ap.getRunwaySize(),
                    ap.getFixedwingIDs().size(), ap.getMaxFixedwingParkingPlace(),
                    ap.getHelicopterIDs().size(), ap.getMaxRotatedwingParkingPlace());
        }
    }

    // Hàm nhập sân bay mới, lặp lại nếu nhập sai
    public void inputAndAddAirport(Scanner sc) {
        String id;
        while (true) {
            System.out.print("Enter Airport ID (format: AP00001): ");
            id = sc.nextLine();
            if (!Validator.validateID(id, "AP")) {
                System.out.println("Invalid Airport ID format! Must be 7 characters: AP + 5 digits (e.g. AP00001)");
            } else if (getAirportById(id) != null) {
                System.out.println("Airport ID already exists! Please enter a different ID.");
            } else {
                break;
            }
        }

        System.out.print("Enter Airport Name: ");
        String name = sc.nextLine();

        double runwaySize;
        while (true) {
            System.out.print("Enter Runway Size: ");
            if (sc.hasNextDouble()) {
                runwaySize = sc.nextDouble();
                if (runwaySize > 0) break;
                else System.out.println("Runway size must be positive!");
            } else {
                System.out.println("Invalid runway size!");
                sc.next();
            }
        }

        int maxFixedwingParkingPlace;
        while (true) {
            System.out.print("Enter Max Fixedwing Parking: ");
            if (sc.hasNextInt()) {
                maxFixedwingParkingPlace = sc.nextInt();
                if (maxFixedwingParkingPlace >= 0) break;
                else System.out.println("Parking must be >= 0");
            } else {
                System.out.println("Invalid parking number!");
                sc.next();
            }
        }

        int maxRotatedwingParkingPlace;
        while (true) {
            System.out.print("Enter Max Helicopter Parking: ");
            if (sc.hasNextInt()) {
                maxRotatedwingParkingPlace = sc.nextInt();
                if (maxRotatedwingParkingPlace >= 0) break;
                else System.out.println("Parking must be >= 0");
            } else {
                System.out.println("Invalid parking number!");
                sc.next();
            }
        }
        sc.nextLine(); // clear newline

        Airport newAirport = new Airport(id, name, runwaySize, maxFixedwingParkingPlace, maxRotatedwingParkingPlace);
        if (addAirport(newAirport)) {
            System.out.println("Airport added successfully!");
        } else {
            System.out.println("Failed to add airport!");
        }
    }

    // Hiển thị trạng thái chi tiết của 1 sân bay
    public void displayStatus(String id) {
        Airport ap = getAirportById(id);
        if (ap == null) {
            System.out.println("Airport not found!");
            return;
        }
        System.out.println("--- Airport Status ---");
        System.out.printf("ID: %s\nName: %s\nRunway: %.2f\n", ap.getId(), ap.getName(), ap.getRunwaySize());
        System.out.printf("Fixedwing slots: %d/%d\n", ap.getFixedwingIDs().size(), ap.getMaxFixedwingParkingPlace());
        System.out.printf("Helicopter slots: %d/%d\n", ap.getHelicopterIDs().size(), ap.getMaxRotatedwingParkingPlace());
        System.out.print("Fixedwing IDs: ");
        if (ap.getFixedwingIDs().isEmpty()) System.out.print("None");
        else System.out.print(String.join(", ", ap.getFixedwingIDs()));
        System.out.println();
        System.out.print("Helicopter IDs: ");
        if (ap.getHelicopterIDs().isEmpty()) System.out.print("None");
        else System.out.print(String.join(", ", ap.getHelicopterIDs()));
        System.out.println();
    }
}
