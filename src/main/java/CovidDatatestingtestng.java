import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
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

public class CovidDatatestingtestng {

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

        // Extract and print table data for a specific row
        List<WebElement> rowElements = driver.findElements(By.xpath("//div[@id='nav-tabContent']/self::div/child::div[1]/child::div[1]/child::div[1]/following-sibling::table/child::tbody[1]/child::tr/following-sibling::tr[9]"));

        List<Map<String, String>> data = rowElements.stream().map(row -> {
            List<WebElement> cellElements = row.findElements(By.tagName("td"));
            Map<String, String> rowData = new HashMap<>();
            for (int i = 0; i < headings.size(); i++) {
                rowData.put(headings.get(i), cellElements.get(i).getText());
            }
            return rowData;
        }).collect(Collectors.toList());

        // Print data
        String dataString = data.stream()
                .map(rowData -> "[" + String.join(", ", rowData.values()) + "]")
                .collect(Collectors.joining(", "));
        System.out.println("Data: " + dataString);

        // Write data to Excel file
        writeDataToExcel(data, headings);

        driver.quit();
    }

    private static void writeDataToExcel(List<Map<String, String>> data, List<String> headings) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        // Create header row
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headings.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headings.get(i));
        }

        // Create data rows
        for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
            Row dataRow = sheet.createRow(rowIndex + 1);
            Map<String, String> rowData = data.get(rowIndex);
            for (int cellIndex = 0; cellIndex < headings.size(); cellIndex++) {
                Cell cell = dataRow.createCell(cellIndex);
                cell.setCellValue(rowData.get(headings.get(cellIndex)));
            }
        }

        // Save the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("output.xlsx")) {
            workbook.write(fileOut);
        }

        workbook.close();
        System.out.println("Data written to Excel file.");
    }
}
