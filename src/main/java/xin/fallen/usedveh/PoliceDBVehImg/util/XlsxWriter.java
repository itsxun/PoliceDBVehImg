package xin.fallen.usedveh.PoliceDBVehImg.util;

import com.google.gson.Gson;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import sun.java2d.pipe.SpanShapeRenderer;
import xin.fallen.usedveh.PoliceDBVehImg.config.StaticConfig;

import java.util.List;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 22:50
 * Usage:
 */
public class XlsxWriter {
    public static Workbook write(String title, List<String> columsName, List<Object> objs) {
        if (StaticConfig.objX == null) {
            return null;
        }
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, columsName.size()));
        Row r = sheet.createRow(0);
        r.createCell(0).setCellValue(title == null ? StaticConfig.EXCELTITLE : title);
        for (int i = 0; i < columsName.size(); i++) {
            r = sheet.createRow(i);
            Cell c = r.createCell(i);
            c.setCellValue(columsName.get(i));
        }
        System.out.println(new Gson().toJson(objs));
        for (int i = 0; i < objs.size(); i++) {
            r = sheet.createRow(i);
            for (int j = 0; j < columsName.size(); j++) {
                Cell c = r.createCell(j);
                c.setCellValue("test");
            }
        }
        return wb;
    }
}
