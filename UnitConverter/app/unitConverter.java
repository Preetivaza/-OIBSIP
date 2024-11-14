public class UnitConverter {

    public static double lengthConversion(String fromUnit, String toUnit, double value) {
        if (fromUnit.equals("Meters") && toUnit.equals("Kilometers")) {
            return value / 1000;
        } else if (fromUnit.equals("Kilometers") && toUnit.equals("Meters")) {
            return value * 1000;
        }
        // Add more conditions for other conversions
        return value; // Return the value unchanged if no conversion is applied
    }
}
