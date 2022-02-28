package admins.model;

import java.io.Serializable;
import java.sql.Date;

public class LoginAdminBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int admin_id;
    private String mail;
    private String password;
    private Date created_at;
    private Date updated_at;

    public int getMemberId() {
        return admin_id;
    }

    public void setMemberId(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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