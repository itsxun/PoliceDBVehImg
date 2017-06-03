package xin.fallen.usedveh.PoliceDBVehImg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xin.fallen.usedveh.PoliceDBVehImg.config.StaticConfig;
import xin.fallen.usedveh.PoliceDBVehImg.domain.VehImg;
import xin.fallen.usedveh.PoliceDBVehImg.mapper.ExcelExport.CompositeQueryMapper;
import xin.fallen.usedveh.PoliceDBVehImg.mapper.VehImage.VehImgMapper;
import xin.fallen.usedveh.PoliceDBVehImg.util.Base64Util;
import xin.fallen.usedveh.PoliceDBVehImg.util.HttpUtil;
import xin.fallen.usedveh.PoliceDBVehImg.util.JsonResultUtil;
import xin.fallen.usedveh.PoliceDBVehImg.vo.JsonResult;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 11:04
 * Usage:
 */
@RestController
public class VehImgCtrl {
    @Resource
    private VehImgMapper vehImgDao;

    @RequestMapping("/veh-examine-pic")
    public JsonResult getZpByHpzlAndHphm(String hpzl, String hphm) {
        if (hpzl == null || hphm == null) {
            return JsonResultUtil.resDispatcher("请填写正确的号牌种类和号牌号码", 0);
        }
        ArrayList<VehImg> list = vehImgDao.selectByHpzlAndHphm(hpzl, hphm);
        ArrayList<String> res = new ArrayList<>(list.size());
        for (VehImg v : list) {
            res.add("data:image/png;base64," + Base64Util.encode(v.getZp()));
        }
        list = null;
        return JsonResultUtil.resDispatcher(res);
    }

    @RequestMapping("/police-db-pic")
    public JsonResult getZpByHpzlAndHphmInPoliceDB(String hpzl, String hphm, String token) {
        if (hpzl == null || hphm == null) {
            return JsonResultUtil.resDispatcher("请填写正确的号牌种类和号牌号码", 0);
        }
        String res = HttpUtil.post(StaticConfig.WSDLREQUSETURL, StaticConfig.WSDLREQUESTBODY.replace("{HPZL}", hpzl).replace("{HPHM}", hphm));
        if ("".equals(res)) {
            return JsonResultUtil.resDispatcher(0);
        }
        try {
            res = res.substring(res.indexOf("<GetExaminePhoto1Result>") + 24, res.indexOf("</GetExaminePhoto1Result>"));
        } catch (Exception e) {
            return JsonResultUtil.resDispatcher("未找到相关照片", 1);
        }
        return JsonResultUtil.resDispatcher(res.split(","));
    }
}