//package com.sunpeng.flowrate.common;
//
//
//import org.apache.http.util.EntityUtils;
//
//public class HttpClient {
//
//
//    public String doGet(String url) throws Exception {
//        // 声明 http get 请求
//        HttpGet httpGet = new HttpGet(url);
//
//        // 装载配置信息
//        httpGet.setConfig(config);
//
//        // 发起请求
//        CloseableHttpResponse response = this.httpClient.execute(httpGet);
//
//        // 判断状态码是否为200
//        if (response.getStatusLine().getStatusCode() == 200) {
//            // 返回响应体的内容
//            return EntityUtils.toString(response.getEntity(), "UTF-8");
//        }
//        return null;
//    }
//
//
//}
