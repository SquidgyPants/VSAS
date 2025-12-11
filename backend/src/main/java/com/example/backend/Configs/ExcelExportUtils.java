package com.example.backend.Configs;

import com.example.backend.Models.Shipment;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class ExcelExportUtils {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private Shipment Shipment;

    public ExcelExportUtils(Shipment shipment) {
        this.Shipment = shipment;
        workbook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void createHeaderRow() {
        sheet = workbook.createSheet("Shipments");
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);

        createCell(row, 0, "Shipment information", style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 31));
        font.setFontHeightInPoints((short) 10);

        row = sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Noticol", style);
        createCell(row, 1, "VGS", style);
        createCell(row, 2, "Destination", style);
        createCell(row, 3, "Status", style);
        createCell(row, 4, "Delivery Note", style);
        createCell(row, 5, "Date", style);
        createCell(row, 6, "Type", style);
        createCell(row, 7, "Weight", style);
        createCell(row, 8, "Stackable", style);
        createCell(row, 9, "QTY", style);
        createCell(row, 10, "Manufacturer", style);
        createCell(row, 12, "Item Number", style);
        createCell(row, 13, "Type Handling Number", style);
    }

    private void writeReportData() {
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        Row row = sheet.createRow(1);
        int columnCount = 0;
        createCell(row, columnCount++, Shipment.getNoticol(), style);
        createCell(row, columnCount++, Shipment.getHazardous(), style);
        createCell(row, columnCount++, Shipment.getDestination(), style);
        createCell(row, columnCount++, Shipment.getStatus(), style);
        createCell(row, columnCount++, Shipment.getDeliveryNote(), style);
        createCell(row, columnCount++, Shipment.getActualDate(), style);
        if (Shipment.getHandlingUnit() != null) {
            createCell(row, columnCount++, Shipment.getHandlingUnit().getType(), style);
            createCell(row, columnCount++, Shipment.getHandlingUnit().isStackable(), style);
            createCell(row, columnCount++, Shipment.getHandlingUnit().getWeight(), style);
            if (Shipment.getHandlingUnit().getDeliveries() != null && !Shipment.getHandlingUnit().getDeliveries().isEmpty()) {
                createCell(row, columnCount++, Shipment.getHandlingUnit().getDeliveries().size(), style);
                createCell(row, columnCount++, Shipment.getHandlingUnit().getDeliveries().get(0).getManufacturer(), style);
                createCell(row, columnCount++, Shipment.getHandlingUnit().getDeliveries().get(0).getItemNumber(), style);
                createCell(row, columnCount++, Shipment.getHandlingUnit().getDeliveries().get(0).getOrderNumber(), style);
            } else {
                createCell(row, columnCount++, "", style);
                createCell(row, columnCount++, "", style);
                createCell(row, columnCount++, "", style);
                createCell(row, columnCount++, "", style);
            }
        } else {
            createCell(row, columnCount++, "", style);
            createCell(row, columnCount++, "", style);
            createCell(row, columnCount++, "", style);
        }
    }

    public void exportDataToExcel(HttpServletResponse response, Shipment shipment) throws IOException {
        createHeaderRow();
        writeReportData();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}