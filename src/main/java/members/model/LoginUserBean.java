package members.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class LoginUserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int member_id;
    private String first_name;
    private String last_name;
    private String kana_first_name;
    private String kana_last_name;
    private String postal_code;
    private String address1;
    private String address2;
    private String address3;
    private String mail;
    private String phone_number;
    private String password;
    private boolean is_active;
    private boolean newsletter;
    private Timestamp created_at;
    private Timestamp updated_at;
    
    public LoginUserBean() {
    	this.member_id = 0;
    	this.first_name = null;
    	this.last_name = null;
    	this.kana_first_name = null;
    	this.kana_last_name = null;
    	this.postal_code = null;
    	this.address1 = null;
    	this.address2 = null;
    	this.address3 = null;
    	this.mail = null;
    	this.phone_number = null;
    	this.is_active = false;
    	this.password = null;
    	this.newsletter = false;
    	this.created_at = null;
    	this.updated_at = null;
    }
    
    public LoginUserBean(int member_id,String first_name,String last_name,String kana_first_name,String kana_last_name,String mail,String postal_code,String address1,String address2,String address3,String phone_number,boolean is_active) {
    	this.member_id = member_id;
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.kana_first_name = kana_first_name;
    	this.kana_last_name = kana_last_name;
    	this.postal_code = postal_code;
    	this.address1 = address1;
    	this.address2 = address2;
    	this.address3 = address3;
    	this.mail = mail;
    	this.phone_number = phone_number;
    	this.is_active = is_active;
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

    public String getKanaFirstName() {
        return kana_first_name;
    }
    public void setKanaFirstName(String kana_first_name) {
        this.kana_first_name = kana_first_name;
    }

    public String getKanaLastName() {
        return kana_last_name;
    }
    public void setKanaLastName(String kana_last_name) {
        this.kana_last_name = kana_last_name;
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

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phone_number;
    }
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsActive() {
        return is_active;
    }
    public void setIsActive(boolean is_active) {
        this.is_active = is_active;
    }
    
    public boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
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