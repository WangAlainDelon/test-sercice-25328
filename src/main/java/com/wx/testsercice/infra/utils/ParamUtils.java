package com.wx.testsercice.infra.utils;

public class ParamUtils {
    private ParamUtils() {
    }

    public static String arrToStr(String[] params) {
        if (params == null) {
            return null;
        }
        if (params.length > 1) {
            StringBuilder sb = new StringBuilder();
            for (String ele : params) {
                sb.append(ele).append(",");
            }
            return sb.toString();
        }
        String param = null;
        if (params.length == 1) {
            param = params[0];
        }
        return param;
    }
}
