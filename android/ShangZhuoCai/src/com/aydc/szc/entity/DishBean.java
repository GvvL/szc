package com.aydc.szc.entity;


public class DishBean extends Bean{

    /**
     * id : 1
     * img : Uploads/Dishes/def.jpg
     * title : 清炒萝卜丝
     * en : asdf11
     * description : 东奔西走苦苦地1
     * chef_id : 2
     * favors : 5
     * price : 2.09
     * vedio : 111
     * recommended : 0
     * status : 1
     * num : 62
     * sales : 35
     * vipprice : 1.01
     * type : 1
     * style : 1
     */

    private int id;
    private String img;
    private String title;
    private String en;
    private String description;
    private int chef_id;
    private String favors;
    private float price;
    private String vedio;
    private int recommended;
    private int status;
    private int num;
    private int sales;
    private float vipprice;
    private int type;
    private int style;
    private String type_title;
    private boolean isCartSel=true;
    
    public int cart_num=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getChef_id() {
        return chef_id;
    }

    public void setChef_id(int chef_id) {
        this.chef_id = chef_id;
    }

    public String getFavors() {
        return favors;
    }

    public void setFavors(String favors) {
        this.favors = favors;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getVedio() {
        return vedio;
    }

    public void setVedio(String vedio) {
        this.vedio = vedio;
    }

    public int getRecommended() {
        return recommended;
    }

    public void setRecommended(int recommended) {
        this.recommended = recommended;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public float getVipprice() {
        return vipprice;
    }

    public void setVipprice(float vipprice) {
        this.vipprice = vipprice;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

	public String getType_title() {
		return type_title;
	}

	public void setType_title(String type_title) {
		this.type_title = type_title;
	}

	public boolean isCartSel() {
		return isCartSel;
	}

	public void setCartSel(boolean isCartSel) {
		this.isCartSel = isCartSel;
	}
}
