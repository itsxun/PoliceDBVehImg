package xin.fallen.PoliceDBVehImg;

import xin.fallen.usedveh.PoliceDBVehImg.config.SqlBuilder;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 22:39
 * Usage:
 */
public class test {
    public static void main(String[] args) {
        String[] strs=new String[3];
        strs[0]="scott";
        strs[1]="sys";
        strs[2]="system";
        System.out.println(SqlBuilder.array2String(strs));
    }
}
