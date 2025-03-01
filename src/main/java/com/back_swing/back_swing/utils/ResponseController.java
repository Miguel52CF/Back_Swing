package com.back_swing.back_swing.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseController {

    private ResponseController() {
    };

    public static Map<String, Object> createApiResponse(boolean success, String message, Object data) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", success);
        response.put("message", message);
        response.put("data", data);
        return response;
    };
}
