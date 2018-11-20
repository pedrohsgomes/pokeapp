package br.com.pokeapimanager.app.sevice;

import org.springframework.stereotype.Service;

import br.com.pokeapimanager.app.data.DataBase;
import br.com.pokeapimanager.app.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public boolean createUser(String userName, String password) {
		boolean result = false;
		User user = new User(userName, password);
		if (!DataBase.getInstance().getUsers().contains(user)) {			
			result = DataBase.getInstance().getUsers().add(user);
		}		
		return result;
	}
	
	@Override
	public boolean login(String userName, String password) {
		boolean result = false;
		User user = new User(userName, password);
		result = DataBase.getInstance().getUsers().contains(user);
		if (result) {			
			User userRemote = DataBase.getInstance().getUsers().get(DataBase.getInstance().getUsers().indexOf(user));
			result = userRemote.getPassword().equals(password);
		}		
		return result;
	}
	
	@Override
	public User findUser(String userName) {
		User user = new User(userName, "");
		User userRemote = null;
		if (DataBase.getInstance().getUsers().contains(user)) {			
			userRemote = DataBase.getInstance().getUsers().get(DataBase.getInstance().getUsers().indexOf(user));
		}		
		return userRemote;
	}
}
