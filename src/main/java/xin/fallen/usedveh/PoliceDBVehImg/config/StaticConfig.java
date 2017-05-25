package xin.fallen.usedveh.PoliceDBVehImg.config;

import xin.fallen.usedveh.PoliceDBVehImg.annotation.Alias;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 20:50
 * Usage:
 */
public class StaticConfig {

    @Alias("table_name")
    public static String TABLENAME;

    @Alias("columns_name")
    public static String COLUMNSNAME;

    @Alias("primary_key")
    public static String PRIMARYKEY;

    @Alias("excel_title")
    public static String EXCELTITLE;

    @Alias("excel_gen_path")
    public static String EXCELGENPATH;

    public static Object objX;
}