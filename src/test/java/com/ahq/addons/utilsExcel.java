package com.ahq.addons;

import com.ahq.globals.BrowserGlobal;
import com.ahq.globals.Utils;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;


// Using Apache POI
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.apache.poi.ss.usermodel.Cell.*;


public class utilsExcel {
    public static void readExcelDataXLSX(String fileName) throws IOException {
        {
            try {
                FileInputStream file = new FileInputStream(new File(fileName));
                Workbook workbook = new XSSFWorkbook(file);
                Sheet sheet = workbook.getSheetAt(0);
                Map<Integer, List<String>> data = new HashMap<>();
                int i = 0;
                int cellCount = 0;
                for (Row row : sheet) {
                    data.put(i, new ArrayList<String>());
                    System.out.print("\n::: ROW ::: " + i + "\n");
                    cellCount = 0;
                    for (Cell cell : row) {
                        System.out.print("\n::: CELL ::: " + cellCount + "\n");

                        switch (cell.getCellType()) {
                            case STRING:
                                System.out.print(cell.getStringCellValue() + "\t\t");
                                break;
                            case NUMERIC:
                                System.out.print(cell.getNumericCellValue() + "\t\t");
                                break;
                            case BOOLEAN:
                                System.out.print(cell.getBooleanCellValue() + "\t\t");
                                break;
                            case FORMULA:
                                System.out.print(cell.getCellFormula() + "\t\t");
                                break;
                            default:
                                data.get(i).add(" ");
                        }
                        cellCount++;
                    }
                    i++;
                }
            } catch (Exception e) {
                System.out.print("EXCEPTION :::::::: " + e);
                //  Block of code to handle errors
            }
        }
    }

    public static void writeToExcel(String fileName, String sheetName, String cellData) throws IOException {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            Sheet sheet = workbook.getSheetAt(1);
            Sheet sheet = workbook.getSheet(sheetName);
            Cell excelCell = null;
            String[] rowDatas = cellData.trim().substring(1, cellData.length() - 1).split(";");
            for (String rowData : rowDatas) {
                String tempRow = rowData.trim();
                tempRow = tempRow.substring(1, tempRow.length() - 1);
                tempRow = tempRow.replaceAll("\\\\,","<<COMMA>>");
                System.out.println("========>" + tempRow);
                String[] cellInfo = tempRow.split(",");
                int[] cellIndex = Utils.excelCellToIndexConverter(cellInfo[0].trim());
                int rowIndex = cellIndex[0];
                int colIndex = cellIndex[1];
                String data = Utils.dataChecker(cellInfo[1].trim().replaceAll("<<COMMA>>",","));
//                cellInfo[2]= cellInfo[2].trim().replaceAll("<<COMMA>>",",");
                String cellType = (cellInfo.length > 2) ? cellInfo[2].trim().replaceAll("<<COMMA>>",",") : "N/A";
                cellType = (cellInfo.length > 2 && cellType.equalsIgnoreCase("Text") ) ? "@" : cellType;
//                cellType = (cellInfo.length > 2 && cellType.equalsIgnoreCase("Number") ) ? "#" : cellType;


                Row row = sheet.getRow(rowIndex);  // Row 0 (A1)
                if (row == null) {
                    row = sheet.createRow(rowIndex);  // Create the row if it doesn't exist
                }

                Cell cell = row.getCell(colIndex);  // Cell A1 (0,0)
                if (cell == null) {
                    cell = row.createCell(colIndex);  // Create the cell if it doesn't exist
                }

                excelCell = sheet.getRow(rowIndex).getCell(colIndex);

                CellStyle cellDataStyle = workbook.createCellStyle();
                DataFormat cellDataFormat = workbook.createDataFormat();

                System.out.println("=====START=>" + tempRow);
                excelCell.setCellValue(data);
                System.out.println("=====END=>" + tempRow);
                if (!cellType.equals("N/A")) {
                    cellDataStyle.setDataFormat(cellDataFormat.getFormat(cellType));
                    excelCell.setCellStyle(cellDataStyle);
                }

            }
            file.close();
            FileOutputStream outFile = new FileOutputStream(new File(fileName));
            workbook.write(outFile);
            outFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("===== Excel - File Not Found Exception =====");
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===== Excel - IO Exception =====");
            System.out.println(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}