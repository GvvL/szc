package com.aydc.szc.entity;


public class AddressBean extends Bean{
    /**
     * id : 1
     * member_id : 3
     * address_linkman : 刘大裤子
     * address_linktel : 18363625201
     * address_detail : 潍坊市高新区金马怡园
     * status : 1
     * default : 1
     */

    private int id;
    private int member_id;
    private String address_linkman;
    private String address_linktel;
    private String address_detail;
    private int status;
    private int isdefault;
    private boolean isSel=false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getAddress_linkman() {
        return address_linkman;
    }

    public void setAddress_linkman(String address_linkman) {
        this.address_linkman = address_linkman;
    }

    public String getAddress_linktel() {
        return address_linktel;
    }

    public void setAddress_linktel(String address_linktel) {
        this.address_linktel = address_linktel;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	public int getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(int isdefault) {
		this.isdefault = isdefault;
	}

	public boolean isSel() {
		return isSel;
	}

	public void setSel(boolean isSel) {
		this.isSel = isSel;
	}

}
