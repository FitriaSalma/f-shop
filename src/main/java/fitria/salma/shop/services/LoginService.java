package fitria.salma.shop.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fitria.salma.shop.entities.UserEntity;
import fitria.salma.shop.repositories.UserRepository;
import fitria.salma.shop.utils.CustomException;

@Service
public class LoginService {
	
	@Autowired
	UserRepository ur;
	
	public UserEntity login(String username, String password) throws CustomException {
		Boolean isUsernameExists = ur.isUsernameExists(username);
		if(!isUsernameExists) {
			throw new CustomException(452, "Email atau Password salah");
		}
		
		UserEntity user = ur.getUserByUsername(username);
		
		Boolean isLoginSuccess = ur.isLoginSuccess(username, password);
		if(!isLoginSuccess) {
			throw new CustomException(452, "Email atau Password salah");
		} else {
			user.setModified_by(1L);
			user.setModified_on(new Date());
			user = ur.save(user);
			
			UserEntity userLogin = new UserEntity();
			userLogin.setId(user.getId());
			userLogin.setIs_admin(user.getIs_admin());
			
			return userLogin;
		}
		
	}
	

}
