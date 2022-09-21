package com.syd.action.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class SendMessReq {
    @JSONField(name = "touser")
    private String toUser = "ocYt76P6StB9m9EAkHS-xGRE0LKo";
    private String template_id = "BgVeOaU5p7iJp9ILFFW6YrVzGq8FNLe13xa57Dx2CvQ";
    private String url = "";
    private String topcolor = "#FF0000";
    private String data;
}
