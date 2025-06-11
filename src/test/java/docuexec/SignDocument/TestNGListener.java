package docuexec.SignDocument;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGListener implements ITestListener {

    private Workbook workbook;
    private Sheet sheet;
    private int rowNum = 1; // Start from row 1 to avoid overwriting the header row
    private String suiteName;
    private String currentDate;

    @Override
    public void onStart(ITestContext context) {
        // Initialize the Excel workbook and sheet at the start of the test run
        if (workbook == null) {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Test Results");

            // Get the test suite name and the current date for the report
            suiteName = context.getSuite().getName();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            currentDate = dateFormat.format(new Date()); // Current timestamp for filename

            // Create headers for the sheet
            createHeader();
        }
    }

    private void createHeader() {
        // Add headers to the Excel sheet for test details
        Row headerRow = sheet.createRow(0);
        
        // Set cell style for bold and background color
        CellStyle headerStyle = workbook.createCellStyle();
        Font boldFont = workbook.createFont();
        boldFont.setBold(true);
        headerStyle.setFont(boldFont);
        
        // Set background color (light gray)
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Create header cells
        String[] headers = {"Test Name", "Status", "Duration (secs)", "Test Description", "Error Details", "Timestamp"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            // After the tests are complete, save the results to an Excel file
            saveToExcel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToExcel() throws IOException {
        // Define file path with timestamp for unique file names
        String filePath = "C:/Users/lavanyab.FINFOTECH/Desktop/Docu Exec/Automation Test Report/"
                + "Combined_Test_Report_" + currentDate + ".xlsx";//report path 

        // Create the directory if it doesn't exist
        File dir = new File("C:/Users/lavanyab.FINFOTECH/Desktop/Docu Exec/Automation Test Report");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Write the workbook to the specified file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Log the start of the test
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logTestResult(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logTestResult(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logTestResult(result);
    }

    private void logTestResult(ITestResult result) {
        // Log test result to the sheet
        Row row = sheet.createRow(rowNum++);

        // Add test name
        row.createCell(0).setCellValue(result.getName());

        // Add test status (PASS/FAIL/SKIP)
        String status = (result.getStatus() == ITestResult.SUCCESS) ? "PASS" :
                        (result.getStatus() == ITestResult.FAILURE) ? "FAIL" : "SKIPPED";
        row.createCell(1).setCellValue(status);

        // Add test duration (in seconds)
        long durationInMillis = result.getEndMillis() - result.getStartMillis();
        double durationInSeconds = convertMillisToSeconds(durationInMillis);
        row.createCell(2).setCellValue(durationInSeconds);

        // Add test description (if any)
        row.createCell(3).setCellValue(result.getMethod().getDescription() != null ? 
                                        result.getMethod().getDescription() : "N/A");

        // Add error details if the test failed
        if (result.getStatus() == ITestResult.FAILURE) {
            String errorMessage = result.getThrowable().getMessage();
            String stackTrace = getStackTrace(result.getThrowable());
            row.createCell(4).setCellValue("Error: " + errorMessage + "\n" + stackTrace);
        } else {
            row.createCell(4).setCellValue("N/A");
        }

        // Add timestamp when the test was executed
        row.createCell(5).setCellValue(currentDate);

        // Style the status column
        CellStyle statusStyle = workbook.createCellStyle();
        if (status.equals("PASS")) {
            statusStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        } else if (status.equals("FAIL")) {
            statusStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        } else {
            statusStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        }
        statusStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        row.getCell(1).setCellStyle(statusStyle); // Apply the style to the status column
    }

    private String getStackTrace(Throwable throwable) {
        StringBuilder stackTrace = new StringBuilder();
        for (StackTraceElement element : throwable.getStackTrace()) {
            stackTrace.append(element.toString()).append("\n");
        }
        return stackTrace.toString();
    }

    // Convert milliseconds to seconds (and return as double)
    private double convertMillisToSeconds(long millis) {
        return millis / 1000.0;  // 1,000 milliseconds in 1 second
    }
}
