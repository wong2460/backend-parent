package com.wong.backend_test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JsoupTest {

    public static void main(String[] args) throws IOException {
        // write your code here

        String strUrl = "http://www.szse.cn/disclosure/index.html";
        Document document = Jsoup.connect(strUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0")
                    .get();
        System.out.println(document);
        Elements elements = document.select("div.box.item");
        for(Element element : elements) {
            Elements eleUrl = element.select("div.box-aw a");
            String strPrjUrl = eleUrl.attr("href");
            System.out.println(strPrjUrl);
            Elements eleTitle = eleUrl.select(".title");
            System.out.println(eleTitle);
            Elements eleSummary = eleUrl.select(".summary");
            String strSummary = eleSummary.text();
            System.out.println(strSummary);
        }
    }

}
