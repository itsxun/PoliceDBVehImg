package xin.fallen.usedveh.PoliceDBVehImg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import xin.fallen.usedveh.PoliceDBVehImg.config.SqlBuilder;

import java.util.List;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 20:43
 * Usage:
 */
@Mapper
public interface CompositeQuery {

    @SelectProvider(type = SqlBuilder.class, method ="")
    List<Object> fuzzySelect(@Param("columnsName") String[] columnsName, @Param("tableName")String tableName,@Param("pk")String[] primaryKey);
}