package com.itheima;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/911:24
 */

public class POIController {

    @Test
    public void test1() throws Exception {
        //加载指定文件，创建一个Excel对象（工作簿）
        XSSFWorkbook excel = new XSSFWorkbook(new FileInputStream(new File("e:\\poi.xlsx")));
        XSSFSheet sheet = excel.getSheetAt(0);
        for (Row row : sheet) {
            System.out.println(row);
            for (Cell cell : row) {
                System.out.println(cell.getStringCellValue());
            }
        }
        excel.close();
    }

    @Test
    public void test2() {
        try {
            XSSFWorkbook excel = new XSSFWorkbook(new FileInputStream(new File("e:\\poi.xlsx")));
            XSSFSheet sheet = excel.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 0; i <= lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                short lastCellNum = row.getLastCellNum();
                for (int j = 0; j < lastCellNum; j++) {
                    XSSFCell cell = row.getCell(j);
                    System.out.println(cell.getStringCellValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test3(){
        XSSFWorkbook excel = new XSSFWorkbook();
        XSSFSheet sheet = excel.createSheet("htheima");
        XSSFRow title = sheet.createRow(0);
        title.createCell(0).setCellValue("姓名");
        title.createCell(1).setCellValue("地址");
        title.createCell(2).setCellValue("年龄");

        XSSFRow dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue("小明");
        dataRow.createCell(1).setCellValue("北京");
        dataRow.createCell(2).setCellValue("20");

        try {
            FileOutputStream out = new FileOutputStream(new File("e:\\hello.xlsx"));
            excel.write(out);
            out.flush();
            excel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
