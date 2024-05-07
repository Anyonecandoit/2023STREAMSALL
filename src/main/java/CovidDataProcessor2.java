import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CovidDataProcessor2 {

  

    
    
  public   static   Integer Totalpopulation(List<CovidData> data) {
    	
   
	  int tp =  data.stream().collect(Collectors.summingInt(country -> country.getPopulation()));
    
  System.out.println("tp  : " + tp);
  
  return tp;
  }

  

//  private static boolean isHighDeathRate(CovidData country) {
//      return country.getTotalDeaths() > 100;
//  }


   
  public static List<String> countriesWithHighDeathRate(List<CovidData> data) {
//      return data.stream()
//              .filter(country -> country.getTotalDeaths() ==  708739)
//              .map(CovidData::getCountry) // Assuming there's a getCountryName method in CovidData
//              .collect(Collectors.toList());
//      
	  
	  return data.stream().filter(country -> country.getNewDeaths() == 8).map(CovidData::getCountry).collect(Collectors.toList());
       
  }

  
 public static String maximumtotaltests(List<CovidData> data) {
	 
	 
	String c =  data.stream().collect(Collectors.maxBy(Comparator.comparing(country -> country.getTotalTests() ))).map(CovidData::getCountry).orElse(null);

	
	System.out.println("tt : " + c);
 return c ;
 
 }
 
 
 public static String minimumTotalTests(List<CovidData> data) {
	    AtomicReference<String> countryWithMinTests = new AtomicReference<>();

	    data.stream()
	            .collect(Collectors.minBy(Comparator.comparing(country -> country.getTotalTests())))
	            .ifPresent(country -> {
	                countryWithMinTests.set(country.getCountry());
	                System.out.println("Processing country: " + countryWithMinTests.get());
	            });

	    System.out.println("Country with minimum total tests: " + countryWithMinTests.get());
	    return countryWithMinTests.get();
	}



 public static String maximumTotalTests(List<CovidData> data) {
	    AtomicReference<String> countryWithMaxTests = new AtomicReference<>();

	    data.stream()
	            .collect(Collectors.maxBy(Comparator.comparing(country -> country.getTotalTests())))
	            .ifPresent(country -> {
	                countryWithMaxTests.set(country.getCountry());
	                System.out.println("Processing country: " + countryWithMaxTests.get());
	            });

	    System.out.println("Country with maximum total tests: " + countryWithMaxTests.get());
	    return countryWithMaxTests.get();
	}

 
 public static Double averagetest(List<CovidData> data ) 
 
 {
	 
	 Double a =  data.stream().collect(Collectors.averagingInt(country -> country.getTestsPer1MPop()));
	 System.out.println("at : " + a);
	 return a;
	 
 }

 
 public static Object  casesmorethandeath(List<CovidData> data) {
	 
	 Object cmd = data.stream().filter(country -> country.getTotalCases() > country.getTotalDeaths()).map(CovidData::getCountry).sorted().collect(Collectors.collectingAndThen(Collectors.toList(), List::of));
	 System.out.println("cmd" + cmd);
	 return cmd;
 }
 
 
 
 public static Object  testforeachcountry(List<CovidData> data) {
	 
	 Map<Object, Integer> tfec = data.stream().collect(Collectors.groupingBy(country -> country.getCountry(),Collectors.summingInt(country -> country.getTotalCases()) ));
	
	 System.out.println("tfec" + tfec);
	 return tfec ;
 }
 
 public static String highestnewcasescountry(List<CovidData> data)
 {
	 
String	 hncc = data.stream().sorted(Comparator.comparing(country -> country.getNewCases())).map(CovidData::getCountry).collect(Collectors.joining(",  "));
	 
System.out.println("hncc : " + hncc);
	 return hncc;
	 
 }
 
 
 
 
 
 public static  Integer totalcases(List<CovidData> data) {
	 
	  int d = data.stream().collect(Collectors.reducing(0,CovidData::getTotalCases ,Integer::sum));
	  
	  System.out.println("d"+d);
	 return d ;
 }
 
 
 
 
 
 
 
 public static long countTotalCases1(List<CovidData> data) {
	  
	 long	 t = 
	 
	  data.stream()
	            .collect(Collectors.summarizingInt(CovidData::getTotalCases))
	            .getSum();
	 System.out.println("t" + t);
	 return t;
	}

 
 


 public static ConcurrentMap<String, Integer> totalCasesByContinentConcurrentMap(List<CovidData> data) {
    
	 ConcurrentMap<String, Integer> x = 	 data.parallelStream().collect(Collectors.toConcurrentMap(CovidData::getCountry, CovidData::getTotalCases, Integer::sum));
System.out.println("x: " + x);
	 return  x;
 
 }

 
 public static List<Object> flatMapCountry(List<CovidData> data) {
     List<Object> flattenedList = data.stream()
             .map(CovidData::getCountry1)
             .filter(country -> country != null && !country.isEmpty())
             .flatMap(List::stream)
             .collect(Collectors.toList());

     System.out.println("Flattened List: " + flattenedList);
     return flattenedList;
 }
 
 
 
 public static  Object teeing(List<CovidData> data) {
	 
	 Object f = data.stream().collect(Collectors.teeing(Collectors.maxBy(
			 
			 (c1, c2) -> Integer.compare(c1.getTotalCases() ,c2.getTotalCases()))     , 
			 
			 Collectors.maxBy((c1, c2) -> Integer.compare(c1.getTotalDeaths(), c2.getTotalDeaths()))   ,
			 
			 (maxcases,maxdeaths) -> "maxcases : " + maxcases.map(CovidData::getCountry).orElse("N/A") + " , Maxdeaths : " + maxdeaths.map(CovidData::getCountry).orElse("N/A")));
	 
	 
	 System.out.println("f  " + f);
	 return f ; 
 }
 
 
 

    public static void main(String[] args) {
        List<CovidData> testData = createSampleCovidData();

       
      
        System.out.println("Average Death Rate: " + countriesWithHighDeathRate(testData));
        Totalpopulation(testData);
        maximumTotalTests(testData);
        
        averagetest(testData);
        Object result =     casesmorethandeath(testData);
        testforeachcountry(testData);
        highestnewcasescountry(testData);
        totalCasesByContinentConcurrentMap(testData);
        
        totalcases(testData);
        
        countTotalCases1(testData);
        
        minimumTotalTests(testData);
        
        flatMapCountry(testData);
        
        teeing(testData);
    }

    
  
    private static List<CovidData> createSampleCovidData() {
        return CovidData.createSampleCovidData();
    }
}
	