package fa.training.utils;

public class Validator {
    public static boolean validateID(String id, String prefix) {
        return id != null && id.length() == 7 && id.startsWith(prefix) && id.substring(2).matches("\\d{5}");
    }

    public static boolean validateModel(String model) {
        return model != null && model.length() <= 40;
    }

    public static boolean validatePlaneType(String type) {
        return type.equals("CAG") || type.equals("LGR") || type.equals("PRV");
    }

    public static boolean validateFixedwingRunway(double airplaneMinRunway, double airportRunway) {
        return airplaneMinRunway <= airportRunway;
    }

    public static boolean validateHelicopterWeight(double maxTakeoff, double emptyWeight) {
        return maxTakeoff <= 1.5 * emptyWeight;
    }
}
