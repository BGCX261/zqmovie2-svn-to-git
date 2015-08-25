package net.ziqiang.movie.struts.forms;

import java.util.*;
import net.ziqiang.movie.domain.User;
import net.ziqiang.movie.struts.Constants;
import com.littleqworks.commons.util.Filters;

import org.apache.struts.validator.ValidatorForm;

public class EditUserForm extends ValidatorForm {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
