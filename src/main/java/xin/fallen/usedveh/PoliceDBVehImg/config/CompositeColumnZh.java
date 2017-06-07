package xin.fallen.usedveh.PoliceDBVehImg.config;


import java.io.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * Author: Fallen
 * Date: 2017/5/30
 * Time: 19:10
 * Usage:
 */
public class CompositeColumnZh {
    public static HashMap<String, String> zhMap;

    public static boolean zhInit() {
        Properties prop = new Properties();
        try {
//            prop.load(new InputStreamReader(new FileInputStream(FileFinder.find("zh.properties")),"gbk"));
            prop.load(new InputStreamReader(new FileInputStream(new File("D:\\git\\PoliceDBVehImg\\src\\main\\resources\\zh.properties")),"gbk"));
        } catch (IOException e) {
            return false;
        }
        zhMap = new HashMap<>(prop.size());
        for (String s : prop.stringPropertyNames()) {
            zhMap.put(s, prop.getProperty(s));
        }
        return true;
    }
}