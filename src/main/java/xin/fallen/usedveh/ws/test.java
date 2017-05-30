//package xin.fallen.ws;
//
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import xin.fallen.usedveh.PoliceDBVehImg.util.HttpUtil;
//
//import java.io.IOException;
//
///**
// * Author: Fallen
// * Date: 2017/5/25
// * Time: 18:07
// * Usage:
// */
//public class test {
//    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">" +
//                "   <soapenv:Header/>" +
//                "   <soapenv:Body>" +
//                "      <tem:GetExaminePhoto1>" +
//                "         <!--Optional:-->" +
//                "         <tem:plateType>01</tem:plateType>" +
//                "         <!--Optional:-->" +
//                "         <tem:plateNo>EU7793</tem:plateNo>" +
//                "      </tem:GetExaminePhoto1>" +
//                "   </soapenv:Body>" +
//                "</soapenv:Envelope>");
//
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        //WSDL地址
//        HttpPost httppost = new HttpPost("http://10.35.139.118:8084/CTService2.asmx?wsdl");
//        httppost.setHeader("user-agent","mozilla/4.0");
//        httppost.setHeader("Content-Type", "text/xml; charset=utf-8");
//        StringEntity entity = new StringEntity(sb.toString(),"utf-8");
//        httppost.setEntity(entity);
//
//        try {
//            CloseableHttpResponse result = httpclient.execute(httppost);
//            String resData = EntityUtils.toString(result.getEntity());
//            System.out.println(resData);
//            result.close();
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            httpclient.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}