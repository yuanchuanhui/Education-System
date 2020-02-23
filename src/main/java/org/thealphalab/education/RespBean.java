package org.thealphalab.education;

import lombok.Data;

@Data
public class RespBean {

    private String type;
    private int status;
    private String errMsg;
    private Object obj;

    public RespBean(String type) {
        this.type = type;
    }
}
