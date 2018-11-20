package br.com.pokeapimanager.app.sevice;

import br.com.pokeapimanager.app.entity.User;

public interface UserService {

	boolean createUser(String userName, String password);

	boolean login(String userName, String password);

	User findUser(String userName);

}