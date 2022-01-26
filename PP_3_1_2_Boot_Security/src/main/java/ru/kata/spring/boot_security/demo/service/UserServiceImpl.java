package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
	
	private final UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void createUser(User user) {
		this.userDao.createUser(user);
	}
	
	@Override
	public User getUserById(Long id) {
		return this.userDao.getUserById(id);
	}
	
	@Override
	public void updateUser(User user) {
		this.userDao.updateUser(user);
	}
	
	@Override
	public void deleteUser(Long id) {
		this.userDao.deleteUser(id);
	}
	
	@Override
	public List<User> getUsers() {
		return this.userDao.getUsers();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.getUserByName(username);
	}
}
