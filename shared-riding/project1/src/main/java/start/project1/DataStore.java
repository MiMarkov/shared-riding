package start.project1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataStore {
	
	@Autowired
	PlaceRepository placeRepo;
	@Autowired
	UserRepository userRepo;

	private List<User> users = new ArrayList<User>();
	private List<Place> places = new ArrayList<Place>();
	
	private boolean loadedFromDb = false;
	
	public DataStore() {
	}
	
	public void loadFromDb() {
		if (loadedFromDb) return;
		loadedFromDb = true;
		
		for (Place p : placeRepo.findAll())	{
			places.add(p);
		}
		
		for (User u : userRepo.findAll() ) {
			users.add(u);
		}
	}
	
	public List<String> getUsers() {
		loadFromDb();
		
		ArrayList<String> result = new ArrayList<String>();
		for (User u : users) result.add(u.getId());
		return result;
	}
	
	public Ui5UserList getUi5Users() {
		loadFromDb();
		
		Ui5UserList result = new Ui5UserList();
		for (User u : users) result.add(new Ui5UserInfo(u));
		return result;
	}
	
	public List<String> getPlaces() {
		loadFromDb();
		
		ArrayList<String> result = new ArrayList<String>();
		for (Place p : places) result.add(p.getId());
		return result;
	}
	
	public User getUserById(String searchId) {
		loadFromDb();
		
		for (User u : users) {
			if (u.getId().equalsIgnoreCase(searchId)) return u;
		}
		
		return null;
	}
	
	public Place getPlaceById(String searchId) {
		loadFromDb();
		
		for (Place p : places) {
			if (p.getId().equalsIgnoreCase(searchId)) return p;
		}
		
		return null;
	}
	
	public boolean addUser(User newUser) {
		loadFromDb();
		
		for (User u : users) {
			if (u.getId().equalsIgnoreCase(newUser.getId())) return false;
		}
		
		users.add(newUser);
		userRepo.save(newUser);
		return true;
	}
	
	public boolean addPlace(Place newPlace) {
		loadFromDb();
		
		for (Place p : places) {
			if (p.getId().equalsIgnoreCase(newPlace.getId())) return false;
		}
		
		places.add(newPlace);
		placeRepo.save(newPlace);
		return true;
	}

	public List<String> getUsersAtPlace(Place place) {
		loadFromDb();
		
		ArrayList<String> result = new ArrayList<String>();
		for (User user : users) {
			if (user.hasBeenTo(place)) result.add(user.getId());
		}
		
		return result;
	}
	
	public List<String> getUsersAtPlace(String placeId) {
		return getUsersAtPlace(getPlaceById(placeId));
	}
	
	public void updateUser(User user, Place place) {
		user.addPlace(place);
		userRepo.save(user);
	}
}
