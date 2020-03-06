package org.thealphalab.education.store2db;

import lombok.Data;

import java.util.Date;

@Data
public class YxshAndSzbh{
    private int yxsh;
    private String szbh;
    private Date year;

    public YxshAndSzbh(int yxsh, String szbh) {
        this.yxsh = yxsh;
        this.szbh = szbh;
    }

    public YxshAndSzbh(int yxsh, String szbh, Date year) {
        this.yxsh = yxsh;
        this.szbh = szbh;
        this.year = year;
    }
}