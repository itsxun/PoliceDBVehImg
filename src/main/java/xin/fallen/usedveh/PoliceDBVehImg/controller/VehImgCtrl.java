package xin.fallen.usedveh.PoliceDBVehImg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.fallen.usedveh.PoliceDBVehImg.domain.VehImg;
import xin.fallen.usedveh.PoliceDBVehImg.mapper.VehImgDao;
import xin.fallen.usedveh.PoliceDBVehImg.util.Base64Util;
import xin.fallen.usedveh.PoliceDBVehImg.util.JsonResultUtil;
import xin.fallen.usedveh.PoliceDBVehImg.vo.JsonResult;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
    private VehImgDao vehImgDao;

    @RequestMapping("/ping")
    public String ping(){
        return vehImgDao.ping();
    }

    @RequestMapping("/pic")
    public JsonResult getZpByHpzlAndHphm(String hpzl, String hphm){
        if(hpzl == null || hphm == null){
            return JsonResultUtil.resDispatcher("请填写正确的号牌种类和号牌号码",0);
        }
        ArrayList<VehImg> list=vehImgDao.selectByHpzlAndHphm(hpzl,hphm);
       ArrayList<String> res=new ArrayList<>(list.size());
       for(VehImg v:list){
           res.add("data:image/png;base64,"+Base64Util.encode(v.getZp()));
       }
       list=null;
        return JsonResultUtil.resDispatcher(res);
   }
}
