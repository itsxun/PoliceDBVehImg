package xin.fallen.usedveh.PoliceDBVehImg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xin.fallen.usedveh.PoliceDBVehImg.domain.VehImg;

import java.util.ArrayList;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 10:55
 * Usage:
 */
@Mapper
public interface VehImgDao {

    @Select("select xh,hpzl,hphm,zp,gxsj from VEH_PICTURE where hpzl=#{hpzl} and hphm=#{hphm}")
    ArrayList<VehImg> selectByHpzlAndHphm(@Param("hpzl") String hpzl, @Param("hphm") String hphm);

    @Select("select * from dual")
    String ping();
}