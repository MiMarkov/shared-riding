package start.project1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DataStore {

	private List<User> users = new ArrayList<User>();
	private List<Place> places = new ArrayList<Place>();
	
	public DataStore() {

		Place p1 = new Place("sofia", "Sofia");
		Place p2 = new Place("varna", "Varna");
		Place p3 = new Place("london", "London");
		
		places.add(p1);
		places.add(p2);
		places.add(p3);
		
		User user = new User("John", "John Doe");
		user.addPlace(p1);
		user.addPlace(p3);
		users.add(user);
		
		user = new User("Jack", "Jack The Ripper");
		user.addPlace(p1);
		users.add(user);
		
		user = new User("Jason", "Jason Hudson");
		user.addPlace(p1);
		user.addPlace(p2);
		users.add(user);
		
		user = new User("Donald", "Donald Trump");
		user.addPlace(p3);
		user.addPlace(p2);
		users.add(user);
	}
	
	public List<String> getUsers() {
		ArrayList<String> result = new ArrayList<String>();
		for (User u : users) result.add(u.getId());
		return result;
	}
	
	public List<String> getPlaces() {
		ArrayList<String> result = new ArrayList<String>();
		for (Place p : places) result.add(p.getId());
		return result;
	}
	
	public User getUserById(String searchId) {
		for (User u : users) {
			if (u.getId().equalsIgnoreCase(searchId)) return u;
		}
		
		return null;
	}
	
	public Place getPlaceById(String searchId) {
		for (Place p : places) {
			if (p.getId().equalsIgnoreCase(searchId)) return p;
		}
		
		return null;
	}
	
	public boolean addUser(User newUser) {
		for (User u : users) {
			if (u.getId().equalsIgnoreCase(newUser.getId())) return false;
		}
		
		users.add(newUser);
		return true;
	}
	
	public boolean addPlace(Place newPlace) {
		for (Place p : places) {
			if (p.getId().equalsIgnoreCase(newPlace.getId())) return false;
		}
		
		places.add(newPlace);
		return true;
	}

	public List<String> getUsersAtPlace(Place place) {
		ArrayList<String> result = new ArrayList<String>();
		for (User user : users) {
			if (user.hasBeenTo(place)) result.add(user.getId());
		}
		
		return result;
	}
	
	public List<String> getUsersAtPlace(String placeId) {
		return getUsersAtPlace(getPlaceById(placeId));
	}
}
