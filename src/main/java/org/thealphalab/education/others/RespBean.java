package org.thealphalab.education.others;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespBean {

    private String type;
    private int status;
    private String errMsg;
    private Object obj;

    public RespBean(String type) {
        this.type = type;
    }

}
