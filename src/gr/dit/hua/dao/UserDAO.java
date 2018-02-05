package gr.dit.hua.dao;

import java.util.List;
import gr.dit.hua.entity.User;

public interface UserDAO {

	public void save(User user);

	public List<User> getUsers();
	
	public void saveRole(User user, String role);

	public User getUser(String username);

}