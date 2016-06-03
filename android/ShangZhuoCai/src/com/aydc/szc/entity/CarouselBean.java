package com.aydc.szc.entity;


public class CarouselBean extends Bean{

    /**
     * id : 1
     * img : Uploads/Carousels/car01.jpg
     * target : dishes.html
     * valid : 1
     */

    private int id;
    private String img;
    private String target;
    private int valid;

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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }
}
