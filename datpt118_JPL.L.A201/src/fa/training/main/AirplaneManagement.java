package fa.training.main;

import fa.training.entities.*;
import fa.training.services.*;
import fa.training.utils.Validator;

import java.util.*;

public class AirplaneManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AirportService airportService = new AirportService();
        FixedwingService fixedwingService = new FixedwingService();
        HelicopterService helicopterService = new HelicopterService();

        // dữ liệu mẫu
        Airport airport1 = new Airport("AP00001", "Noi Bai", 3500, 3, 2);
        Airport airport2 = new Airport("AP00002", "Tan Son Nhat", 3000, 2, 2);
        Airport airport3 = new Airport("AP00003", "Da Nang", 3200, 2, 1);
        Airport airport4 = new Airport("AP00004", "Cam Ranh", 2500, 1, 2);

        airportService.addAirport(airport1);
        airportService.addAirport(airport2);
        airportService.addAirport(airport3);
        airportService.addAirport(airport4);

        Fixedwing fw1 = new Fixedwing("FW00001", "Boeing 747", "CAG", 900, 183500, 333400, 3000);
        Fixedwing fw2 = new Fixedwing("FW00002", "Airbus A350", "LGR", 910, 134000, 280000, 3000);
        Fixedwing fw3 = new Fixedwing("FW00003", "Cessna Citation X", "PRV", 972, 9900, 16300, 1400);

        fw1.setAirportId("AP00001");
        fw2.setAirportId("AP00001");
        fw3.setAirportId("AP00002");

        airport1.getFixedwingIDs().add(fw1.getId());
        airport1.getFixedwingIDs().add(fw2.getId());
        airport2.getFixedwingIDs().add(fw3.getId());

        fixedwingService.getFixedwingList().add(fw1);
        fixedwingService.getFixedwingList().add(fw2);
        fixedwingService.getFixedwingList().add(fw3);

        Helicopter hc1 = new Helicopter("RW00001", "Mi-8", 260, 6800, 12000, 600);
        Helicopter hc2 = new Helicopter("RW00002", "Bell 206", 220, 1450, 1950, 690);

        hc1.setAirportId("AP00003");
        hc2.setAirportId("AP00004");

        airport3.getHelicopterIDs().add(hc1.getId());
        airport4.getHelicopterIDs().add(hc2.getId());

        helicopterService.getHelicopterList().add(hc1);
        helicopterService.getHelicopterList().add(hc2);

        while (true) {
            System.out.println("\n======= AIRPLANE MANAGEMENT =======");
            System.out.println("1. Create new airport");
            System.out.println("2. Add fixedwing to airport");
            System.out.println("3. Remove helicopter from airport");
            System.out.println("4. Add helicopter to airport");
            System.out.println("5. Change fixedwing type & min runway");
            System.out.println("6. Airport management (view list/status)");
            System.out.println("7. Fixedwing management (list info)");
            System.out.println("8. Helicopter management (list info)");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    // Tạo mới sân bay
                    airportService.inputAndAddAirport(sc);
                    break;
                case "2":
                    // Thêm fixedwing vào sân bay
                    fixedwingService.addFixedwingToAirport(sc, airportService);
                    break;
                case "3":
                    // Xóa helicopter khỏi sân bay
                    helicopterService.removeHelicopterFromAirport(sc, airportService);
                    break;
                case "4":
                    // Thêm helicopter vào sân bay
                    helicopterService.addHelicopterToAirport(sc, airportService);
                    break;
                case "5":
                    // Thay đổi loại fixedwing và min runway
                    fixedwingService.changeTypeOrMinRunway(sc);
                    break;
                case "6":
                    // Quản lý sân bay
                    while (true) {
                        System.out.println("--- Airport Management ---");
                        System.out.println("a. Display list of all airports (sorted by ID)");
                        System.out.println("b. Display status of one airport by ID");
                        System.out.println("c. Back");
                        System.out.print("Choose: ");
                        String sub = sc.nextLine();
                        if (sub.equalsIgnoreCase("a")) {
                            airportService.displayAllAirports();
                        } else if (sub.equalsIgnoreCase("b")) {
                            System.out.print("Enter Airport ID: ");
                            String aid = sc.nextLine();
                            airportService.displayStatus(aid);
                        } else if (sub.equalsIgnoreCase("c")) {
                            break;
                        } else {
                            System.out.println("Invalid choice!");
                        }
                    }
                    break;
                case "7":
                    // Quản lý fixedwing
                    fixedwingService.displayAllFixedwingWithAirport(airportService);
                    break;
                case "8":
                    // Quản lý helicopter
                    helicopterService.displayAllHelicopterWithAirport(airportService);
                    break;
                case "0":
                    System.out.println("Exit!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
