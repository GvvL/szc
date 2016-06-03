package com.aydc.szc.entity;

/**
 * Created by Administrator on 2016/4/29.
 */
public class CouponBean extends Bean{
    /**
     * id : 4
     * uid : 3
     * value : 10
     * min : 40
     * valid_date : 1913000000
     * status : 1
     */

    private int id;
    private int uid;
    private float value;
    private float min;
    private long valid_date;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public long getValid_date() {
        return valid_date;
    }

    public void setValid_date(long valid_date) {
        this.valid_date = valid_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
