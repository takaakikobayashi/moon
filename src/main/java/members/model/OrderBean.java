package members.model;

import java.io.Serializable;
import java.sql.Date;

public class OrderBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int order_id;
    private int member_id;
    private String first_name;
    private String last_name;
    private String mail;
    private String postal_code;
    private String address1;
    private String address2;
    private String address3;
    private String phone_number;
    private int total_price;
    private int postage;
    private int payment;
    private int point;
    private String remarks;
    private String buy_item;
    private int order_status;
    private Date created_at;
    private Date updated_at;
    private int product_id;
    private int price;
    private int production_status;
    private int earnings;
    private String credit;
    
    public OrderBean() {
    	this.order_id = 0;
    	this.member_id = 0;
    	this.first_name = null;
    	this.last_name = null;
    	this.mail = null;
    	this.postal_code = null;
    	this.address1 = null;
    	this.address2 = null;
    	this.address3 = null;
    	this.phone_number = null;
    	this.total_price = 0;
    	this.postage = 0;
    	this.payment = 0;
    	this.point = 0;
    	this.remarks = null;
    	this.buy_item = null;
    	this.product_id = 0;
    	this.price = 0;
    	this.credit = null;
    }
    
    public OrderBean(int total_price, Date created_at) {
    	this.total_price = total_price;
    	this.created_at = created_at;
    }
    
    public OrderBean(String first_name, String last_name, String postal_code, String address1, String address2, String address3, String mail, String phone_number, int total_price, int postage, int payment, int point, String remarks, int order_status, Date created_at, Date updated_at) {
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.mail = mail;
    	this.postal_code = postal_code;
    	this.address1 = address1;
    	this.address2 = address2;
    	this.address3 = address3;
    	this.phone_number = phone_number;
    	this.total_price = total_price;
    	this.postage = postage;
    	this.payment = payment;
    	this.point = point;
    	this.remarks = remarks;
    	this.order_status = order_status;
    	this.created_at = created_at;
    	this.updated_at = updated_at;
    }
    
    public OrderBean(int order_id,int member_id,String first_name,String last_name,String mail,String postal_code,String address1,String address2,String address3,String phone_number,int total_price,int postage,int payment,int point,String remarks,int product_id,int price,Date created_at,int order_status,int production_status) {
    	this.order_id = order_id;
    	this.member_id = member_id;
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.mail = mail;
    	this.postal_code = postal_code;
    	this.address1 = address1;
    	this.address2 = address2;
    	this.address3 = address3;
    	this.phone_number = phone_number;
    	this.total_price = total_price;
    	this.postage = postage;
    	this.payment = payment;
    	this.point = point;
    	this.remarks = remarks;
    	this.product_id = product_id;
    	this.price = price;
    	this.created_at = created_at;
    	this.order_status = order_status;
    	this.production_status = production_status;
    }
    
    public int getOrderId() {
        return order_id;
    }
    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }
    
    public int getMemberId() {
        return member_id;
    }
    public void setMemberId(int member_id) {
        this.member_id = member_id;
    }
    
    public String getFirstName() {
        return first_name;
    }
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getPostalCode() {
        return postal_code;
    }
    public void setPostalCode(String postal_code) {
        this.postal_code = postal_code;
    }
    
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }
    public void setAddress3(String address3) {
        this.address3 = address3;
    }
    
    public String getPhoneNumber() {
        return phone_number;
    }
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }
    
    public int getTotalPrice() {
        return total_price;
    }
    public void setTotalPrice(int total_price) {
        this.total_price = total_price;
    }
    
    public int getPostage() {
        return postage;
    }
    public void setPostage(int postage) {
        this.postage = postage;
    }
    
    public int getPayment() {
        return payment;
    }
    public void setPayment(int payment) {
        this.payment = payment;
    }
    
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public String getBuyItem() {
        return buy_item;
    }
    public void setBuyItem(String buy_item) {
        this.buy_item = buy_item;
    }
    
    public int getOrderStatus() {
    	return order_status;
    }
    public void setOrderStatus(int order_status) {
    	this.order_status = order_status;
    }
    
    public Date getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }
    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }
    
    public int getProductId() {
        return product_id;
    }
    public void setProductId(int product_id) {
        this.product_id = product_id;
    }
    
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getProductionStatus() {
        return production_status;
    }
    public void setProductionStatus(int production_status) {
        this.production_status = production_status;
    }
    
    public int getEarnings() {
        return earnings;
    }
    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }
    
    public String getCredit() {
        return credit;
    }
    public void setCredit(String credit) {
        this.credit = credit;
    }

}
