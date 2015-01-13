package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class User extends Model {

	public static Finder<Long, User> find = new Finder<Long, User>(Long.class,User.class);

	@Id
	private Long id;

	@Required
	private String email;
	
	@Required
	private String username;

	@Required
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static List<User> all() {
		return find.all();
	}
	
	public static User findByName(String username) {
		return find.where().eq("username", username).findUnique();
	}

	public static User findByEmail(String email){
		return find.where().eq("email", email).findUnique();
	}
	
	/**
	 * @return the authenticated user or null if authentication failed
	 */
	public static User authenticate(String username, String password) {
		return find.where().eq("username", username).eq("password", password).findUnique();
	}

	public static User create(String email, String username, String password) {
		User user = new User();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.save();
		return user;
	}
}
