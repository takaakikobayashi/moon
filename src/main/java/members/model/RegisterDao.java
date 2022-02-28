package members.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/moon";
    /** ユーザー名 */
    public static final String jdbcId = "root";
    /** パスワード */
    public static final String jdbcPass = "";

    public Boolean registerDao(LoginUserBean loginUserBean) {
    	
    	Boolean error_check = false;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "INSERT INTO members (first_name, last_name, kana_first_name, kana_last_name, postal_code, address1, address2, address3, mail, phone_number, password, is_active, newsletter, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            this.ps = this.con.prepareStatement(sql);

            this.ps.setString(1, loginUserBean.getFirstName());
            this.ps.setString(2, loginUserBean.getLastName());
            this.ps.setString(3, loginUserBean.getKanaFirstName());
            this.ps.setString(4, loginUserBean.getKanaLastName());
            this.ps.setString(5, loginUserBean.getPostalCode());
            this.ps.setString(6, loginUserBean.getAddress1());
            this.ps.setString(7, loginUserBean.getAddress2());
            this.ps.setString(8, loginUserBean.getAddress3());
            this.ps.setString(9, loginUserBean.getMail());
            this.ps.setString(10, loginUserBean.getPhoneNumber());
            this.ps.setString(11, loginUserBean.getPassword());
            this.ps.setBoolean(12, loginUserBean.getIsActive());
            this.ps.setBoolean(13, (Boolean)loginUserBean.getNewsletter());
            this.ps.setTimestamp(14, loginUserBean.getCreatedAt());
            this.ps.setTimestamp(15, loginUserBean.getUpdatedAt());

            int r = this.ps.executeUpdate();

            if (r != 0) {
            	error_check = true;
            } else {
            	error_check = false;
            }

         } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return error_check;
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
