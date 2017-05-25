package xin.fallen.usedveh.PoliceDBVehImg.util;

import org.springframework.cglib.beans.BeanGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 21:10
 * Usage:
 */
public class BeanBuilder {
    public static Object build(List<String> params){
        Map<String, Class<?>> map = new HashMap<>(params.size());
        for (String s : params) {
            map.put(s, String.class);
        }
        BeanGenerator generator = new BeanGenerator();
        BeanGenerator.addProperties(generator, map);
        return generator.create();
    }
}
