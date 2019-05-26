package group.services;

import group.model.Role;
import group.repositories.RoleRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> findAll(){
		return roleRepository.findAll();
	}
	
  public Role findById(int roleId) {
    return roleRepository.findOne(roleId);
  }
  
//
//  @Override
//  public Role findByName(String name) {
//    // TODO Auto-generated method stub
//    return null;
//  }

}
