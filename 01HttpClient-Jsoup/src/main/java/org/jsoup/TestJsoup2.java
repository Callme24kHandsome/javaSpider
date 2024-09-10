package org.jsoup;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Create: Date:2024年09月10日
 */
public class TestJsoup2 {

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        //https://www.baidu.com/s?wd=林俊杰
        HttpGet httpGet = new HttpGet("https://www.jd.com/?cu=true");
        httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7,ko;q=0.6");
        httpGet.addHeader("Cache-Control", "max-age=0");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("Cookie", "shshshfpa=0d717414-92d6-92ec-4039-abc5f9f7495a-1724252711; shshshfpx=0d717414-92d6-92ec-4039-abc5f9f7495a-1724252711; __jdu=17242527107781676901313; 3AB9D23F7A4B3C9B=KH43M4OFIOYS7W5FVO5IHLBUDMEOYNYELLGXB2T3MDJ5ECI6YQEF7RAOAQGVM2ECEPWI4LHRN4JCNSD6NC7G7APNN4; unpl=JF8EALRnNSttW0xTUUgCThBEH1sAW1kLSh8CPzNQUV5QTFMBSAISGxl7XlVdWBRKHx9ubhRUVVNPUg4bCisSEXteU11bD00VB2xXVgQFDQ8WUUtBSUt-TV9dVlgNQxUGZmYBZG1bS2QFGjIbFBNOXlBdWwhKEQVmZwJSWlBKVAcbACsTIExtZG5ZAE8eA2xXBGRcaAkAWRICHRoSQxBUWF4NSBMAaWcEUltRS1MDHAoaEhJLX2RfbQs; __jdv=229668127|baidu-search|t_262767352_baidusearch|cpc|738944934805_0_266eb1d3ee7e452090aed429665b1888|1725796640231; __jda=76161171.17242527107781676901313.1724252711.1725796640.1725978559.3; __jdc=76161171; o2State={%22webp%22:true%2C%22avif%22:true}; areaId=19; ipLoc-djd=19-1601-0-0; PCSYCityID=CN_440000_440100_0; __jdb=76161171.2.17242527107781676901313|3.1725978559; 3AB9D23F7A4B3CSS=jdd03KH43M4OFIOYS7W5FVO5IHLBUDMEOYNYELLGXB2T3MDJ5ECI6YQEF7RAOAQGVM2ECEPWI4LHRN4JCNSD6NC7G7APNN4AAAAMR3RQ6HGAAAAAADDATYDRJBZA62AX; shshshfpb=BApXSpmVp3_RAh9oEYJF8WPLwwrJCMfiABmZkID5p9xJ1Mps524C2");
        httpGet.addHeader("Referer", "https://cn.bing.com/");
        httpGet.addHeader("Sec-Fetch-Dest", "document");
        httpGet.addHeader("Sec-Fetch-Mode", "navigate");
        httpGet.addHeader("Sec-Fetch-Site", "cross-site");
        httpGet.addHeader("Sec-Fetch-User", "?1");
        httpGet.addHeader("Upgrade-Insecure-Requests", "1");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36");
        httpGet.addHeader("sec-ch-ua", "\"Not)A;Brand\";v=\"99\", \"Google Chrome\";v=\"127\", \"Chromium\";v=\"127\"");
        httpGet.addHeader("sec-ch-ua-mobile", "?0");
        httpGet.addHeader("sec-ch-ua-platform", "\"Windows\"");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String html = EntityUtils.toString(response.getEntity(), "utf-8");

        Document document = Jsoup.parse(html);
        Elements select = document.select("#navitems-group1");
        System.out.println(html);
        File file = new File("jd.html");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(html.getBytes("utf-8"));
        System.out.println(select.stream().map(e -> e.text()).collect(Collectors.toList()));
        response.close();
    }
}