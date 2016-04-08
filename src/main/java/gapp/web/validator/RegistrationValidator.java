package gapp.web.validator;

import gapp.model.User;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class RegistrationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		User user=(User)target;
		if(!StringUtils.hasText(user.getFirst_name()))
		{
			errors.rejectValue("first_name", "error.firstname.required");
		}
		if(!StringUtils.hasText(user.getLast_name()))
		{
			errors.rejectValue("last_name", "error.last_name.required");
		}
		if(!StringUtils.hasText(user.getEmail_id()))
		{
			errors.rejectValue("email_id", "error.emailid.required");
		}
		if(!StringUtils.hasText(user.getPassword()))
		{
			errors.rejectValue("password", "error.password.required");
		}
	}

}
