package com.itheima.test;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/1815:35
 */
public class JasperReportsTest {
    @Test
    public void test1() throws JRException {
        String jrxmlPath = "E:\\APP\\health\\health_parent\\health_parent\\jasperReportsDemo\\src\\main\\resources\\demo.jrxml";
        String jasperPath = "E:\\APP\\health\\health_parent\\health_parent\\jasperReportsDemo\\src\\main\\resources\\demo.jasper";
        //编译模板
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);
        Map paramters = new HashMap();
        paramters.put("reportDate", "2019-10-10");
        paramters.put("company", "itcast");
        List<Map> list = new ArrayList();
        Map map1 = new HashMap();
        map1.put("name", "xiaoming");
        map1.put("address", "beijing");
        map1.put("email", "xiaoming@itcast.cn");
        Map map2 = new HashMap();
        map2.put("name", "xiaoli");
        map2.put("address", "nanjing");
        map2.put("email", "xiaoli@itcast.cn");
        list.add(map1);
        list.add(map2);

        //填充数据
        JasperReport jasperReport;
        JRDataSource dataSource;
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, paramters, new JRBeanCollectionDataSource(list));

        String pdfPath = "D:\\test.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);
    }

    @Test
    public void test2() throws ClassNotFoundException, JRException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health", "root", "root");

            String jrxmlPath = "E:\\APP\\health\\health_parent\\health_parent\\jasperReportsDemo\\src\\main\\resources\\demo1.jrxml";
            String jasperPath = "E:\\APP\\health\\health_parent\\health_parent\\jasperReportsDemo\\src\\main\\resources\\demo1.jasper";


            JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

            Map map = new HashMap();
            map.put("company", "传智");

            //填充数据
            JasperReport jasperReport;
            JRDataSource dataSource;
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, map, connection);


            String pdfPath = "D:\\test.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test3() throws JRException {
        String jrxmlPath = "E:\\APP\\health\\health_parent\\health_parent\\jasperReportsDemo\\src\\main\\resources\\demo2.jrxml";
        String jasperPath = "E:\\APP\\health\\health_parent\\health_parent\\jasperReportsDemo\\src\\main\\resources\\demo2.jasper";

        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

        Map map = new HashMap();
        map.put("company","传智");

        List<Map> list = new ArrayList<Map>();
        Map map1 = new HashMap();
        map1.put("name","入职体检套餐");
        map1.put("code","RZTJ");
        map1.put("age","18-60");
        map1.put("sex","男");

        Map map2 = new HashMap();
        map2.put("name","阳光爸妈老年健康体检");
        map2.put("code","YGBM");
        map2.put("age","55-60");
        map2.put("sex","女");
        list.add(map1);
        list.add(map2);
        //填充数据
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath,map,new JRBeanCollectionDataSource(list));

        //输出文件
        String pdfPath = "D:\\test.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,pdfPath);
    }
}
