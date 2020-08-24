package mango.connection.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DB연결 Connection 연결 클래스  상속받아서 사용
public class DBconnection {

		
		// DB 연결 객체
		protected Connection con;
		protected PreparedStatement pstmt;
		protected ResultSet rs;
		protected String sql = "";
		
		protected void resourceClose(){
			
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con !=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		protected void getConnection() throws Exception{
			
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/mango");
			this.con = ds.getConnection();
		
		}
		
	
	
}