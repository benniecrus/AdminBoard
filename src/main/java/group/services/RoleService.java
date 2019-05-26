package group.services;

import group.model.Role;

import java.util.List;

public interface RoleService {
	List<Role> findAll();
	Role findById(int roleId);
}
