package docuexec.EnduserAllModules;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {

    Workbook workbook;
    Sheet sheet;
    int rowCount = 0;
    int serialNumber = 1;

    // Create or load the Excel report
    public void createExcelFile() throws IOException {
        File file = new File("C:\\Users\\saikumarm\\Documents\\DocuExecAutomationTestReport\\TestReport.xlsx");

        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheetAt(0);
            rowCount = sheet.getLastRowNum() + 1;
            fileInputStream.close();
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Test Report");

            // Report Title
            Row headingRow = sheet.createRow(rowCount++);
            Cell headingCell = headingRow.createCell(0);
            headingCell.setCellValue("DocuExec Application Automation Test Report");

            CellStyle headingStyle = workbook.createCellStyle();
            Font headingFont = workbook.createFont();
            headingFont.setBold(true);
            headingFont.setFontHeightInPoints((short) 14);
            headingStyle.setFont(headingFont);
            headingCell.setCellStyle(headingStyle);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));

            // Version Row
            Row versionRow = sheet.createRow(rowCount++);
            Cell versionCell = versionRow.createCell(0);
            versionCell.setCellValue("Version : 1.9.33");

            CellStyle versionStyle = workbook.createCellStyle();
            Font versionFont = workbook.createFont();
            versionFont.setBold(true);
            versionFont.setFontHeightInPoints((short) 10);
            versionStyle.setFont(versionFont);
            versionCell.setCellStyle(versionStyle);

            // Date Row
            Row dateRow = sheet.createRow(rowCount++);
            Cell dateCell = dateRow.createCell(0);
            dateCell.setCellValue("Date: 26-05-2025");

            CellStyle dateStyle = workbook.createCellStyle();
            Font dateFont = workbook.createFont();
            dateFont.setBold(true);
            dateFont.setFontHeightInPoints((short) 10);
            dateStyle.setFont(dateFont);
            dateCell.setCellStyle(dateStyle);
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 5));

            sheet.createRow(rowCount++); // Empty row

            // Table Header
            Row header = sheet.createRow(rowCount++);
            String[] headers = { "S.No", "Test Name", "Status", "Duration (minutes)", "Error", "Timestamp" };

            CellStyle headerStyle = createBorderStyle(true);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }
        }
    }

    // Add result row to the sheet
    public void addResult(String testName, String testResult, double executionTime, String errorMessage) {
        Row row = sheet.createRow(rowCount++);

        // Create styles
        CellStyle greenStyle = createBorderStyle(false);
        greenStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        greenStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle redStyle = createBorderStyle(false);
        redStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        redStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle normalStyle = createBorderStyle(false);

        // S.No
        Cell slno = row.createCell(0);
        slno.setCellValue(serialNumber++);
        slno.setCellStyle(normalStyle);

        // Test Name
        Cell nameCell = row.createCell(1);
        nameCell.setCellValue(testName);
        nameCell.setCellStyle(normalStyle);

        // Status
        Cell statusCell = row.createCell(2);
        statusCell.setCellValue(testResult);
        statusCell.setCellStyle("Passed".equalsIgnoreCase(testResult) ? greenStyle :
                                "Failed".equalsIgnoreCase(testResult) ? redStyle : normalStyle);

        // Duration
        Cell durationCell = row.createCell(3);
        durationCell.setCellValue(Math.round(executionTime * 100.0) / 100.0);
        durationCell.setCellStyle(normalStyle);

        // Error Message
        Cell errorCell = row.createCell(4);
        errorCell.setCellValue((errorMessage == null || errorMessage.isEmpty()) ? "No Errors" : errorMessage);
        errorCell.setCellStyle((errorMessage == null || errorMessage.isEmpty()) ? greenStyle : redStyle);

        // Timestamp
        Cell timestampCell = row.createCell(5);
        timestampCell.setCellValue(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        timestampCell.setCellStyle(normalStyle);
    }

    // Save the report to the specified path
    public void saveReport(String filePath) throws Exception {
        // Auto-size all columns for neatness
        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    // Utility method to create border style
    private CellStyle createBorderStyle(boolean bold) {
        CellStyle style = workbook.createCellStyle();
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        Font font = workbook.createFont();
        font.setBold(bold);
        style.setFont(font);

        return style;
    }

    // --- TestNG Listener Callbacks ---

    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        long execTime = result.getEndMillis() - result.getStartMillis();
        addResult(result.getName(), "Passed", execTime / 60000.0, "");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        String error = result.getThrowable() != null ? result.getThrowable().toString() : "Unknown Error";
        long execTime = result.getEndMillis() - result.getStartMillis();
        addResult(result.getName(), "Failed", execTime / 60000.0, error);
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        addResult(result.getName(), "Skipped", 0.0, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional: Handle partial pass/failure
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
        try {
            createExcelFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
        try {
            saveReport("C:\\Users\\saikumarm\\Documents\\DocuExecAutomationTestReport\\TestReport.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
