package common.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;


public class ItemBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int product_id;
    private int category_id;
    private String name;
    private String introduction;
    private Blob image_blob;
    private int price;
    private String ingredient;
    private String allergy;
    private int is_sailing;
    private Timestamp created_at;
    private Timestamp updated_at;
    private byte[] byteImage;

    public ItemBean() {
        this.product_id = 0;
        this.category_id = 0;
        this.name = null;
        this.introduction = null;
        this.image_blob = null;
        this.price = 0;
        this.ingredient = null;
        this.allergy = null;
        this.is_sailing = 0;
    }

    public ItemBean(int product_id, int category_id, String item_name, Blob item_image_blob, int price, int is_sailing) {
        this.product_id = product_id;
        this.category_id = category_id;
        this.name = item_name;
        this.image_blob = item_image_blob;
        this.price = price;
        this.is_sailing = is_sailing;
    }

    public ItemBean(int product_id, int category_id, String item_name, String introduction, Blob item_image_blob, int price, String ingredient, String allergy, int is_sailing) {
        this.product_id = product_id;
        this.category_id = category_id;
        this.name = item_name;
        this.introduction = introduction;
        this.image_blob = item_image_blob;
        this.price = price;
        this.ingredient = ingredient;
        this.allergy = allergy;
        this.is_sailing = is_sailing;
    }
    
    public byte[] getImage() {
    	return byteImage;
    }
    
    public void setImage(byte[] byteImage) {
    	this.byteImage = byteImage;
    }

    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Blob getImageBlob() {
        return image_blob;
    }

    public void setImageBlob(Blob image_blob) {
        this.image_blob = image_blob;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public int getIsSailing() {
        return is_sailing;
    }

    public void setIsSailing(int is_sailing) {
        this.is_sailing = is_sailing;
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
