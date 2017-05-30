package xin.fallen.usedveh.PoliceDBVehImg.controller;

import com.google.gson.Gson;
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
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CompositeQuery compositeQuery;

    @RequestMapping("/excel-export")
    public JsonResult excelExport(String[] cellNames, String[] rowNums, String title) {
        if (cellNames == null || cellNames.length == 0) {
            cellNames = StaticConfig.COLUMNSNAME.split(",");
        }

        List depts = compositeQuery.fuzzySelect(cellNames, StaticConfig.TABLENAME, rowNums == null || rowNums.length == 0 ? new String[]{"SB029", "SB030", "SB031"} : rowNums);

        Workbook wb = XlsxWriter.write(title, cellNames == null ? Arrays.asList(StaticConfig.COLUMNSNAME.split(",")) : Arrays.asList(cellNames), depts);
        if (wb == null) {
            log.error("excel文件生成异常");
            return JsonResultUtil.resDispatcher("excel文件生成异常", 0);
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
            log.error("excel内容写入文件失败");
            return JsonResultUtil.resDispatcher("excel内容写入文件失败", 0);
        } finally {
            if (out != null) {
                try {
                    out.close();
                    wb.close();
                } catch (IOException e) {
                }
            }
        }
        return JsonResultUtil.resDispatcher(file.getAbsolutePath(), 1);
    }
}
