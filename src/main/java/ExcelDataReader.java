import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

    public static void main(String[] args) throws IOException {
        // Read data from Excel
        List<CovidData> data = ExcelDataReader.readDataFromExcel("F:\\2023\\output.xlsx");

        List<String> countriesWithTestingOver50Million = data.stream()
                .filter(covidData -> covidData.getTotalTests() > 50_000_000)
                .map(CovidData::getCountry)
                .collect(Collectors.toList());

        assertFalse(countriesWithTestingOver50Million.isEmpty());

        System.out.println(countriesWithTestingOver50Million);
    }

    private static void assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionError("Assertion failed");
        }
    }




    public static List<CovidData> readDataFromExcel(String excelFileName) throws IOException {
        List<CovidData> data = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(excelFileName);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheet("Data");

            if (sheet != null) {
                Iterator<Row> rowIterator = sheet.iterator();

                // Skip header row
                if (rowIterator.hasNext()) {
                    Row headerRow = rowIterator.next();

                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();

                        CovidData covidData = new CovidData();

                        covidData.setCountry(getStringValue(row.getCell(0)));
                        covidData.setOther(parseIntValue(row.getCell(1)));
                        covidData.setTotalCases(parseIntValue(row.getCell(2)));
                        covidData.setNewCases(parseIntValue(row.getCell(3)));
                        covidData.setTotalDeaths(parseIntValue(row.getCell(4)));
                        covidData.setNewDeaths(parseIntValue(row.getCell(5)));
                        covidData.setTotalRecovered(parseIntValue(row.getCell(6)));
                        covidData.setNewRecovered(parseIntValue(row.getCell(7)));
                        covidData.setActiveCases(parseIntValue(row.getCell(8)));
                        covidData.setSeriousCritical(parseIntValue(row.getCell(9)));
                        covidData.setTotCasesPer1MPop(parseIntValue(row.getCell(10)));
                        covidData.setDeathsPer1MPop(parseIntValue(row.getCell(11)));
                        covidData.setTotalTests(parseIntValue(row.getCell(12)));
                        covidData.setTestsPer1MPop(parseIntValue(row.getCell(13)));
                        covidData.setPopulation(parseIntValue(row.getCell(14)));

                        data.add(covidData);
                    }
                } else {
                    System.err.println("Sheet named 'Data' not found in the workbook.");
                }
            }
        }

        return data;
    }

    private static String getStringValue(Cell cell) {
        return cell != null && cell.getCellType() == CellType.STRING ? cell.getStringCellValue().trim() : "";
    }

    private static int parseIntValue(Cell cell) {
        try {
            if (cell == null) {
                return 0; // or another default value
            }

            if (cell.getCellType() == CellType.NUMERIC) {
                return (int) cell.getNumericCellValue();
            } else if (cell.getCellType() == CellType.STRING) {
                String cellValue = cell.getStringCellValue().trim();

                // Handle special cases where the cell may contain non-numeric characters
                if (cellValue.isEmpty() || cellValue.equals("#")) {
                    return 0; // or another default value
                }

                return Integer.parseInt(cellValue);
            } else {
                // Handle other cell types as needed
                return 0; // or another default value
            }
        } catch (NumberFormatException e) {
            // Handle the case where the string cannot be parsed to an integer
            System.err.println("Error parsing string to integer: " + e.getMessage());
            return 0; // or another default value
        }
    }
}
