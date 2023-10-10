package co.edu.uptc.users.interactor;

import co.edu.uptc.users.model.dtos.UserDto;
import co.edu.uptc.users.model.entity.User;

public interface UserInteractor {
	User createUser(UserDto userData);
}
