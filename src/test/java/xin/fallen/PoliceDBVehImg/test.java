package xin.fallen.PoliceDBVehImg;

import xin.fallen.usedveh.PoliceDBVehImg.config.CompositeColumnZh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 22:39
 * Usage:
 */
public class test {
    public static void main(String[] args) throws Exception {
//        TestBean bean = new TestBean();
//        bean.setAge(12);
//        bean.setName("fucker");
//
//        Field[] fields = bean.getClass().getFields();
//        for (Field f : fields) {
//            f.setAccessible(true);
//            String s = (String) f.get(bean);
//            System.out.println(f.getName()+"："+s);
//        }
        String s ="JYLSH,HPHM,DJRID1,DJR1,DJRQ1,DJBM1,DJRID2,DJR2,DJRQ2,DJBM2,TJRID,TJR,TJRQ,QRRID,QRR,QRRQ,SCSHYJ,SHRID,SHR,SHRQ,SHBM,SHYJ,SHCS,TBRID,TBR,TBRQ,TBYY,TBCS,SFYJ,ZRDHBYQ,HGZHBYQ,JLZT,JYZT";
        System.out.println(s.toLowerCase().replace(",",";"));
    }
}
