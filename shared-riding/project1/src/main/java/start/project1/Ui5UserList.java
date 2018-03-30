package start.project1;

import java.util.ArrayList;
import java.util.List;

public class Ui5UserList {
	
	private List<Ui5UserInfo> users = new ArrayList<Ui5UserInfo>();
	
	public Ui5UserList() {
		
	}
	
	public List<Ui5UserInfo> getUsers() {
		return users;
	}
	
	public void add(Ui5UserInfo u) {
		users.add(u);
	}
}
