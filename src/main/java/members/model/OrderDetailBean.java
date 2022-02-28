package members.model;

import java.io.Serializable;
import java.sql.Date;

public class OrderDetailBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int order_id;
    private int product_id;
    private int amount;
    private int price;
    private int production_status;
    private Date created_at;
    private Date updated_at;
    
    public OrderDetailBean() {
    	this.order_id = 0;
        this.product_id = 0;
        this.amount = 0;
        this.price = 0;
        this.production_status = 0;
    }
    
    public OrderDetailBean(int order_id, int product_id, int amount, int price, int production_status, Date created_at, Date updated_at) {
    	this.order_id = order_id;
        this.product_id = product_id;
        this.amount = amount;
        this.price = price;
        this.production_status = production_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    
    public int getOrderId() {
        return order_id;
    }
    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }
    
    public int getProductId() {
        return product_id;
    }
    public void setProductId(int product_id) {
        this.product_id = product_id;
    }
    
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
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

}
