package start.project1;

// we need this because Ui5 wants objects to have key-value pairs
// and the normal User contains a list of places
// which we don't need in most cases
public class Ui5UserInfo {

	private String id;
	private String name;
	
	public Ui5UserInfo() {
		
	}
	
	public Ui5UserInfo(User user) {
		id = user.getId();
		name = user.getName();
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
