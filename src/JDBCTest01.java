import java.sql.*;

public class JDBCTest01 {
    public static void main(String[] args) throws SQLException {
        //1.注冊驅動
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Statement stmt = null;
        Connection conn = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            //Driver driver = new oracle.jdbc.driver.oracleDriver(); //oracle的驅動
            DriverManager.registerDriver(driver);
            //2.獲取鏈接
            /*
            url:統一資源定位符（網絡中某個資源的絕對路徑）
            http://www.baidu.com/ 這就是url
            url包括哪幾部分
                協議
                ip
                port
                資源名
            http://www.182.16.200.7:80/index.html
                http:// 通信協議
                182.16.200.7 服務器ip地址
                80 服務器上軟件的端口
                index.html 服務器上某個資源名

            jdbc:mysql://127.0.0.1:3306/bjpowernode
                jdbc:mysql:// 協議
                127.0.0.1 ip地址
                3306 mysql數據端口號
                bjpowernode 具體的數據庫實例名

            説明：localhost和127.0.0.1都是本機ip地址

            什麽是通信協議，有什麽用？
                通信協議是通信之前就提前定好的數據傳送格式，
                數據包具體怎麽傳數據，格式提前定好的

            oracle的url
                jdbc:oracle:thin:@localhost:1521:orcl
             */
            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String password = "2002";
            conn = DriverManager.getConnection(url, user, password);
            //com.mysql.cj.jdbc.ConnectionImpl@14ec4505
            System.out.println(conn);
            //3.獲取數據庫操作對象(Statement專門執行sql語句的）
            stmt = conn.createStatement();
            //4.執行sql
            String sql = "insert into dept (deptno,dname,loc) values (50,'人事部','北京')";
            //專門執行dml語句的（insert，delete，update）
            //返回值是”影響數據庫中記錄條數“
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "保存成功" : "保存失敗");
            //5.處理查詢結構集
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.釋放資源
            //爲了保證資源一定釋放，在finally語句塊中關閉資源
            //并且要遵循從小到大依次關閉
            //分別對其try。。。catch
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
