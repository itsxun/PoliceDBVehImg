package xin.fallen.usedveh.PoliceDBVehImg.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import xin.fallen.usedveh.PoliceDBVehImg.config.CompositeColumnZh;
import xin.fallen.usedveh.PoliceDBVehImg.config.StaticConfig;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 22:50
 * Usage:生成excel
 */
public class XlsxWriter {
    /**
     * @param title：生成的excel的大标题
     * @param columsName：生成的excel的列名
     * @param objs                   ：需要写入的对象集合
     * @return
     */
    public static Workbook write(String title, List<String> columsName, List<Object> objs) {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row r = sheet.createRow(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columsName.size() - 1));

        CellStyle cs = wb.createCellStyle();
        cs.setAlignment(CellStyle.ALIGN_CENTER);
        cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        Font font = wb.createFont();
        font.setBold(true);
        font.setFontHeight((short) 25);
        font.setFontHeightInPoints((short) 20);
        cs.setFont(font);

        Cell cell = r.createCell(0);
        cell.setCellValue(title == null ? StaticConfig.EXCELTITLE : title);
        cell.setCellStyle(cs);

        r = sheet.createRow(1);
        for (int i = 0; i < columsName.size(); i++) {
            Cell c = r.createCell(i);
            cs = wb.createCellStyle();
            cs.setAlignment(CellStyle.ALIGN_CENTER);
            cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            font = wb.createFont();
            font.setBold(true);
            cs.setFont(font);
            c.setCellStyle(cs);
            c.setCellValue(CompositeColumnZh.zhMap.get(columsName.get(i).toUpperCase()));
        }

        try {
            for (int i = 0; i < objs.size(); i++) {
                r = sheet.createRow(i + 2);
                for (int j = 0; j < columsName.size(); j++) {
                    Cell c = r.createCell(j);
                    String curCol = columsName.get(j).toLowerCase();
                    Method m = objs.get(i).getClass().getDeclaredMethod("get" + StringUtil.trans2CamelCase(curCol));
                    cs = wb.createCellStyle();
                    cs.setAlignment(CellStyle.ALIGN_CENTER);
                    cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                    c.setCellStyle(cs);
                    c.setCellValue((String) m.invoke(objs.get(i)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wb;
    }
}