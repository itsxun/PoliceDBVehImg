package xin.fallen.usedveh.PoliceDBVehImg.config;

import org.apache.ibatis.jdbc.SQL;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 21:01
 * Usage:
 */
public class SqlBuilder {
    public String dynamicSqlBuilder(final String[] columnsName,final  String tableName,final String[] primaryKey) {
        return new SQL(){{
            SELECT(columnsName);
            FROM(tableName);
            WHERE(StaticConfig.PRIMARYKEY+" in "+array2String(primaryKey));
        }}.toString();
    }

    public static String array2String(String[] strs){
        StringBuilder sb=new StringBuilder();
        sb.append("(");
        for(String s :strs){
            sb.append("\"").append(s).append("\",");
        }
     return sb.deleteCharAt(sb.length()-1).append(")").toString();
    }
}