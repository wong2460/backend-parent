package com.wong.backend_test.jsoup;

import com.alibaba.fastjson.JSON;
import com.wong.backend_test.jsoup.dao.WebPage;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XueqiuSpider {
    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();
        WebPage webPage = null;
        String fcode = "600271";
        String url  = "https://xueqiu.com/service/screener/screen?category=CN&exchange=sh_sz&areacode=&indcode=&order_by=symbol&order=desc&page=1&size=30&only_count=0&current=&pct=&mc=0_1856876599434&total_revenue.20200331=-555314546.63_555502000000&pct120=-82.76_1319.2&_=1591523756573";
        Connection connection = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0")
                .timeout(8000)
                .method(Connection.Method.GET);
        Map<String,String> cookies = new HashMap<>();
        cookies.put("xq_a_token", "cadf0345f20c5318cea1f8ab385425f7171edf24");
        cookies.put("xqat","cadf0345f20c5318cea1f8ab385425f7171edf24");
        connection.cookies(cookies);
        Connection.Response response = connection.execute();
        Document document = response.parse();
        System.out.println(document);
        webPage = new WebPage(
                System.currentTimeMillis() - start,
                url,
                document,
                document.html(),
                response.statusCode()
        );
        System.out.println(JSON.toJSONString(webPage,true));

    }

}
