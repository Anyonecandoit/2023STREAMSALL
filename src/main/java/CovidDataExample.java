import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CovidDataExample {

    public static void main(String[] args) {
        // Create a list to hold CovidData objects
        List<CovidData> data = new ArrayList<>();
//....
        // Sample data for each country
        data.add(createCovidData(1, "Brazil", 38230814, 0, 708739, 8, 36249161, 0, 1272914, 0, 177526, 3291, 63776166, 296146, 215353593));
        data.add(createCovidData(2, "S. Korea", 34571873, 0, 35934, 0, 34535939, 0, 0, 0, 673523, 700, 15804065, 307892, 51329899));
        data.add(createCovidData(3, "Japan", 33803572, 0, 74694, 0, 0, 0, 0, 0, 269169, 595, 100414883, 799578, 125584838));
        data.add(createCovidData(4, "Italy", 26671165, 0, 195139, 0, 26257742, 218284, 281, 442581, 3238, 279240685, 4633718, 60262770, 0));
        data.add(createCovidData(5, "UK", 24812582, 0, 232112, 0, 24580470, 0, 0, 362239, 3389, 522526476, 7628357, 68497907, 0));
        data.add(createCovidData(6, "Russia", 23798457, 0, 401543, 0, 23198668, 198246, 0, 163220, 2754, 273400000, 1875095, 145805947, 0));
        data.add(createCovidData(7, "Turkey", 17232066, 0, 102174, 0, 0, 0, 0, 201399, 1194, 162743369, 1902052, 85561976, 0));
        data.add(createCovidData(8, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        // Add data for other countries...

        // Now you have a list of CovidData objects with manually set values
        // You can use this 'data' list in your existing methods
        printDataWithCountry("Total Deaths", data, CovidData::getTotalDeaths);
        printDataWithCountry("New Deaths", data, CovidData::getNewDeaths);
        printDataWithCountry("Total Recovered", data, CovidData::getTotalRecovered);
        printDataWithCountry("New Recovered", data, CovidData::getNewRecovered);
        printDataWithCountry("Active Cases", data, CovidData::getActiveCases);
        printDataWithCountry("Serious, Critical", data, CovidData::getSeriousCritical);
        printDataWithCountry("Tot Cases/1M pop", data, CovidData::getTotCasesPer1MPop);
        printDataWithCountry("Deaths/1M pop", data, CovidData::getDeathsPer1MPop);
        printDataWithCountry("Total Tests", data, CovidData::getTotalTests);
        printDataWithCountry("Tests/1M pop", data, CovidData::getTestsPer1MPop);
        printDataWithCountry("Population", data, CovidData::getPopulation);
    }

    private static CovidData createCovidData(int snum, String country, int totalCases, int newCases, int totalDeaths,
                                            int newDeaths, int totalRecovered, int newRecovered, int activeCases,
                                            int seriousCritical, int totCasesPer1MPop, int deathsPer1MPop,
                                            int totalTests, int testsPer1MPop, int population) {
        CovidData covidData = new CovidData();
        covidData.setSnum(snum);
        covidData.setCountry(country);
        covidData.setTotalCases(totalCases);
        covidData.setNewCases(newCases);
        covidData.setTotalDeaths(totalDeaths);
        covidData.setNewDeaths(newDeaths);
        covidData.setTotalRecovered(totalRecovered);
        covidData.setNewRecovered(newRecovered);
        covidData.setActiveCases(activeCases);
        covidData.setSeriousCritical(seriousCritical);
        covidData.setTotCasesPer1MPop(totCasesPer1MPop);
        covidData.setDeathsPer1MPop(deathsPer1MPop);
        covidData.setTotalTests(totalTests);
        covidData.setTestsPer1MPop(testsPer1MPop);
        covidData.setPopulation(population);
        return covidData;
    }

    private static <T> void printDataWithCountry(String category, List<CovidData> data, Function<CovidData, T> dataExtractor) {
        System.out.println(category + ":");
        for (CovidData covidData : data) {
            String countryName = covidData.getCountry();
            T value = dataExtractor.apply(covidData);
            if (isNumeric(value)) {
                System.out.println(countryName + ": " + value);
            } else {
                System.out.println(countryName + ": N/A");
            }
        }
        System.out.println();
    }

    private static <T> boolean isNumeric(T value) {
        if (value == null) {
            return false;
        }

        try {
            Double.parseDouble(value.toString());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
