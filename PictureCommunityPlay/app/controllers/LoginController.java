package controllers;


import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import models.User;
import views.html.login;

public class LoginController extends Controller{

	public static class Login {

		public String username;
		public String password;

		public String validate() {
			if (User.authenticate(username, password) == null) {
				return "Invalid user or password";
			}
			return null;
		}
	}
	
	public static Result login() {
        return ok(login.render(Form.form(Login.class)));
    }
		
	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			session().clear();
			session("username", loginForm.get().username);
			return redirect(routes.Application.index());
		}
	}
	
	@Security.Authenticated(Secured.class)
	public static Result logout() {
		session().clear();
	    return redirect(routes.Application.index());
	}

	public static boolean isLoggedIn(){
		return session().containsKey("username");
	}
	
	
	
}
