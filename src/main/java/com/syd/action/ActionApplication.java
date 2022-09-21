package com.syd.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.syd.action.req.SendMessReq;
import com.syd.action.resp.AccessTokenResp;
import com.syd.action.utils.HttpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActionApplication {

    public static void main(String[] args) {
        System.out.println(SendMessage());
    }

    public static String getAccessToken() {
        return HttpUtils.get(String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", "wxf1c9e0d05411bc4c", "f2a9bc418bfd32243b494b9e83d8211d"));
    }

    public static String getAccessToken1() {
        String res = "{\"access_token\":\"61_EUCRiXDUL2ke-rVXNpYzazFdoflBJkjF96HnKHdAAA34nO-rtaQhLvgY1k4srjWcvfDBFZ_qLuAq0fk5Gnrn8-tDKE7yFaoLEcbO4jtUqhxd5We_uz02aQxF4j7qWEyGUWYcbHYcL02s8FxiOYFcAHAFPW\",\"expires_in\":7200}";
        AccessTokenResp accessTokenResp = JSONObject.parseObject(res, AccessTokenResp.class);
        return accessTokenResp.getAccessToken();
    }

    public static String SendMessage() {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + getAccessToken1();
        SendMessReq req = new SendMessReq();
        return HttpUtils.postJson(url, JSON.toJSONString(req));
    }

}
