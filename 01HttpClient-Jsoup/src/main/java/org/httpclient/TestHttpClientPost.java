package org.httpclient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class TestHttpClientPost {
    public static void main(String[] args) throws IOException {
        String searchWord = "爬虫";
        String defaultReqBody = "{\n" +
                "    \"from\": \"zh\",\n" +
                "    \"to\": \"en\",\n" +
                "    \"reference\": \"\",\n" +
                "    \"corpusIds\": [\n" +
                "        \n" +
                "    ],\n" +
                "    \"qcSettings\": [\n" +
                "        \"1\",\n" +
                "        \"2\",\n" +
                "        \"3\",\n" +
                "        \"4\",\n" +
                "        \"5\",\n" +
                "        \"6\",\n" +
                "        \"7\",\n" +
                "        \"8\",\n" +
                "        \"9\",\n" +
                "        \"10\",\n" +
                "        \"11\"\n" +
                "    ],\n" +
                "    \"needPhonetic\": false,\n" +
                "    \"domain\": \"common\",\n" +
                "    \"milliTimestamp\": 1725808602840\n" +
                "}";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //https://www.baidu.com/s?wd=林俊杰 表单方式
//        HttpPost httpPost = new HttpPost("https://fanyi.baidu.com/sug");
//        List<BasicNameValuePair> formData = Arrays.asList(new BasicNameValuePair("kw", searchWord));
//        httpPost.setEntity(new UrlEncodedFormEntity(formData));
        HttpPost httpPost = new HttpPost("https://fanyi.baidu.com/ait/text/translate");
        JSONObject params =  JSONObject.parseObject(defaultReqBody);
        params.put("query",searchWord);
        params.put("milliTimestamp",System.currentTimeMillis());
        httpPost.setEntity(new StringEntity(params.toString(),"UTF-8"));
        httpPost.addHeader("Content-Type", "application/json");




        System.out.println(params);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println(result);
        response.close();
        httpClient.close();
    }
}