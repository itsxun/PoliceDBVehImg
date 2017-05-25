package we;

/**
 * Author: Fallen
 * Date: 2017/5/25
 * Time: 18:28
 * Usage:
 */
public class test {
    public static void main(String[] args) {
        GlobalWeather service=new GlobalWeather();
        String res=service.getGlobalWeatherSoap().getWeather("Dalian","china");
        System.out.println(res);
    }
}
