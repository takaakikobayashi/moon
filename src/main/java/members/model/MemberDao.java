package members.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class MemberDao {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/moon";
    /** ユーザー名 */
    public static final String jdbcId = "root";
    /** パスワード */
    public static final String jdbcPass = "";

    public LoginUserBean selectUser(LoginUserBean loginUserBean) {

        LoginUserBean loginMemberBean = new LoginUserBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT member_id, first_name, last_name, kana_first_name, kana_last_name, postal_code, address1, address2, address3, mail, phone_number, password, is_active FROM members WHERE mail = ? AND password = ? AND is_active = '1'";
            this.ps = this.con.prepareStatement(sql);

            this.ps.setString(1, loginUserBean.getMail());
            this.ps.setString(2, loginUserBean.getPassword());
            this.rs = this.ps.executeQuery();

            if (rs.next()) {
                // 見つかったアカウント情報を戻り値にセット
            	loginMemberBean.setMemberId(rs.getInt("member_id"));
                loginMemberBean.setFirstName(rs.getString("first_name"));
                loginMemberBean.setLastName(rs.getString("last_name"));
                loginMemberBean.setKanaFirstName(rs.getString("kana_first_name"));
                loginMemberBean.setKanaLastName(rs.getString("kana_last_name"));
                loginMemberBean.setPostalCode(rs.getString("postal_code"));
                loginMemberBean.setAddress1(rs.getString("address1"));
                loginMemberBean.setAddress2(rs.getString("address2"));
                loginMemberBean.setAddress3(rs.getString("address3"));
                loginMemberBean.setMail(rs.getString("mail"));
                loginMemberBean.setPhoneNumber(rs.getString("phone_number"));
                loginMemberBean.setPassword(rs.getString("password"));
                loginMemberBean.setIsActive(rs.getBoolean("is_active"));
            } else {
                // アカウントがなければnullを返す
                return null;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
      return loginMemberBean;
  }
    
    public LoginUserBean getUserDetail(int member_id) {

        LoginUserBean loginMemberBean = new LoginUserBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT member_id, first_name, last_name, kana_first_name, kana_last_name, postal_code, address1, address2, address3, mail, phone_number, password, is_active FROM members WHERE member_id = ?";
            this.ps = this.con.prepareStatement(sql);

            this.ps.setInt(1, member_id);
            this.rs = this.ps.executeQuery();

            if (rs.next()) {
                // 見つかったアカウント情報を戻り値にセット
            	loginMemberBean.setMemberId(rs.getInt("member_id"));
                loginMemberBean.setFirstName(rs.getString("first_name"));
                loginMemberBean.setLastName(rs.getString("last_name"));
                loginMemberBean.setKanaFirstName(rs.getString("kana_first_name"));
                loginMemberBean.setKanaLastName(rs.getString("kana_last_name"));
                loginMemberBean.setPostalCode(rs.getString("postal_code"));
                loginMemberBean.setAddress1(rs.getString("address1"));
                loginMemberBean.setAddress2(rs.getString("address2"));
                loginMemberBean.setAddress3(rs.getString("address3"));
                loginMemberBean.setMail(rs.getString("mail"));
                loginMemberBean.setPhoneNumber(rs.getString("phone_number"));
                loginMemberBean.setPassword(rs.getString("password"));
            } else {
                // アカウントがなければnullを返す
                return null;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
      return loginMemberBean;
  }
    
    public void updateUserInfo(int member_id, String first_name, String last_name, String kana_first_name, String kana_last_name, String mail, String phone_number, String postal_code, String address1, String address2, String address3) {
    	
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "UPDATE members SET first_name = ?, last_name = ?, kana_first_name = ?, kana_last_name = ?, mail = ?, phone_number = ?, postal_code = ?, address1 = ?, address2 = ?, address3 = ?, created_at = ?, updated_at = ? WHERE member_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setString(1, first_name);
            this.ps.setString(2, last_name);
            this.ps.setString(3, kana_first_name);
            this.ps.setString(4, kana_last_name);
            this.ps.setString(5, mail);
            this.ps.setString(6, phone_number);
            this.ps.setString(7, postal_code);
            this.ps.setString(8, address1);
            this.ps.setString(9, address2);
            this.ps.setString(10, address3);
            this.ps.setTimestamp(11, timestamp);
            this.ps.setTimestamp(12, timestamp);
            this.ps.setInt(13, member_id);
            this.ps.executeUpdate();
            
    	} catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    	
    }
    
    public void cancelMembership(int member_id) {
    	
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "UPDATE members SET is_active = 0, updated_at = ? WHERE member_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setTimestamp(1, timestamp);
            this.ps.setInt(2, member_id);
            this.ps.executeUpdate();
            
    	} catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    	
    }
    
    public ArrayList<LoginUserBean> getMemberList() {
    	
    	ArrayList<LoginUserBean> member_list = new ArrayList<LoginUserBean>();
    	LoginUserBean loginMemberBean = new LoginUserBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT * FROM members";
            this.ps = this.con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();

            while (rs.next()) {
            	
            	int member_id = rs.getInt("member_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String kana_first_name = rs.getString("kana_first_name");
                String kana_last_name = rs.getString("kana_last_name");
                String mail = rs.getString("mail");
                String postal_code = rs.getString("postal_code");
                String address1 = rs.getString("address1");
                String address2 = rs.getString("address2");
                String address3 = rs.getString("address3");
                String phone_number = rs.getString("phone_number");
                boolean is_active = rs.getBoolean("is_active");
            	
                loginMemberBean = new LoginUserBean(member_id,first_name,last_name,kana_first_name,kana_last_name,mail,postal_code,address1,address2,address3,phone_number,is_active);
            	member_list.add(loginMemberBean);
            }
        } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
          return null;
        }
        return member_list;
    }

    public void close() {
        try {
            if (this.con != null) {
                this.con.close();
            }
            if (this.ps != null) {
                this.ps.close();
            }
            if (this.rs != null) {
                this.rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
