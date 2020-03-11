package org.thealphalab.education.model;

public class Xiaofeileixing {
    private Integer xflxid;

    private String xflxname;

    private Boolean xflxdelsign;

    public Xiaofeileixing(String xflxname) {
        this.xflxname = xflxname;
    }

    public Integer getXflxid() {
        return xflxid;
    }

    public void setXflxid(Integer xflxid) {
        this.xflxid = xflxid;
    }

    public String getXflxname() {
        return xflxname;
    }

    public void setXflxname(String xflxname) {
        this.xflxname = xflxname;
    }

    public Boolean getXflxdelsign() {
        return xflxdelsign;
    }

    public void setXflxdelsign(Boolean xflxdelsign) {
        this.xflxdelsign = xflxdelsign;
    }
}