package fa.training.utils;

public class Validator {
    // Validates the ID of an airport, airplane, or helicopter
    public static boolean validateID(String id, String prefix) {
        return id != null && id.length() == 7 && id.startsWith(prefix) && id.substring(2).matches("\\d{5}");
    }

    // Validates the model of an airplane or helicopter
    public static boolean validateModel(String model) {
        return model != null && model.length() <= 40;
    }

    // Validates the types of an airplane
    public static boolean validatePlaneType(String type) {
        return type.equals("CAG") || type.equals("LGR") || type.equals("PRV");
    }

    // Validates the Runway size of Fixedwing airplanes
    public static boolean validateFixedwingRunway(double airplaneMinRunway, double airportRunway) {
        return airplaneMinRunway <= airportRunway;
    }

    // Validates the weight of an airplane or helicopter
    public static boolean validateHelicopterWeight(double maxTakeoff, double emptyWeight) {
        return maxTakeoff <= 1.5 * emptyWeight;
    }
}
