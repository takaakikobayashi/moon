package admins.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDao {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/moon";
    /** ユーザー名 */
    public static final String jdbcId = "root";
    /** パスワード */
    public static final String jdbcPass = "";

    public LoginAdminBean selectAdmin(LoginAdminBean loginAdminBean) {

    	LoginAdminBean loginUserBean = new LoginAdminBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT mail, password FROM admins WHERE mail = ? AND password = ?";
            this.ps = this.con.prepareStatement(sql);

            this.ps.setString(1, loginAdminBean.getMail());
            this.ps.setString(2, loginAdminBean.getPassword());
            this.rs = this.ps.executeQuery();

            if (rs.next()) {
                // 見つかったアカウント情報を戻り値にセット
            	loginUserBean.setMail(rs.getString("mail"));
            	loginUserBean.setPassword(rs.getString("password"));
            } else {
                // アカウントがなければnullを返す
                return null;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
      return loginUserBean;
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
