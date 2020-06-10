package com.wong.backend_test.jsoup.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;

import java.io.Serializable;

/**
 * @author wong
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WebPage implements Serializable {
    private Long jobDoneTime;
    private String pageUrl;
    private Document document;
    private String html;
    private Integer httpCode;
}
