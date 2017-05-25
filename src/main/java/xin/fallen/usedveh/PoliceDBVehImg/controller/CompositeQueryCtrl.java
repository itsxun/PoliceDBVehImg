package xin.fallen.usedveh.PoliceDBVehImg.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.fallen.usedveh.PoliceDBVehImg.config.StaticConfig;
import xin.fallen.usedveh.PoliceDBVehImg.mapper.CompositeQuery;
import xin.fallen.usedveh.PoliceDBVehImg.util.JsonResultUtil;
import xin.fallen.usedveh.PoliceDBVehImg.util.XlsxWriter;
import xin.fallen.usedveh.PoliceDBVehImg.vo.JsonResult;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
    private Logger log= LoggerFactory.getLogger(this.getClass());

    @Resource
    private CompositeQuery compositeQuery;

    @RequestMapping("/excel-export")
    public JsonResult excelExport(String[] rowNums, String title, String[] cellNames) {
        List<Object> objs = compositeQuery.fuzzySelect(cellNames == null ? StaticConfig.COLUMNSNAME.split(",") : cellNames, StaticConfig.TABLENAME, rowNums);

        Workbook wb = XlsxWriter.write(title, cellNames == null ? Arrays.asList(StaticConfig.COLUMNSNAME.split(",")) : Arrays.asList(cellNames), objs);

        if(wb==null){
            return JsonResultUtil.resDispatcher("文件生成异常",0);
        }
        Date date = new Date();
        File file = new File(StaticConfig.EXCELGENPATH + File.separator + sdf.format(date));
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        file = new File(file + File.separator + UUID.randomUUID().toString() + ".xlsx");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
                wb.write(out);
        } catch (Exception e) {
            return null;
        } finally {
            if (out != null) {
                try {
                    out.close();
                    wb.close();
                } catch (IOException e) {
                }
            }
        }
        return JsonResultUtil.resDispatcher(file.getAbsolutePath(),1);
    }
}
