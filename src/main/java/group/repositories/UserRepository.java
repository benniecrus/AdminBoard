package group.repositories;

import group.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Integer> {
//  Users findByUserId(Integer useId);
//
//  Users findByName(String name);
//
//  Users findByActive(Boolean active);
//
//  Users findByUserName(String userName);
//
//  @Transactional
//  @Modifying(clearAutomatically = true)
//  @Query("UPDATE Users u SET u.name = :name, "
//      + "u.active = :active, u.userName = : userName, "
//      + "u.password = :password,  "
//      + "u.roleId = :roleId WHERE u.userId = :userId")
//  Users update(@Param(value = "userId") int id,
//      @Param(value = "name") String name,
//      @Param(value = "active") Boolean active,
//      @Param(value = "userName") String userName,
//      @Param(value = "password") String password,
//      @Param(value = "roleID") Role roleId);
	
	Users findByUserNameAndPasswordAndActive(String userName, String password, Boolean active);
}
