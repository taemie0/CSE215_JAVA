
public abstract class User implements Action {
	public String email, id, name, password;

	public User(String email, String password, String id, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.id = id;
	}
}
