package com.wong.backend_test.dom;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Map;

/**
* XMLUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>06/09/2020</pre> 
* @version 1.0 
*/ 
public class XMLUtilsTest {
    String str3= "<IFSDATA>	"
            + "<zipCode>压缩方式，0-不压缩；1-压缩</zipCode>"
            + "<encryptCode>加密方式 预留</encryptCode>"
            + "<CACode>CA类型 预留</CACode>"
            + "<content>"
            + "<organ_id>182724166657290283</organ_id>"
            + "<holding_id>434037446358218657 </holding_id>"
            + "<format_id> 330601</format_id>"
            + "<bc_date>201801 </bc_date>"
            + "<normal_count>1 </normal_count>"
            + "<cancel_count>1 </cancel_count>"
            + "<normal_amount> 1.00</normal_amount>"
            + "<cancel_amount>1.00 </cancel_amount>"
            + "<status> 0</status>"
            + "</content>"
            + "</IFSDATA>";
    String str4="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "<ssss>"
            + "<orderOffer>"
            + "<offer>"
            + "<offerSpecName>980010992)商务助手（OCS）30元</offerSpecName>"
            + "<offerId>105000808918</offerId>"
            + "<startDt>2012-11-27 16:48:12</startDt>"
            + "<endDt>3000-1-1 0:00:00</endDt>"
            + "<offerSpecId>980010992</offerSpecId>"
            + "<params>"
            + "<param>"
            + "<itemSpecId>5030</itemSpecId>"
            + "<offerParamId>101000048281</offerParamId>"
            + "<value>CDMA预付费</value>"
            + "<itemSpecName>计费区分</itemSpecName>"
            + "</param>"
            + "<param>"
            + "<itemSpecId>5031</itemSpecId>"
            + "<offerParamId>101000048282</offerParamId>"
            + "<value>天翼商话</value>"
            + "<itemSpecName>经分区分</itemSpecName>"
            + "</param>"
            + "</params>"
            + "</offer>"
            + "</orderOffer>"
            + "<saleOffer>"
            + "<categoryNode>"
            + "<offer>"
            + "<summary>待定...</summary>"
            + "<name>(980001995)商务助手（OCS）201209版-30元</name>"
            + "<id>980001995</id>"
            + "</offer>"
            + "<offer>"
            + "<summary>待定...</summary>"
            + "<name>(980001996)商务助手（OCS）201209版-50元</name>"
            + "<id>980001996</id>"
            + "</offer>"
            + "<offer>"
            + "<summary>待定...</summary>"
            + "<name>(980001997)商务助手（OCS）201209版-80元</name>"
            + "<id>980001997</id>"
            + "</offer>"
            + "<offer>"
            + "<summary>待定...</summary>"
            + "<name>(980010993)商务助手（OCS）50元</name>"
            + "<id>980010993</id>"
            + "</offer>"
            + "</categoryNode>"
            + "</saleOffer>"
            + "<resultCode>0</resultCode>"
            + "<resultMsg>成功</resultMsg>"
            + "</ssss>";
    
    /**
    * 
    * Method: xml2Map(String xml) 
    * 
    */ 
    @Test
    public void testXml2Map() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document;
        try {
            document = saxReader.read(new ByteArrayInputStream(str3.toString().getBytes()));
            Map<String ,Object> map = XMLUtils.Dom2Map(document);

            System.out.println("map>>> " + map);
        }catch (DocumentException e){
            e.printStackTrace();
        }
    } 

    } 
