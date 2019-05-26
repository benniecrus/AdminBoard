package group.controller;

import group.model.Role;
import group.model.Users;
import group.services.RoleService;
import group.services.UserService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "userSession"})
public class UserController {
  @Autowired
  UserService userService;

  @Autowired
  RoleService roleService;
//  @Autowired
//  GenericService<Role> roleService;
//
//  /**
//   * 
//   * @return login interface.
//   */
//  @RequestMapping(value = "/", method = RequestMethod.GET)
//  public String showLogin() {
//    return "login";
//  }
//
  
  /**
   * 
   * @param user
   *          get user from login page.
   * @param modelMap
   *          send attribute.
   * @return if user not null return home page, else notify error.
   */
  @RequestMapping(value = "login", method = RequestMethod.POST)
  public String login(@ModelAttribute("login") Users user, ModelMap modelMap) {
    Users users = userService.checkLogin(user);
    
    if (users != null) {
      modelMap.addAttribute("userSession", users);
      return "redirect:home";
    }
    
    return "login";
    
  }
  
  @RequestMapping(value="logout")
  public String logout(ModelMap modelMap, HttpSession session){
	  
	  session.removeAttribute("user");
	  
	  return "login";
  }
  
  
  /**
   * 
   * @param name
   *          property from edit form.
   * @param active
   *          property from edit form.
   * @param userName
   *          property from edit form.
   * @param password
   *          property from edit form.
   * @param roleId
   *          property from edit form.
   * @return if conditions true will return home page, else notify error.
   */
  @RequestMapping(value = "editProfile", method = RequestMethod.POST)
  public String editProfile(@RequestParam(value="userId", defaultValue="0") int userId, @RequestParam String name,
    @RequestParam(value="active", defaultValue="false") Boolean active, @RequestParam String userName,
    @RequestParam String password, @RequestParam int roleId,
    ModelMap modelMap, HttpSession session) {
	  
	Role role = roleService.findById(roleId);
	Users user;
	if(userId != 0)
		user = new Users(userId, name, active, userName, password, role);
	else
		user = new Users(name, active, userName, password, role);
	user = userService.saveOrUpdate(user);
	
	if(user.getUserId() == ((Users)session.getAttribute("userSession")).getUserId())
		modelMap.addAttribute("userSession", user);
	  
	return "redirect:home";
  }
  
//  /**
//   * 
//   * @return add user page.
//   */
//  @RequestMapping(value = ("add-user"), method = RequestMethod.GET)
//  public String showAddUser() {
//    return "add-user";
//  }
//
//  /**
//   * 
//   * @param user
//   *          user from add user page.
//   * @return if conditions true returm home page, else notify error.
//   */
//  @RequestMapping(value = ("add-user"), method = RequestMethod.POST)
//  public String addUser(@ModelAttribute("addUser") Users user,
//      ModelMap modelMap) {
//    if (user.getName().equals(null) && user.getUserName().equals(null)
//        && user.getPassword().equals(null) && user.getActive() == null
//        && user.getRoleId() == null) {
//      modelMap.addAttribute("error", "Invalid");
//      return "add-user";
//    }
//    Users users = userService.addUser(user);
//    if (users != null) {
//      modelMap.addAttribute("user", users);
//      return "home";
//    }
//    return "add-user";
//  }
//
//  /**
//   * 
//   * @param id
//   *          id respone by user page.
//   * @param modelMap
//   *          send attribute.
//   * @return if conditions true will return home page, else notify error.
//   */
//  @RequestMapping(value = ("edit-user"), method = RequestMethod.GET)
//  public String showEditUser(@RequestParam int id, ModelMap modelMap) {
//    Users users = userService.findById(id);
//    if (users != null) {
//      modelMap.addAttribute("userEdit", users);
//      return "edit-user";
//    }
//    modelMap.addAttribute("error", "Not found");
//    return "home";
//  }
//

//  
//  /**
//   * 
//   * @param id id respone by home page.
//   * @param modelMap send attribute.
//   * @return if conditions true will return home page, else notify error. 
//   */
//  @RequestMapping(value = "delete-user", method = RequestMethod.GET)
//  public String deleteUser(@RequestParam int id, ModelMap modelMap) {
//    Users users = userService.findById(id);
//    if (users != null) {
//      userService.deleteUser(users);
//      List<Users> list = userService.findAll();
//      modelMap.addAttribute("list", list);
//      return "home";
//    }
//    modelMap.addAttribute("error", "Not found");
//    return "home";
//  }
}
