package xin.fallen.usedveh.PoliceDBVehImg.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.fallen.usedveh.PoliceDBVehImg.config.StaticConfig;
import xin.fallen.usedveh.PoliceDBVehImg.mapper.ExcelExport.CompositeQueryMapper;
import xin.fallen.usedveh.PoliceDBVehImg.util.XlsxWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 21:24
 * Usage:不写service层了，逻辑堆在controller里面
 */
@RestController
@RequestMapping
public class CompositeQueryCtrl {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CompositeQueryMapper compositeQueryMapper;

    @RequestMapping("/excel-export")
    public void excelExport(String cellKeys, String[] rowNums, String title, HttpServletResponse resp) {
        if (cellKeys == null || cellKeys.length() == 0) {
            cellKeys = StaticConfig.COLUMNSKEY;
        }

        List list = compositeQueryMapper.fuzzySelect(cellKeys, StaticConfig.TABLENAME, rowNums);
        Workbook wb = XlsxWriter.write(title, cellKeys.equalsIgnoreCase(StaticConfig.COLUMNSKEY) ? Arrays.asList(StaticConfig.COLUMNSNAME.split(",")) : Arrays.asList(cellKeys), list);
        if (wb == null) {
            log.error("excel文件生成异常");
            try {
                resp.getWriter().write("excel文件生成异常");
            } catch (IOException e) {
            }
        }
        resp.setHeader("content-disposition", "attachment;filename=" + UUID.randomUUID().toString() + ".xlsx");
        OutputStream out = null;
        try {
            out = resp.getOutputStream();
            wb.write(out);
        } catch (Exception e) {
            log.error("excel内容写入文件失败");
            try {
                resp.getWriter().write("excel写入流失败");
            } catch (IOException e1) {
            }
        }
    }
}