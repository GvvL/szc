package com.aydc.szc.entity;

import java.util.List;


public class OrderBean extends Bean{

    /**
     * id : 24
     * sn : 20160505030430481
     * uid : 3
     * uname : 刘大裤子
     * tel : 18363625201
     * addr : 潍坊市高新区金马怡园
     * addrid : 1
     * couponid : null
     * price : 68.02
     * paied : 0.00
     * order_time : 1462431870
     * pay_time : null
     * isnew : 1
     * status : 0
     * note : 空空
     * district : null
     * from : 2
     * arr : [{"id":"24","order_id":"24","dish_id":"3","title":"清炒萝卜块","price":"13.00","count":"2"},{"id":"25","order_id":"24","dish_id":"2","title":"清炒萝卜条","price":"21.01","count":"2"}]
     */

    private int id;
    private String sn;
    private int uid;
    private String uname;
    private String tel;
    private String addr;
    private int addrid;
    private int couponid;
    private float price;
    private float paied;
    private String order_time;
    private String pay_time;
    private int isnew;
    private int status;
    private String note;
    private int district;
    private int from;
    private float order_freight=0f;
    private float coupon_price;
    /**
     * id : 24
     * order_id : 24
     * dish_id : 3
     * title : 清炒萝卜块
     * price : 13.00
     * count : 2
     */

    private List<OrderDishBean> arr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAddrid() {
        return addrid;
    }

    public void setAddrid(int addrid) {
        this.addrid = addrid;
    }

    public int getCouponid() {
        return couponid;
    }

    public void setCouponid(int couponid) {
        this.couponid = couponid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPaied() {
        return paied;
    }

    public void setPaied(float paied) {
        this.paied = paied;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public int getIsnew() {
        return isnew;
    }

    public void setIsnew(int isnew) {
        this.isnew = isnew;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public List<OrderDishBean> getArr() {
        return arr;
    }

    public void setArr(List<OrderDishBean> arr) {
        this.arr = arr;
    }

    public static class OrderDishBean {
        private int id;
        private int order_id;
        private int dish_id;
        private String title;
        private float price;
        private int count;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public int getDish_id() {
            return dish_id;
        }

        public void setDish_id(int dish_id) {
            this.dish_id = dish_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

	public float getOrder_freight() {
		return order_freight;
	}

	public void setOrder_freight(float order_freight) {
		this.order_freight = order_freight;
	}

	public float getCoupon_price() {
		return coupon_price;
	}

	public void setCoupon_price(float coupon_price) {
		this.coupon_price = coupon_price;
	}
}
