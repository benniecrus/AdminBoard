package group.services;

import java.util.List;

import group.model.Users;

public interface UserService {

//  Users checkLogin(String userName, String password);
//
//  Users findByActive(Boolean active);
//
//  Users addUser(Users users);
//
//  Users update(int id, String name, Boolean active, String userName,
//      String password, Role roleId);
//  
//  void deleteUser(Users users);
	
	Users checkLogin(Users user);
	Users saveOrUpdate(Users user);
	List<Users> findAll();
	Users findById(int userId);
	
}
