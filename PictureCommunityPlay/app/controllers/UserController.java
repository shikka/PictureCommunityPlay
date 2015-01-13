package controllers;

import models.User;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.register;
import views.html.picturesPublic;

public class UserController extends Controller {

	public static class Registration {
		
		@Required
		public String email;
		@Required
		public String username;
		@Required
		public String password;
		
		public String validate(){

			if(User.findByName(username) != null)
				return "Username already taken";
	
			if(User.findByEmail(email) != null)
				return "Email already taken";
						
			return null;
					
		}
		
	}
	
	
	public static Result register() {
        return ok(register.render(Form.form(Registration.class)));
    }
	
	public static Result createUser() {
		Form<Registration> userForm = Form.form(Registration.class).bindFromRequest();
		if (userForm.hasErrors()) {
			return badRequest(register.render(userForm));
		} else {
			User.create(userForm.get().email, userForm.get().username ,userForm.get().password);
			return redirect(routes.Application.index());
		}		
	}
	
	public static Result allUser() {
		return ok(picturesPublic.render(User.all()));
	}

}
