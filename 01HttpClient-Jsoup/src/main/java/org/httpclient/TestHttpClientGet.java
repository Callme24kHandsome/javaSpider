package org.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

public class TestHttpClientGet {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //https://www.baidu.com/s?wd=林俊杰
        HttpGet httpGet = new HttpGet("https://www.baidu.com/s?wd=%E6%9E%97%E4%BF%8A%E6%9D%B0");
        //设置请求头UA，模拟浏览器行为
        httpGet.addHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        StatusLine statusLine = response.getStatusLine();
        System.out.println(statusLine.getStatusCode());

        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
        File file = new File("./search.html");
        byte[] bytes = new byte[1024];
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int ch = 0;
        while((ch = is.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,ch);
        }
        is.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        is.close();

//        String responseBody = EntityUtils.toString(entity, "utf-8");
//        File file = new File("./search.html");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        fileOutputStream.write(responseBody.getBytes("utf-8"));
    }
}