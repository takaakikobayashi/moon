package members.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDao {
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/moon";
    /** ユーザー名 */
    public static final String jdbcId = "root";
    /** パスワード */
    public static final String jdbcPass = "";

    public CartBean getCartItem(int item_id) {

        CartBean cart_bean = new CartBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "SELECT product_id, name, image_blob, price FROM products WHERE product_id = ?";
	        this.ps = this.con.prepareStatement(sql);
	
	        this.ps.setInt(1, item_id);
	        this.rs = this.ps.executeQuery();
	
	        if (rs.next()) {
	            cart_bean.setProductId(rs.getInt("product_id"));
	            cart_bean.setName(rs.getString("name"));
	            cart_bean.setImageBlob(rs.getBlob("image_blob"));
	            cart_bean.setPrice(rs.getInt("price"));
	        }
        } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return null;
	    }
        return cart_bean;
    }

    public void close() {
        try {
            // データベースとの接続を解除する
            if (this.con != null) {
                this.con.close();
            }
            if (this.ps != null) {
                this.ps.close();
            }
            if (this.rs != null) {
                this.rs.close();
            }
        } catch (SQLException se) {
            // データベースとの接続解除に失敗した場合
            se.printStackTrace();
        }
    }
}
