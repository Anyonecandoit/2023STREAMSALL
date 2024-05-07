import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Automation {



		  public static void main(String[] args) throws InterruptedException, IOException {

		        ChromeOptions co = new ChromeOptions();
		        co.setCapability("browserName", "chrome");
		        WebDriver driver = new ChromeDriver(co);

		        driver.get("https://www.worldometers.info/coronavirus/");
		        Thread.sleep(5000);

		        // Extract and print table headings
		        List<WebElement> headingElements = driver.findElements(By.xpath("/html/body/div[3]/div[3]/div/div[7]/div[1]/div/table/thead/tr/th"));
		        List<String> headings = headingElements.stream().map(WebElement::getText).collect(Collectors.toList());

		        // Join the headings into a single line without line breaks and add square brackets
		        String headingsString = "[" + String.join(", ", headings).replaceAll("\\r?\\n", "") + "]";
		        System.out.println("Headings: " + headingsString);

		        
		        System.out.println("getting row list");
		        // Extract and print table data for a specific row
		        List<WebElement> rowElements = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr[8]"));

		        System.out.println( "got and using lambda getting data");
		        List<Map<String, String>> data = rowElements.stream().map(row -> {
		            List<WebElement> cellElements = row.findElements(By.tagName("td"));
		            Map<String, String> rowData = new HashMap<>();
		            for (int i = 0; i < headings.size(); i++) {
		                rowData.put(headings.get(i), cellElements.get(i).getText());
		            }
		            return rowData;
		        }).collect(Collectors.toList());

		        
		        System.out.println( "got data printing now ");
		        // Print data
		        String dataString = data.stream()
		                .map(rowData -> "[" + String.join(", ", rowData.values()) + "]")
		                .collect(Collectors.joining(", "));
		        System.out.println("Data: " + dataString);
		        
		  }}
		//System.out.println("text case failed");

//		System.out.println("getting text and addin in list");
//		List<String> citiesnames = elements.parallelStream()
//				.map(WebElement::getText)
//				.filter(data -> data != null)
//				.collect(Collectors.toList());
//		List<String>  cities = new ArrayList<>();
//		cities.addAll(citiesnames);	
//		System.out.println(cities);
//		System.out.println(cities.size());
//
//		//td[@class='rbi']
//		List<WebElement> elements1 = driver.findElements(By.xpath("//td[@class='rbi']"));
//
//
//		System.out.println("getting text and addin in list");
//		List<String> temperatureofcities = elements1.parallelStream()
//				.map(WebElement::getText)
//				.filter(data -> data != null)
//				.collect(Collectors.toList());
//		List<String>  temperature = new ArrayList<>();
//		temperature.addAll(temperatureofcities);	
//		System.out.println(temperature);
//		System.out.println(temperature.size());
//
//	
//		
//		//List<String> mergedList =  IntStream.range(0, Math.min(cities.size(), temperature.size())).mapToObj(i -> cities.get(i) + " - " + temperatures.get(i)).collect(ArrayList::new, ArrayList::add, ArrayList::addall);
//		
//		 List<String> mergedList =  new ArrayList<>();
//				 
//				 IntStream.range(0, Math.min(cities.size(), temperature.size()))
//	                .forEach(i -> {
//	                    String city = cities.get(i);
//	                    String temperatures = temperature.get(i);
//	                    mergedList.add(city + " - " + temperatures);
//	                });
//
//		 if (mergedList.isEmpty()) {
//	            System.out.println("The lists have different sizes and cannot be merged.");
//	        } else {
//	            mergedList.forEach(System.out::println);
//	        }
//		driver.quit();
//	}















