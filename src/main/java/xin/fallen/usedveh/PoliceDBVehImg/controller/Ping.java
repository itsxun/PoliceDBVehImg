package xin.fallen.usedveh.PoliceDBVehImg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Fallen
 * Date: 2017/6/3
 * Time: 21:17
 * Usage:
 */
@RestController
public class Ping {
    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }
}
