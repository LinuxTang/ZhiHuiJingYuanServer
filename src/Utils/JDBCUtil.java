package Utils;

import java.sql.*;

public class JDBCUtil {
	public static Connection getConn(){
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/gcwtg?user=root&"
					+"password=123456";
			connection = DriverManager.getConnection(url);
			
		}catch(ClassNotFoundException e){
			System.out.println("JDBC connection error hhh ");
		}catch(SQLException e){
			System.out.println("JDBC Operation error");
		}
		return connection;
	}
	public static void closeConn(ResultSet rs,PreparedStatement preStmt,Connection conn){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(preStmt!=null){
			try{
				preStmt.close();
			}catch(SQLException e){
				System.out.println("JDBC connection shut error");
			}
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				System.out.println("JDBC connection error");
			}
		}
	}
}
