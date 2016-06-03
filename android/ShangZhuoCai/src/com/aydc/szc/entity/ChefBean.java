package com.aydc.szc.entity;

import java.util.ArrayList;


public class ChefBean extends Bean{

    /**
     * id : 1
     * photo : Uploads/Chefs/def.jpg
     * img : Uploads/Chefs/def_back.jpg
     * chef_name : 范伟
     * description :
     入行18年的主厨于海江先生,曾经在商务部,最高检察院等机构担任主厨,多次在重要宴会中为国家领导人烹饪美食.</p>
     年轻时,凭着对美食的热爱和好胜必,于海江先生将川菜,湘菜,粤菜,淮扬菜,官府菜的基本功全部学到手.博采众长之后,推出以海鲜为主要食材的自创养生融合菜,依据时令变化,巧妙搭配荤素,适当添加药膳食材,让菜肴兼具美味和健康,大获住食客好评.</p>
     * cuisine : 鲁菜
     * star_level : 五星主厨
     * grading : 2.5
     * vedio :
     * recommends : 1024
     * status : 1
     */

    private int id;
    private String photo;
    private String img;
    private String name;
    private String description;
    private String cuisine;
    private String star_level;
    private float grade;
    private String vedio;
    private int supporter;
    private int status;
    private String style_name;
    private int styleid;
    private String monicker;
    private ArrayList<DishBean> chef_dishes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getStar_level() {
        return star_level;
    }

    public void setStar_level(String star_level) {
        this.star_level = star_level;
    }



    public String getVedio() {
        return vedio;
    }

    public void setVedio(String vedio) {
        this.vedio = vedio;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<DishBean> getChef_dishes() {
		return chef_dishes;
	}

	public void setChef_dishes(ArrayList<DishBean> chef_dishes) {
		this.chef_dishes = chef_dishes;
	}

	public String getMonicker() {
		return monicker;
	}

	public void setMonicker(String monicker) {
		this.monicker = monicker;
	}

	public String getStyle_name() {
		return style_name;
	}

	public void setStyle_name(String style_name) {
		this.style_name = style_name;
	}

	public int getStyleid() {
		return styleid;
	}

	public void setStyleid(int styleid) {
		this.styleid = styleid;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public int getSupporter() {
		return supporter;
	}

	public void setSupporter(int supporter) {
		this.supporter = supporter;
	}
}
