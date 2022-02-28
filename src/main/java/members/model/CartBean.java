package members.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

public class CartBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int cart_id;
    private int member_id;
    private int product_id;
    private Blob image_blob;
    private String name;
    private int price;
    private int amount;
    private Timestamp created_at;
    private Timestamp updated_at;
    
    public CartBean() {
        this.cart_id = 0;
        this.member_id = 0;
        this.product_id = 0;
        this.amount = 0;
    }
    
    public CartBean(int product_id, int amount) {
        this.product_id = product_id;
        this.amount = amount;
    }
    
    public int getCartId() {
        return cart_id;
    }

    public void setCartId(int cart_id) {
        this.cart_id = cart_id;
    }
    
    public int getMemberId() {
        return member_id;
    }

    public void setMemberId(int member_id) {
        this.member_id = member_id;
    }
    
    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }
    
    public Blob getImageBlob() {
        return image_blob;
    }

    public void setImageBlob(Blob image_blob) {
        this.image_blob = image_blob;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public Timestamp getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdatedAt() {
        return updated_at;
    }
    public void setUpdatedAt(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
    
}
