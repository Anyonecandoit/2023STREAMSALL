import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CovidData {

    @ExcelColumn("Country, Other")
    private String country;
    @ExcelColumn("s.no")
    private int snum;

    @ExcelColumn("Total Cases")
    private int totalCases;

    @ExcelColumn("New Cases")
    private int newCases;

    @ExcelColumn("Total Deaths")
    private int totalDeaths;

    @ExcelColumn("New Deaths")
    private int newDeaths;

    @ExcelColumn("Total Recovered")
    private int totalRecovered;

    @ExcelColumn("New Recovered")
    private int newRecovered;

    @ExcelColumn("Active Cases")
    private int activeCases;

    @ExcelColumn("Serious, Critical")
    private int seriousCritical;

    @ExcelColumn("Tot Cases/ 1M pop")
    private int totCasesPer1MPop;

    @ExcelColumn("Deaths/ 1M pop")
    private int deathsPer1MPop;

    @ExcelColumn("Total Tests")
    private int totalTests;

    @ExcelColumn("Tests/ 1M pop")
    private int testsPer1MPop;

    @ExcelColumn("Population")
    private int population;

    // Getters and setters...

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface ExcelColumn {
        String value();
    }

	public String getCountry() {
		return country;
	}

	public int getSnum() {
		return snum;
	}

	public int getTotalCases() {
		return totalCases;
	}

	public int getNewCases() {
		return newCases;
	}

	public int getTotalDeaths() {
		return totalDeaths;
	}

	public int getNewDeaths() {
		return newDeaths;
	}

	public int getTotalRecovered() {
		return totalRecovered;
	}

	public int getNewRecovered() {
		return newRecovered;
	}
	
	public List<String> getCountry1() {
	    return Collections.singletonList(country);
	}


	public int getActiveCases() {
		return activeCases;
	}

	public int getSeriousCritical() {
		return seriousCritical;
	}

	public int getTotCasesPer1MPop() {
		return totCasesPer1MPop;
	}

	public int getDeathsPer1MPop() {
		return deathsPer1MPop;
	}

	public int getTotalTests() {
		return totalTests;
	}

	public int getTestsPer1MPop() {
		return testsPer1MPop;
	}

	public int getPopulation() {
		return population;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}

	public void setNewCases(int newCases) {
		this.newCases = newCases;
	}

	public void setTotalDeaths(int totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}

	public void setTotalRecovered(int totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public void setNewRecovered(int newRecovered) {
		this.newRecovered = newRecovered;
	}

	public void setActiveCases(int activeCases) {
		this.activeCases = activeCases;
	}

	public void setSeriousCritical(int seriousCritical) {
		this.seriousCritical = seriousCritical;
	}

	public void setTotCasesPer1MPop(int totCasesPer1MPop) {
		this.totCasesPer1MPop = totCasesPer1MPop;
	}

	public void setDeathsPer1MPop(int deathsPer1MPop) {
		this.deathsPer1MPop = deathsPer1MPop;
	}

	public void setTotalTests(int totalTests) {
		this.totalTests = totalTests;
	}

	public void setTestsPer1MPop(int testsPer1MPop) {
		this.testsPer1MPop = testsPer1MPop;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

    static List<CovidData> createSampleCovidData() {
        // Creating a sample list of CovidData for demonstration
        List<CovidData> data = new ArrayList<>();

        data.add(createCovidData(1, "Brazil", 38230814, 0, 708739, 8, 36249161, 0, 1272914, 0, 177526, 3291, 63776166, 296146, 215353593));
        data.add(createCovidData(2, "S. Korea", 34571873, 0, 35934, 0, 34535939, 0, 0, 0, 673523, 700, 15804065, 307892, 51329899));
        data.add(createCovidData(3, "Japan", 33803572, 0, 74694, 0, 0, 0, 0, 0, 269169, 595, 100414883, 799578, 125584838));
        data.add(createCovidData(4, "Italy", 26671165, 0, 195139, 0, 26257742, 218284, 281, 442581, 3238, 279240685, 4633718, 60262770, 0));
        data.add(createCovidData(5, "UK", 24812582, 0, 232112, 0, 24580470, 0, 0, 362239, 3389, 522526476, 7628357, 68497907, 0));
        data.add(createCovidData(6, "Russia", 23798457, 0, 401543, 0, 23198668, 198246, 0, 163220, 2754, 273400000, 1875095, 145805947, 0));
        data.add(createCovidData(7, "Turkey", 17232066, 0, 102174, 0, 0, 0, 0, 201399, 1194, 162743369, 1902052, 85561976, 0));
        data.add(createCovidData(8, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        // Add data for other countries...

        return data;
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
    
    
}
   