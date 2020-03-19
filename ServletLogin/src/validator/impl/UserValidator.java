package validator.impl;

import domain.User;
import exception.IllegalObjectException;
import exception.PasswordNotValidException;
import exception.UsernameNotValidException;
import validator.Validator;

public class UserValidator implements Validator {

	@Override
	public void test(Object object) throws IllegalObjectException, UsernameNotValidException, PasswordNotValidException, IllegalArgumentException  {
		
		if(!(object instanceof User)) throw new IllegalObjectException("Not valid object");
		
		User user = (User) object;
		if(user.getUsername().isEmpty() && user.getPassword().isEmpty()) throw new IllegalArgumentException();
		if(user.getUsername().isEmpty()) throw new UsernameNotValidException("Username cannot be empty");
		if(user.getPassword().isEmpty()) throw new PasswordNotValidException("Password cannot be empty");
	}

}
