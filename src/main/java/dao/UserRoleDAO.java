package dao;

import entity.UserRole;

public interface UserRoleDAO {
	
	public void addUserRole(UserRole userRole);
	public void deleteUserRole(int userRoleId);
	public UserRole getUserRole(int userRoleId);
}
