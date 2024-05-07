package kranthi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Weather {
    private int sNo;
    private String country;
    private int temperature;
    private String maximumtemperature;
    private String minimumtemperature;

    public Weather(int sNo, String country, int temperature, String maximumtemperature, String minimumtemperature) {
        this.sNo = sNo;
        this.country = country;
        this.temperature = temperature;
        this.maximumtemperature = maximumtemperature;
        this.minimumtemperature = minimumtemperature;
    }

 
 

        

    
    public static List<String> getCitiesList() {
    	String[] cityNames = {
        	    "Accra", "Edmonton", "Nassau", "Adelaide", "Frankfurt", "New Delhi", "Algiers", "Guatemala City",
        	    "New Orleans", "Almaty", "Halifax", "New York", "Amman", "Hanoi", "Oslo", "Amsterdam", "Harare", "Ottawa",
        	    "Anadyr", "Havana", "Paris", "Anchorage", "Helsinki", "Perth", "Ankara", "Hong Kong", "Philadelphia",
        	    "Antananarivo", "Honolulu", "Phoenix", "Asuncion", "Houston", "Prague", "Athens", "Indianapolis", "Reykjavik",
        	    "Atlanta", "Islamabad", "Rio de Janeiro", "Auckland", "Istanbul", "Riyadh", "Baghdad", "Jakarta", "Rome",
        	    "Bangkok", "Jerusalem", "Salt Lake City", "Barcelona", "Johannesburg", "San Francisco", "Beijing", "Karachi",
        	    "San Juan", "Beirut", "Kathmandu", "San Salvador", "Belgrade", "Kingston", "Santiago", "Bengaluru", "Kinshasa",
        	    "Santo Domingo", "Berlin", "Kiritimati", "São Paulo", "Bogota", "Kolkata", "Seattle", "Boston", "Kuala Lumpur",
        	    "Seoul", "Brasilia", "Kuwait City", "Shanghai", "Brisbane", "Kyiv", "Singapore", "Brussels", "La Paz", "Sofia",
        	    "Bucharest", "Lagos", "St. John's", "Budapest", "Lahore", "Stockholm", "Buenos Aires", "Las Vegas", "Suva",
        	    "Cairo", "Lima", "Sydney", "Calgary", "Lisbon", "Taipei", "Canberra", "London", "Tallinn", "Cape Town",
        	    "Los Angeles", "Tashkent", "Caracas", "Madrid", "Tegucigalpa", "Casablanca", "Managua", "Tehran", "Chicago",
        	    "Manila", "Tokyo", "Copenhagen", "Melbourne", "Toronto", "Dallas", "Mexico City", "Vancouver", "Dar es Salaam",
        	    "Miami", "Vienna", "Darwin", "Minneapolis", "Warsaw", "Denver", "Minsk", "Washington DC", "Detroit", "Montevideo",
        	    "Winnipeg", "Dhaka", "Montréal", "Yangon", "Doha", "Moscow", "Zagreb", "Dubai", "Mumbai", "Zürich", "Dublin",
        	    "Nairobi"
        	};

        List<String> cities = new ArrayList<>();
        Collections.addAll(cities, cityNames);

        return cities;
    }

    public static List<Integer> getTemperatureList() {
        int[] temperatureValues = {
            26, 0, 25, 31, 7, 27, 17, 18, 21, 9, 0, 7, 24, 31, 2, 8, 20, 0, -5, 22, 8, 0, 2, 24,
            12, 28, 8, 24, 26, 19, 31, 21, 4, 19, 19, 1, 13, 17, 22, 15, 14, 26, 20, 33, 6, 30, 24, 2,
            11, 14, 13, 7, 31, 27, 25, 23, 25, 5, 28, 12, 28, 23, 25, 9, 28, 22, 12, 31, 5, 3, 32, 15,
            21, 26, 19, 23, 6, 28, 8, 7, 1, 7, 26, 6, 4, 25, 4, 17, 15, 26, 23, 19, 18, -3, 13, 31,
            21, 7, 6, 19, 16, 13, 25, 10, 20, 14, 26, 17, 10, 31, 19, 9, 23, 4, 22, 20, 8, 26, 24, 5,
            33, 4, 4, 0, 4, 10, 8, 15, 0, 30, 1, 32, 30, 6, 3, 31, 26, 6, 5, 22
        };

        List<Integer> temperatures = new ArrayList<>();
        for (int temperature : temperatureValues) {
            temperatures.add(temperature);
        }

        return temperatures;
    }

        
   

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getMaximumtemperature() {
        return maximumtemperature;
    }

    public void setMaximumtemperature(String maximumtemperature) {
        this.maximumtemperature = maximumtemperature;
    }

    public String getMinimumtemperature() {
        return minimumtemperature;
    }

    public void setMinimumtemperature(String minimumtemperature) {
        this.minimumtemperature = minimumtemperature;
    }
}
