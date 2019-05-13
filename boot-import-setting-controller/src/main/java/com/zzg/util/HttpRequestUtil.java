package com.zzg.util;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpRequestUtil {
	/**
     * 通用请求格式转换
     * @param httpServletRequest
     * @return
     */
    public static Map<String, String> commonHttpRequestParamConvert(HttpServletRequest httpServletRequest) {
        Map<String, String> params = new HashMap<>();
        try {
            Map<String, String[]> requestParams = httpServletRequest.getParameterMap();
            if (requestParams != null && !requestParams.isEmpty()) {
                requestParams.forEach((key, value) -> params.put(key, value[0]));
            } else {
                StringBuilder paramSb = new StringBuilder();
                try {
                    String str = "";
                    BufferedReader br = httpServletRequest.getReader();
                    while((str = br.readLine()) != null){
                        paramSb.append(str);
                    }
                } catch (Exception e) {
                    System.out.println("httpServletRequest get requestbody error, cause : " + e);
                }
                if (paramSb.length() > 0) {
                    JSONObject paramJsonObject = JSON.parseObject(paramSb.toString());
                    if (paramJsonObject != null && !paramJsonObject.isEmpty()) {
                        paramJsonObject.forEach((key, value) -> params.put(key, String.valueOf(value)));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("commonHttpRequestParamConvert error, cause : " + e);
        }
        return params;
    }
    
    

}
