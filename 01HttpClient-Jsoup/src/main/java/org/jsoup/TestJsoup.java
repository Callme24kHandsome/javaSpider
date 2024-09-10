package org.jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Create: Date:2024年09月10日
 */
public class TestJsoup {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.jd.com/?cu=true");
        Document document = Jsoup.parse(url, 5000);
        Elements elements = document.getElementsByTag("title");
        System.out.println(elements.get(0).text());

        Elements liElements = document.getElementById("navitems-group1").getElementsByTag("li");
        System.out.println(liElements.stream().map(e -> e.text()).collect(Collectors.toList()));

        Elements select = document.select("#navitems-group1");
        System.out.println(select.stream().map(e -> e.text()).collect(Collectors.toList()));

    }
}