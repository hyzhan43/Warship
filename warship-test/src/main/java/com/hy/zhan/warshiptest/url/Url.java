package com.hy.zhan.warshiptest.url;

import lombok.Value;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author :  HyJame
 * date  :   2021/3/17
 * desc :
 */
@Value
public class Url {

    String url;

    Map<String, Object> params;

    public String buildUrl() {
        if (params == null || params.isEmpty()) {
            return url;
        }

        String initUrl = replacePlaceHolderParams();

        StringBuilder urlBuilder = new StringBuilder(initUrl + "?");
        params.forEach((key, value) -> urlBuilder.append(key).append("=").append(value).append("&"));

        String finalUrl = urlBuilder.toString();
        if (finalUrl.endsWith("&")) {
            return finalUrl.substring(0, finalUrl.length() - 1);
        }

        return finalUrl;
    }

    private String replacePlaceHolderParams() {
        Pattern pattern = Pattern.compile("\\{(.*?)}");
        Matcher matcher = pattern.matcher(url);

        String initUrl = url;
        while (matcher.find()) {
            String key = matcher.group(1);
            Object value = params.get(key);
            if (value == null) {
                throw new RuntimeException("key = " + key + "not found value");
            }

            initUrl = initUrl.replace("{" + key + "}", String.valueOf(value));
            params.remove(key);
        }
        return initUrl;
    }
}
