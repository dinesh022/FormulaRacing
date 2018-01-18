package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Users;

public interface UserDao {
	public boolean saveUser(Users users);
	public List<Users> getAllUsers();
	
	public Users getUserByeName(String username);
	public Users getUserById(int id);
	
	
}

