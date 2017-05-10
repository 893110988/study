package wmm.javaframe.selenium;


import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * Created by wangmm on 2017/2/14.
 */
public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Cookie", "route=7317c4b93b94800f61ea7f54b5887351; .AspNet.ApplicationCookie=VpbwAsf2-hjyYGU4InJO1yXAJ9cKELr7RPdzxOU05Ns2e1bi_nKYgju3eE1rrq2SJULif9Ir9UPhvzWBNw_IZH-S1Y-cbDOGVTCnjY3i8UFGpTxObAk9oRKTftRaXL1zc_F__NsZfSigk9L-AnE-WL46n5WOEuGzLxfgwNKM5HiVsOTcp73NjG-l_nUmGitRIHejp1a-DV6e2FhrBYIGYaiVwLQzGL8t377dWwQ6yYQggVfkab-6YdJpmwF6iEMOZmRYLyGqEi3at7Y2tN8cJ40BONITeximiKWzy21Byjj5Q5I_bnLV2i3Qe3aaAi5JHiW33FcX3-Pxg-bOWJo2vvhuXJu9hWHCpTgo1Rpx_QiZxqgLopPc1JMRWbYEW45eDwmPMnPjknDBlt1F2wvLK7XCcNRS0Ir8wmRGFarSZ_pGNLKDA7Rlt5Psl2YubuJ-YISPjw0X53hbAq7QILMRwgbKaKBkduvAiHkMlAscqzfNeWYDt86o6Z1cluu_FFD9Rg0XrQY6jMlvQTgNZFWFHGmkeZUW6uMI-W-WB7hu7vxZ77BiK66cD9usrbs0KS6bcjyUgVE8pNRSxMb8eLu29w; __RequestVerificationToken=bR2QJPYAcCdSL-OWQ4bVFcH5n-DjX26c-2BKh80nIvAYN5f9WLZbDc5DmNucCRVIGXbovJARRmjc-ncPGx5TNxJAqDxyAWapr-p9cmOQSvM1");

            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("Cookie", "route=7317c4b93b94800f61ea7f54b5887351; .AspNet.ApplicationCookie=VpbwAsf2-hjyYGU4InJO1yXAJ9cKELr7RPdzxOU05Ns2e1bi_nKYgju3eE1rrq2SJULif9Ir9UPhvzWBNw_IZH-S1Y-cbDOGVTCnjY3i8UFGpTxObAk9oRKTftRaXL1zc_F__NsZfSigk9L-AnE-WL46n5WOEuGzLxfgwNKM5HiVsOTcp73NjG-l_nUmGitRIHejp1a-DV6e2FhrBYIGYaiVwLQzGL8t377dWwQ6yYQggVfkab-6YdJpmwF6iEMOZmRYLyGqEi3at7Y2tN8cJ40BONITeximiKWzy21Byjj5Q5I_bnLV2i3Qe3aaAi5JHiW33FcX3-Pxg-bOWJo2vvhuXJu9hWHCpTgo1Rpx_QiZxqgLopPc1JMRWbYEW45eDwmPMnPjknDBlt1F2wvLK7XCcNRS0Ir8wmRGFarSZ_pGNLKDA7Rlt5Psl2YubuJ-YISPjw0X53hbAq7QILMRwgbKaKBkduvAiHkMlAscqzfNeWYDt86o6Z1cluu_FFD9Rg0XrQY6jMlvQTgNZFWFHGmkeZUW6uMI-W-WB7hu7vxZ77BiK66cD9usrbs0KS6bcjyUgVE8pNRSxMb8eLu29w; __RequestVerificationToken=bR2QJPYAcCdSL-OWQ4bVFcH5n-DjX26c-2BKh80nIvAYN5f9WLZbDc5DmNucCRVIGXbovJARRmjc-ncPGx5TNxJAqDxyAWapr-p9cmOQSvM1");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException {


        String result=sendGet("https://shop.48.cn/TOrder/tickCheck","id=698&"+Math.random());
        String result1=sendPost("https://shop.48.cn/TOrder/add","id=698&num=1&seattype=3&brand_id=1&r="+Math.random());
        System.out.println(result);
       System.out.println(result1);
        //System.out.println(LocalDateTime.now().getHour()==16);
       /* while (true){
            if(LocalDateTime.now().getHour()==20){
                String result=sendPost("https://shop.48.cn/TOrder/add","id=698&num=1&seattype=3&brand_id=1&r="+Math.random());
                HashMap hashMap = JSONObject.parseObject(result, HashMap.class);
       System.out.println(result);
                if (hashMap.get("Message").equals("success")) {
                    System.out.println(result);

                }
                sleep(100);
                break;
            }
            sleep(10);
        }*/

    }
}
