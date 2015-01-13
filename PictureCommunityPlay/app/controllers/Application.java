package controllers;

import models.User;
import views.html.index;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

public class Application extends Controller {

	@Security.Authenticated(Secured.class)
	public static Result index() {
		return ok(index.render("Welcome to the Picture Community"));
	}
	


	
	
}
