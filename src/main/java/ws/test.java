package ws;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 18:07
 * Usage:
 */
public class test {
    public static void main(String[] args) {
        CTService2 ctService2=new CTService2();
        CTService2Soap port=ctService2.getCTService2Soap();
        String res=port.getExaminePhoto1("01","ESS997");
        System.out.println(res);
    }
}