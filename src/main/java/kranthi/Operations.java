package kranthi;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class Operations {

	public static int findMaxTemperature(final List<Integer> temperaturedatalist) {


		int sum = temperaturedatalist.stream().reduce(0, (a, b) -> a + b);
		
		Optional<Integer> x = temperaturedatalist.stream().filter(e -> e > 20).findAny();
		
		x.ifPresent(System.out::println);
		System.out.println(sum);
		System.out.println(temperaturedatalist.stream().count());
		int maxTemperature = temperaturedatalist.stream()
				.mapToInt(Integer::intValue)
				.max()
				.orElse(-1);

		return maxTemperature;
	}

	public static int findMinTemperature(List<Integer> temperaturedatalist) {


		int minTemp = temperaturedatalist.parallelStream()
				.mapToInt(Integer::intValue)
				.min()
				.orElse(-1);

		return minTemp;
	}


	public static List<String> getcitynames(List<String> citydatalist) {

List<String> citylist =  citydatalist.stream().filter(String -> String.length()>=9).sorted().map(String -> String.concat(" - ")).collect(Collectors.toList());
boolean anyRecordStartsWithA = citylist.stream().allMatch(s-> s.startsWith("A"));
System.out.println(anyRecordStartsWithA);
System.out.println(citylist.stream().count());
return citylist;
	}

	
	public static List<Entry<String, Integer>> combineCityTemperature(List<String> cityDataList, List<Integer> temperatureDataList) {
        List<Entry<String, Integer>> cityTemperatureList = new ArrayList<>();

        // Check if both lists have the same size
        if (cityDataList.size() == temperatureDataList.size()) {
            for (int i = 0; i < cityDataList.size(); i++) {
                String city = cityDataList.get(i);
                Integer temperature = temperatureDataList.get(i);

                Entry<String, Integer> cityTemperatureEntry = new AbstractMap.SimpleEntry<>(city, temperature);
                cityTemperatureList.add(cityTemperatureEntry);
          
            }
        } else {
            System.out.println("City and temperature lists must have the same size.");
        }
        System.out.println(cityTemperatureList.size());
        return cityTemperatureList;
    }

	public static void main(String[] args) {
		List<Integer> temperaturedatalist = Weather.getTemperatureList();

		List<String> citydatalist = Weather.getCitiesList();
		
List<Map.Entry<String, Integer>>   citytemperatureentry = combineCityTemperature(citydatalist ,temperaturedatalist);
		int maxTemperature = Operations.findMaxTemperature(temperaturedatalist);
		int minTemperature = Operations.findMinTemperature(temperaturedatalist);
		List<String>  citylist =  Operations.getcitynames(citydatalist);
//		System.out.println("Maximum Temperature: " + maxTemperature);
//		System.out.println("Minimum Temperature: " + minTemperature);
//		System.out.println("city: " + citylist);
		
		System.out.println(citytemperatureentry);
	}


}
