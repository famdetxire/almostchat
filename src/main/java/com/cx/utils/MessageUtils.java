package com.cx.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cx.pojo.ResultMessage;


public class MessageUtils {

    /*
     * 系统消息格式：{"isSystem":true,"fromName":null,"message","你好"}
     * 推送给某一个的消息格式：{"isSystem":true,"fromName":"张三","message",["李四","王五"]}
     */
    public static String getMessage(boolean isSystemMessage,String fromName, Object message) {
        try {
            ResultMessage result = new ResultMessage();
            result.setIsSystem(isSystemMessage);
            result.setMessage(message);
            if(fromName != null) {
                result.setFromName(fromName);
            }
            ObjectMapper mapper = new ObjectMapper();

            return mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
