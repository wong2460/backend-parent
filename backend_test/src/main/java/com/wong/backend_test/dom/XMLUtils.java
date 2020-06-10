package com.wong.backend_test.dom;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.util.*;

public class XMLUtils  {
    /**
     * 将String类型的xml转换成map
     * @param xml
     * @return
     */
    public static Map<String,Object> xml2Map(String xml){
        Map<String, Object> map= new HashMap<>();
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new ByteArrayInputStream(xml.getBytes()));
            map = Dom2Map(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 将Document对象转为Map（String→Document→Map）
     * @param doc
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, Object> Dom2Map(Document doc){
        Map<String, Object> map = new HashMap<>();
        if(doc == null) {
            return map;
        }
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            System.out.println(e.getName());
            List list = e.elements();
            if(list.size() > 0){
                map.put(e.getName(), Ele2Map(e));
            }else {
                map.put(e.getName(), e.getText());
            }
        }
        return map;
    }
    /**
     * 将Element对象转为Map（String→Document→Element→Map）
     * @param e
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Map<String, Object> Ele2Map(Element e){
        Map<String, Object> map = new HashMap<String, Object>();
        List list = e.elements();
        if(list.size() > 0){
            for (int i = 0;i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List<Object> mapList = new ArrayList<Object>();
                if(iter.elements().size() > 0){
                    Map<String, Object> m = Ele2Map(iter);
                    if(map.get(iter.getName()) != null){
                        Object obj = map.get(iter.getName());
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){
                            mapList = new ArrayList<Object>();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if(obj.getClass().getName().equals("java.util.ArrayList")){
                            mapList = (List<Object>) obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    }else {
                        map.put(iter.getName(), m);
                    }
                }
                else{
                    if(map.get(iter.getName()) != null){
                        Object obj = map.get(iter.getName());
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){
                            mapList = new ArrayList<Object>();
                            mapList.add(obj);
                            mapList.add(iter.getText());
                        }
                        if(obj.getClass().getName().equals("java.util.ArrayList")){
                            mapList = (List<Object>) obj;
                            mapList.add(iter.getText());
                        }
                        map.put(iter.getName(), mapList);
                    }else {
                        map.put(iter.getName(), iter.getText());//公共map resultCode=0
                    }
                }
            }
        }else {
            map.put(e.getName(), e.getText());
        }
        return map;
    }


}
