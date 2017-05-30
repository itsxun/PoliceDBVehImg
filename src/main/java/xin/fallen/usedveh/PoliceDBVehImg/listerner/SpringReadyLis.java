package xin.fallen.usedveh.PoliceDBVehImg.listerner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import xin.fallen.usedveh.PoliceDBVehImg.config.CompositeColumnZh;
import xin.fallen.usedveh.PoliceDBVehImg.config.StaticConfig;
import xin.fallen.usedveh.PoliceDBVehImg.util.BeanBuilder;
import xin.fallen.usedveh.PoliceDBVehImg.util.ConfigLoader;
import xin.fallen.usedveh.PoliceDBVehImg.util.FileFinder;

import java.io.File;
import java.util.Arrays;

/**
 * Author: fallen
 * Date: 17-2-14
 * Time: 上午9:45
 * Usage:
 */
public class SpringReadyLis implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger log = LoggerFactory.getLogger("logger");

    public void onApplicationEvent(ContextRefreshedEvent e) {
        ConfigLoader.load(new File("D:\\git\\PoliceDBVehImg\\src\\main\\resources\\config.xml"), StaticConfig.class);
//        ConfigLoader.load(FileFinder.find("config.xml"), StaticConfig.class);
        CompositeColumnZh.zhInit();
        StaticConfig.objX = BeanBuilder.build(Arrays.asList(StaticConfig.COLUMNSNAME.split(",")));
        log.info("<==========================Config Load Complete==========================>");
    }
}