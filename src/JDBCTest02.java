import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
JDBC完成delete update
 */
public class JDBCTest02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注冊驅動
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //2.獲取鏈接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","2002");
            //3.獲取數據庫操作對象
            stmt = conn.createStatement();
            //4.執行sql語句
            //String sql = "deelete from dept where deptno = 40";
            //JDBC中的sql語句不需要提供分號結尾
            String sql = "update dept set dname = '銷售部',loc = '天津' where deptno = 20";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "刪除成功" : "刪除失敗");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.釋放資源
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
