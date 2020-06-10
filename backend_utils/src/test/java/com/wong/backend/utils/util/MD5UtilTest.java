package com.wong.backend.utils.util; 

import org.junit.jupiter.api.Test;


/** 
* MD5Util Tester. 
* 
* @author <Authors name> 
* @since <pre>06/02/2020</pre> 
* @version 1.0 
*/ 
public class MD5UtilTest {
    @Test
    public void testEncrypt() throws Exception {
        System.out.println(MD5Util.encrypt("11111111"));

    }


} 
