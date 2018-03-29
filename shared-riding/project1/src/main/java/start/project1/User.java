package start.project1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	private String id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
			if (p.getId().equalsIgnoreCase(place.getId())) return;
		}
		
		places.add(place);
	}

	public boolean hasBeenTo(Place place) {
		for (Place p : places)
			if (p.getId().equalsIgnoreCase(place.getId())) return true;
		return false;
	}
}
