package com.fafukeji.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * 地址类
 */
public class UrlUtils {
	
    /**
     * 获取host地址
     * @param request
     * @return
     */
    public static String getUrlHost(HttpServletRequest request){
    	URL requestUrl;
	    try {
	        requestUrl = new URL(request.getRequestURL().toString());
	        return requestUrl.getHost();
	        
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	    return "";
    }
    
    /**
     * 获取端口号
     * @param request
     * @return
     */
    public static int getUrlPort(HttpServletRequest request){
    	URL requestUrl;
	    try {
	        requestUrl = new URL(request.getRequestURL().toString());
	        return requestUrl.getPort();
	        
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	    return 80;
    }
    
    public static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }
    
    public static String urlEncodeUTF8(Map<?,?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?,?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                urlEncodeUTF8(entry.getKey().toString()),
                urlEncodeUTF8(entry.getValue().toString())
            ));
        }
        return sb.toString();       
    }
    
    
}
