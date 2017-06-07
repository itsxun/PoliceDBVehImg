package xin.fallen.usedveh.PoliceDBVehImg.config;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 21:01
 * Usage:
 */
public class SqlBuilder {
    public String dynamicSqlBuilder(@Param("columnsName") final String columnsName, @Param("tableName") final String tableName, @Param("pks") final String[] primaryKey) {
        return new SQL() {{
            SELECT(columnsName);
            FROM(tableName);
            WHERE(StaticConfig.PRIMARYKEY + " in " + array2String(primaryKey));
        }}.toString();
    }

    public static String array2String(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "('20170602100000636','20170606100000639','20170606100000640','20170602100000626','20170602100000627')";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (String s : strs) {
            sb.append("'").append(s).append("',");
        }
        return sb.deleteCharAt(sb.length() - 1).append(")").toString();
    }
}