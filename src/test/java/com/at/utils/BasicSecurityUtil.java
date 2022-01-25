package com.at.utils;

import com.at.utils.ApiTools;
import org.springframework.http.ResponseEntity;

public class BasicSecurityUtil {
    public String environment, requestBody, responseBody, apiResource;
    public ResponseEntity<String> response;
    public ApiTools ServiceApi;
    public String type;
    public String method;
    public String expectedMessage;
    public String param;
}
