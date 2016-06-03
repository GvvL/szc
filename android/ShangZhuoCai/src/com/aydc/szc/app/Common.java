package com.aydc.szc.app;

public class Common {
	public static final int NOTRANS=0;
	public static final int TRANSTOP=1;
	public static final int TRANSALL=2;
	public static final int TRANSTYPE=TRANSTOP;//状�?�栏沉侵类型
	
	public static final String RELEAST_HOST="http://mt.ayidiancan.com/";
	
	public static final String LOACTION_APIKEY="20008c7c702bb093980d96a073e6f106";//高德定位
	
	public static final String[] TAB2_FILTER_STR={"智能排序","价格","推荐人数","销售数量"};
	public static final String[] TAB3_FILTER_STR={"智能排序","星级","推荐人数"};
	
	public static final int LOGIN_REQUEST_CODE=1000;
	public static final int LOGIN_RESPONSE_CODE=200;
	
	public static final int SEL_ADDRESS_REQUEST_CODE=1000;	
	public static final int SEL_ADDRESS_RESPONSE_CODE=2000;
	public static final int SEL_COUPON_REQUEST_CODE=1001;	
	public static final int SEL_COUPON_RESPONSE_CODE=1002;
	
	public static final String SEL_COUPON="cou";
	public static final String SEL_ADDRESS="sel";
	public static final String SEL_COUPON_PRICE="price";
	
	public static final int REQUEST_CODE_PAYMENT=400;
	public static final int RESPONSE_CODE_PAYMENT_OK=200;
	
	public static final int REQUEST_ADDRESS_ADD=300;
	public static final int REQUEST_ADDRESS_EDIT=301;
	public static final int RESPONSE_HANDLER_ADDRESS=302;
	
	
	public static final String PAY_URL="http://www.ayidiancan.com/android/aybuspay/pay/";
	
    /**
     * 微信支付渠道
     */
    public static final String CHANNEL_WECHAT = "wx";
    /**
     * 支付支付渠道
     */
    public static final String CHANNEL_ALIPAY = "alipay";
    /**
     * 余额支付渠道
     */
    public static final String CHANNEL_YUE = "yue";

}
