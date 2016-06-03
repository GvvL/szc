package com.aydc.szc.entity;


public class ChargeBean extends Bean{

    /**
     * id : ch_vL8SO8SW5OSKW5yvT8K4qLqP
     * object : charge
     * created : 1462866360
     * livemode : false
     * paid : false
     * refunded : false
     * app : app_yPu9COinrfvTWP8a
     * channel : alipay
     * order_no : 20160505024147469
     * client_ip : 27.192.38.73
     * amount : 3401
     * amount_settle : 3401
     * currency : cny
     * subject : 上桌菜商品购买
     * body : Some Body
     * extra : {}
     * time_paid : null
     * time_expire : 1462952760
     * time_settle : null
     * transaction_no : null
     * refunds : {"object":"list","url":"/v1/charges/ch_vL8SO8SW5OSKW5yvT8K4qLqP/refunds","has_more":false,"data":[]}
     * amount_refunded : 0
     * failure_code : null
     * failure_msg : null
     * metadata : {}
     * credential : {"object":"credential","alipay":{"orderInfo":"_input_charset=\"utf-8\"&body=\"Some Body\"&it_b_pay=\"2016-05-11 15:46:00\"¬ify_url=\"https%3A%2F%2Fapi.pingxx.com%2Fnotify%2Fcharges%2Fch_vL8SO8SW5OSKW5yvT8K4qLqP\"&out_trade_no=\"20160505024147469\"&partner=\"2008269888786638\"&payment_type=\"1\"&seller_id=\"2008269888786638\"&service=\"mobile.securitypay.pay\"&subject=\"上桌菜商品购买\"&total_fee=\"34.01\"&sign=\"VGFQOHlQNHU5V2IxNW16WFAwS21mMU9H\"&sign_type=\"RSA\""}}
     * description : null
     */

    private String id;
    private String object;
    private String created;
    private String livemode;
    private String paid;
    private String refunded;
    private String app;
    private String channel;
    private String order_no;
    private String client_ip;
    private String amount;
    private String amount_settle;
    private String currency;
    private String subject;
    private String body;
    private String time_paid;
    private String time_expire;
    private String time_settle;
    private String transaction_no;
    private String amount_refunded;
    private String failure_code;
    private String failure_msg;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String isLivemode() {
        return livemode;
    }

    public void setLivemode(String livemode) {
        this.livemode = livemode;
    }

    public String isPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String isRefunded() {
        return refunded;
    }

    public void setRefunded(String refunded) {
        this.refunded = refunded;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount_settle() {
        return amount_settle;
    }

    public void setAmount_settle(String amount_settle) {
        this.amount_settle = amount_settle;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Object getTime_paid() {
        return time_paid;
    }

    public void setTime_paid(String time_paid) {
        this.time_paid = time_paid;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public Object getTime_settle() {
        return time_settle;
    }

    public void setTime_settle(String time_settle) {
        this.time_settle = time_settle;
    }

    public String getTransaction_no() {
        return transaction_no;
    }

    public void setTransaction_no(String transaction_no) {
        this.transaction_no = transaction_no;
    }

    public String getAmount_refunded() {
        return amount_refunded;
    }

    public void setAmount_refunded(String amount_refunded) {
        this.amount_refunded = amount_refunded;
    }

    public String getFailure_code() {
        return failure_code;
    }

    public void setFailure_code(String failure_code) {
        this.failure_code = failure_code;
    }

    public String getFailure_msg() {
        return failure_msg;
    }

    public void setFailure_msg(String failure_msg) {
        this.failure_msg = failure_msg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
