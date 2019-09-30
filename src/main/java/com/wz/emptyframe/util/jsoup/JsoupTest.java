package com.wz.emptyframe.util.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author ta0546 wz
 * @time 2019/9/30
 */
public class JsoupTest {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("http://news.baidu.com/sports").get();
        Elements elements = doc.getElementsByClass("tab-box");

        for (Element element : elements) {
            //String linkText = element.text();
            System.out.println(element.select("a[title]"));
        }

    }

}
