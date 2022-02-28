package common.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CategoryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int category_id;
    private String name;
    private int is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    
    public CategoryBean() {
        this.category_id = 0;
        this.name = null;
        this.is_active = 0;
    }
    
    public CategoryBean(int category_id, String name, int is_active) {
        
        this.category_id = category_id;
        this.name = name;
        this.is_active = is_active;
        
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
    
    public int getIsActive() {
        return is_active;
    }
    public void setIsActive(int is_active) {
        this.is_active = is_active;
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
