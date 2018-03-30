package start.project1;

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
