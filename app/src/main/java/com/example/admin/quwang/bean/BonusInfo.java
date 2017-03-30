package com.example.admin.quwang.bean;

/**
 * Created by admin on 2017/3/30.
 */

public class BonusInfo {
    private  String bonus_description;
    private String due_days;
    private int min_goods_amount;
    private int type_id;
    private int type_money;
    private String type_name;
    private long use_end_date;
    private long use_start_date;

    public String getBonus_description() {
        return bonus_description;
    }

    public void setBonus_description(String bonus_description) {
        this.bonus_description = bonus_description;
    }

    public String getDue_days() {
        return due_days;
    }

    public void setDue_days(String due_days) {
        this.due_days = due_days;
    }

    public int getMin_goods_amount() {
        return min_goods_amount;
    }

    public void setMin_goods_amount(int min_goods_amount) {
        this.min_goods_amount = min_goods_amount;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getType_money() {
        return type_money;
    }

    public void setType_money(int type_money) {
        this.type_money = type_money;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public long getUse_end_date() {
        return use_end_date;
    }

    public void setUse_end_date(long use_end_date) {
        this.use_end_date = use_end_date;
    }

    public long getUse_start_date() {
        return use_start_date;
    }

    public void setUse_start_date(long use_start_date) {
        this.use_start_date = use_start_date;
    }
}
