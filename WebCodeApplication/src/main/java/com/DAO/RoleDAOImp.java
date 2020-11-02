package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Interface.RoleDAO;
import com.fides.Application.DataSource;
import com.fides.Interface.BaseDAO;
import com.fides.Model.Role;


public class RoleDAOImp implements com.Interface.BaseDAO<RoleDAO>{

	//	@Autowired
	//	Role role;
	Role role = new Role();

	@Override
	public Optional<Role> get(Integer id) throws SQLException{
		String sql = "SELECT * FROM TB_ROLE WHERE ID_ROLE = ?";            
		Connection con = DataSource.getConnection();  
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			role.setRoleIdRole(rs.getInt(1));
			role.setRoleDescription(rs.getString(2));
			role.setRoleStatus(rs.getBoolean(3));
		}
		Optional<Role> opt = Optional.of(role);
		con.close();
		return opt;
	}

	@Override
	public List<Role> getAll() throws SQLException{
		String sql = "SELECT * FROM TB_ROLE";            
		Connection con = DataSource.getConnection();  
		Statement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);
		List<Role> list = new ArrayList<Role>();
		while(rs.next()) {
			role.setRoleIdRole(rs.getInt(1));
			role.setRoleDescription(rs.getString(2));
			role.setRoleStatus(rs.getBoolean(3));
			list.add(role);
		}
		return list;
	}

	@Override
	public Integer save(Role role) throws SQLException{
		String sql = "INSERT INTO TB_ROLE (ROLE_DESCRIPTION, ROLE_STATUS) VALUES (?, ?) ";            
		Connection con = DataSource.getConnection();  
		PreparedStatement pstmt = con.prepareStatement(sql); 
		pstmt.setString(1, role.getRoleDescription()); 
		if (role.isRoleStatus()) {
			pstmt.setInt(2, 1);
		}else {
			pstmt.setInt(2, 0);
		}
		Integer result = pstmt.executeUpdate();
		con.close();
		return result;
	}

	@Override
	public void update(Role role) throws SQLException{
		String sql = "UPDATE TB_ROLE SET ROLE_DESCRIPTION = ?, ROLE_STATUS = ?  WHERE ID_ROLE = ?";            
		Connection con = DataSource.getConnection();  
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, role.getRoleDescription()); 
		if (role.isRoleStatus()) {
			pstmt.setInt(2, 1);
		}else {
			pstmt.setInt(2, 0);
		}
		pstmt.setInt(3, role.getRoleIdRole());
		pstmt.executeUpdate(); 
		con.close();
	}

	@Override
	public void delete(Role role) throws SQLException{
		String sql = "DELETE FROM TB_ROLE WHERE ID_ROLE = ?";            
		Connection con = DataSource.getConnection();  
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, role.getRoleIdRole()); 
		pstmt.executeUpdate(); 
		con.close();
	}

	public Integer save(RoleDAO t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(RoleDAO t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void delete(RoleDAO t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	//	@Override
	//	public List<Function> findAllRole()throws SQLException{
	//		String sql = "SELECT ";
	//		
	//	}
	//	public void RoleFunction(Function Role) {
	//		Session session = HibernateUtil.getSessionFactory().openSession();
	//		CriteriaBuilder cb = session.getCriteriaBuilder();
	//		CriteriaQuery<Role> query = cb.createQuery(Role.class);
	//		Root<Role> root = query.from(Role.class); 
	//		Join<Role, Function> joinUser = root.join("idRole");
	//	}
	//	@Transactional
	//	public void removeRole (Role role) {
	//		Session session = HibernateUtil.getSessionFactory().openSession();
	//		CriteriaBuilder cb = session.getCriteriaBuilder();
	//		CriteriaUpdate<Role> cquery = cb.createCriteriaUpdate(Role.class);
	//		Root<Role> root = cquery.from(Role.class);
	//		cquery.set("roleStatus", 0).where(
	//				cb.equal(root.get("roleDescription"), role.getRoleDescription())
	//				);
	//		session.createQuery(cquery).executeUpdate();
	//		session.close();
	//	}
}