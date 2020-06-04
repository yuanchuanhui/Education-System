package org.thealphalab.education.entity;

import lombok.Data;

@Data
public class GroupMonthResult extends GroupResult {

    private int year;
    private int month;
    private int money;
    private double rate;
    private String xfaddress;

}
