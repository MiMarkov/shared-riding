package start.project1;

import java.util.ArrayList;
import java.util.List;

// we need this because of Ui5
// in order to populate the list it wants a JSON where one of the objects is a named list
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
