import java.util.ArrayList;
import java.util.List;

public class StringToIntegerParser {

    public static int parseToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;  // Replace non-numeric values with -1 or any other default value
        }
    }

    public static void main(String[] args) {
        // Example data list containing strings
        List<String> data = List.of("Brazil", "N/A", "S. Korea", "Japan", "N/A", "Italy", "UK", "N/A", "Russia", "N/A", "Turkey", "N/A", "N/A");

        // Parse each value in the data list
        List<Integer> parsedData = new ArrayList<>();
        for (String value : data) {
            parsedData.add(parseToInt(value));
        }

        // Display the parsed data
        System.out.println(parsedData);
    }
}
