import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
注冊驅動的另一種方式（這種方式常用）
 */
public class JDBCTest03 {
    public static void main(String[] args) {
        try {
            //1.注冊驅動
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //2.獲取鏈接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","2002");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
