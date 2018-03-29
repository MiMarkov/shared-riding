package start.project1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	private String id;
	private String name;
	private List<Place> places = new ArrayList<Place>();
	
	public String getId()	{
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<String> getPlaces() {
		ArrayList<String> result = new ArrayList<String>();
		for (Place p : places) result.add(p.getId());
		return result;
	}
		
	public User() {	}
	
	public User(String userId, String name) {
		this.id = userId;
		this.name = name;
	}
	
	public void addPlace(Place place) {
		for (Place p : places) {
			if (p == place) return;
		}
		
		places.add(place);
	}

	public boolean hasBeenTo(Place place) {
		return places.contains(place);
	}
}
