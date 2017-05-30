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
    public String dynamicSqlBuilder(@Param("columnsName")final String[] columnsName, @Param("tableName") final String tableName,@Param("pks") final String[] primaryKey) {
        SQL sql = new SQL() {{
            for (String s : columnsName) {
                SELECT(s);
            }
            FROM(tableName);
            WHERE(StaticConfig.PRIMARYKEY + " in " + array2String(primaryKey));
        }};
        System.out.println("生成的动态SQL为："+sql.toString());
        return sql.toString();
    }

    public static String array2String(String[] strs) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (String s : strs) {
            sb.append("'").append(s).append("',");
        }
        return sb.deleteCharAt(sb.length() - 1).append(")").toString();
    }
}