package com.sunpeng.flowrate.common;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@Slf4j
public  class HttpClientUtil {


    public static void doGet(String url) throws Exception {


        log.info(url);
        url="http://www.baidu.com";


        //1.使用默认的配置的httpclient
        CloseableHttpClient client = HttpClients.createDefault();
        //2.使用get方法
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            //3.执行请求，获取响应
            response = client.execute(httpGet);

            //4.获取状态码
            int code = response.getStatusLine().getStatusCode();
            if (code == 200){
                log.info("请求成功");
            }else{
                log.info("请求失败");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }

      }


}
