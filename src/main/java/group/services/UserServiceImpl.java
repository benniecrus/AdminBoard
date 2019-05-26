package group.services;

import java.util.List;

import group.model.Users;
import group.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public Users checkLogin(Users user) {
		return userRepository.findByUserNameAndPasswordAndActive(user.getUserName(), user.getPassword(), true);
	}

	@Override
	public Users saveOrUpdate(Users user) {
		return userRepository.save(user);
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Users findById(int userId) {
		return userRepository.findOne(userId);
	}

//	 @Override
//	 public List<Users> findAll() {
//	 return userRepository.findAll();
//	 }
	
	// @Override
	// public Users findById(int useId) {
	// return userRepository.findByUserId(useId);
	// }
	//
	// @Override
	// public Users findByName(String name) {
	// return userRepository.findByName(name);
	// }
	//
	// @Override
	// public Users findByActive(Boolean active) {
	// return userRepository.findByActive(active);
	// }
	//
	// @Override
	// public Users addUser(Users users) {
	// return userRepository.save(users);
	// }
	//
	// @Override
	// public Users update(int id, String name, Boolean active, String userName,
	// String password, Role roleId) {
	// return userRepository.update(id, name, active, userName, password,
	// roleId);
	// }
	//
	// @Override
	// public void deleteUser(Users users) {
	// userRepository.delete(users);
	//
	// }
	//
	// @Override
	// public Users checkLogin(String userName, String password) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
