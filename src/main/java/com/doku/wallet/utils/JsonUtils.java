package com.doku.wallet.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JsonUtils {

    @Autowired
    private ObjectMapper objectMapper;

    public String convertJson(HttpServletRequest json) {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        Map<String, String[]> parameters = json.getParameterMap();
        return getParameterMap(parameters);
    }
    
    public String toJsonStringFromServletRequest(Object object) {
        ServletRequest httpServletRequest = (ServletRequest) object;
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        Map<String, String[]> parameters = httpServletRequest.getParameterMap();
        return getParameterMap(parameters);
    }

    public String getParameterMap(Map<String, String[]> parameters) {
        try {
            Map<String, String> map = new HashMap<>();
            for (String key : parameters.keySet()) {
                String[] values = parameters.get(key);
                map.put(key, values != null && values.length > 0 ? values[0] : null);
            }
            return objectMapper.writeValueAsString(map);
        } catch (IOException ex) {
            log.debug("Failed to convert JSON string to object", ex);
            return null;
        }
    }

    public String toJsonStringFromObject(Object object) {
        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            return objectMapper.writeValueAsString(object);
        } catch (IOException ex) {
            log.debug("Failed to convert JSON string to object", ex);
            return null;
        }
    }
}
