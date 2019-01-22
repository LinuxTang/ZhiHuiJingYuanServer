package dao;

import Utils.JDBCUtil;

import java.sql.*;
import java.util.Vector;

public class AbstractDao {

	public int update(String sql,Object[] values){
		int successCount = 0;
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = JDBCUtil.getConn();
			preStmt = conn.prepareStatement(sql);
			if(values != null)
			for(int i = 0; i < values.length; i++){
				preStmt.setObject(i+1, values[i]);
			}
			preStmt.executeUpdate();
			successCount = preStmt.getUpdateCount();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(null, preStmt, conn);
		}
		return successCount;
	}
	
	public int updateall(String sql , Object[][] values){
		int ok  = 0;
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = JDBCUtil.getConn();
			preStmt = conn.prepareStatement(sql);
			if(values != null)
			for(int i = 0; i < values.length; i++){
				for(int j = 0; j < values[i].length; j++){					
					preStmt.setObject(j+1, values[i][j]);
				}
				preStmt.addBatch();
			}
			int[] rows = preStmt.executeBatch();
			ok = rows.length;
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(null, preStmt, conn);
		}
		return ok;
	}
	

	public Vector<Vector<Object>> select(String sql,Object[] values){
		Vector<Vector<Object>> all = new Vector<Vector<Object>>();
		Vector<Object> line = new Vector<Object>();
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try{
			conn = JDBCUtil.getConn();
			preStmt = conn.prepareStatement(sql);
			if(values != null)
			{				
				for(int i = 0; i < values.length; i++){
					preStmt.setObject(i+1, values[i]);
				}
			}
			rs = preStmt.executeQuery();
			rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next()){
				line = new Vector<Object>();
				for(int i = 1; i <= count; i++){
					line.add(rs.getObject(i));
				}
				all.add(line);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(rs, preStmt, conn);
		}
		return all;
	}
	
	public Object[] find(String sql,Object[] values){
		Object[] ok = null;
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try{
			conn = JDBCUtil.getConn();
			preStmt = conn.prepareStatement(sql);
			if(values != null)
			for(int i = 0; i < values.length; i++)
			{
				preStmt.setObject(i+1, values[i]);
			}
			rs = preStmt.executeQuery();
			rsmd = rs.getMetaData();
			if(rs.next()){
				ok = new Object[rsmd.getColumnCount()];
				for(int i = 1; i <= rsmd.getColumnCount();i++){					
					ok[i - 1] = rs.getObject(i);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(rs, preStmt, conn);
		}
		return ok;
	}
}
