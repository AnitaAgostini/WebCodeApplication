package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.function.Function;

import com.Application.DataSource;
import com.Interface.BaseDAO;
import com.Interface.FunctionDAO;

@Repository
public class FunctionDAOImp implements FunctionDAO, BaseDAO <Function>{

	@Override
	public Optional<Function> get(Integer id_function)throws SQLException{
		String sql = "SELECT * FROM tb_function WHERE id_function=?";
		Connection con = DataSource.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id_function);
		ResultSet rs = stmt.executeQuery();
		Function function = new Function();

		while(rs.next()) {
			function.setIdFunction(rs.getInt(1));
			function.setFunctionName(rs.getString(2));
			if (rs.getInt(3)==1) {
				function.setFunctionStatus(true);   
			}else {
				function.setFunctionStatus(false);   
			}		}
		con.close();
		Optional<Function> opt = Optional.of(function);
		function.toString();
		return opt;
	}

	@Override
	public List<Function> getAll() throws SQLException{
		String sql = "SELECT * FROM tb_function";
		Connection con = DataSource.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Function> result = new ArrayList<Function>();
		while(rs.next()) {
			Function function = new Function();
			function.setIdFunction(rs.getInt(1));
			function.setFunctionName(rs.getString(2));

			if (rs.getInt(3)==1) {
				function.setFunctionStatus(true);   
			}else if(rs.getInt(3)==1) {
				function.setFunctionStatus(false);   
			}
			function.toString();
			result.add(function);
		}
		con.close();
		return result;
	}

	@Override
	public Integer  save(Function function) throws SQLException{

		String sql = "INSERT INTO TB_FUNCTION ( FUNCTION_NAME, FUNCTION_STATUS)VALUES(?,?)";  //Idnome_sequeza.nextvalue          
		Connection con = DataSource.getConnection();  
		PreparedStatement pstmt = con.prepareStatement(sql);
//		pstmt.setInt(1, function.getIdFunction()); 
		pstmt.setString(1, function.getFunctionName());

		if (function.isFunctionStatus()) {
			pstmt.setInt(2, 1);
		}else {
			pstmt.setInt(2, 0);
		}
		Integer result = pstmt.executeUpdate(); 
		con.close();
		return result; 	  
	}


	@Override
	public void update(Function function)throws SQLException {

		String sql = "UPDATE TB_FUNCTION SET FUNCTION_NAME=?, FUNCTION_STATUS=? WHERE ID_FUNCTION=?";      
		Connection con = DataSource.getConnection();  
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, function.getFunctionName()); 
		if (function.isFunctionStatus()) {
			pstmt.setInt(2, 1);
		}else {
			pstmt.setInt(2, 0);
		}
		pstmt.setInt(3, function.getIdFunction()); 

		pstmt.executeUpdate(); 
		con.close();
	}


	@Override
	public void delete(Function function) throws SQLException {
		String sql = "update TB_FUNCTION set fUNCTION_STATUS=0 where FUNCTION_NAME=?";
		Connection con = DataSource.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, function.getFunctionName());
		stmt.executeUpdate();
		con.close();
	}

	@Override
	public List<Function> findAllFunctionStatusOne()throws SQLException{
		String sql = "select * from TB_FUNCTION where FUNCTION_STATUS=1";
		Connection con = DataSource.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		List<Function> result = new ArrayList<Function>();
		while(rs.next()) {
			Function function = new Function();
			function.setIdFunction(rs.getInt(1));
			function.setFunctionName(rs.getString(2));
			if (rs.getInt(3)==1) {
				function.setFunctionStatus(true);   
			}else {
				function.setFunctionStatus(false);   
			}			result.add(function);
		}
		con.close();
		return result;