package com.Model
//@Entity
//@Table(name = "TB_USER_ROLE")
//@AssociationOverrides({
//  @AssociationOverride(name = "idUser", 
//      joinColumns = @JoinColumn(name = "ID_USER")),
//  @AssociationOverride(name = "idRole", 
//      joinColumns = @JoinColumn(name = "ID_ROLE")) })
public class UserRole   {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ")
//	@SequenceGenerator(name="EMP_SEQ", sequenceName="EMP_SEQ", allocationSize=1)
//	@Column(name = "ID_USER_ROLE")
	Integer idUserRole;

//  @ManyToOne
  private User idUser;

//  @ManyToOne
  private Role idRole;
  
//	@Column(name="USER_ROLE_STATUS ")
	boolean userRoleStatus;

	public UserRole() {
		super();
		this.userRoleStatus=false;
		
	}

	@Override
	public String toString() {
		return "UserRole{" +
				"idUserRole=" + idUserRole +
				", idUser=" + idUser +
				", idRole=" + idRole +
				", userRoleStatus=" + userRoleStatus +
				'}';
	}

	public Integer getIdUserRole() {
		return idUserRole;
	}

	public void setIdUserRole(Integer idUserRole) {
		this.idUserRole = idUserRole;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public Role getIdRole() {
		return idRole;
	}

	public void setIdRole(Role idRole) {
		this.idRole = idRole;
	}

	public boolean getUserRoleStatus() {
		return userRoleStatus;
	}

	public void setUserRoleStatus(boolean userRoleStatus) {
		this.userRoleStatus = userRoleStatus;
	}
}l;