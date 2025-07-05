package fa.training.utils;

public class Validator {
    // Kiểm tra định dạng ID của airport, airplane, helicopter
    public static boolean validateID(String id, String prefix) {
        return id != null && id.length() == 7 && id.startsWith(prefix) && id.substring(2).matches("\\d{5}");
    }

    // Kiểm tra model của airplane hoặc helicopter
    public static boolean validateModel(String model) {
        return model != null && model.length() <= 40;
    }

    // Kiểm tra loại máy bay Fixedwing
    public static boolean validatePlaneType(String type) {
        return type.equals("CAG") || type.equals("LGR") || type.equals("PRV");
    }

    // Kiểm tra kích thước đường băng của Fixedwing
    public static boolean validateFixedwingRunway(double airplaneMinRunway, double airportRunway) {
        return airplaneMinRunway <= airportRunway;
    }

    // Kiểm tra trọng lượng của helicopter
    public static boolean validateHelicopterWeight(double maxTakeoff, double emptyWeight) {
        return maxTakeoff <= 1.5 * emptyWeight;
    }
}
