package xin.fallen.usedveh.PoliceDBVehImg.domain;

import java.util.Date;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 10:52
 * Usage:
 */
public class VehImg {
//    xh,hpzl,hphm,zp,gxsj

    private String xh;
    private String hpzl;
    private String hphm;
    private byte[] zp;
    private Date gxsj;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl;
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm;
    }

    public byte[] getZp() {
        return zp;
    }

    public void setZp(byte[] zp) {
        this.zp = zp;
    }

    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }
}
