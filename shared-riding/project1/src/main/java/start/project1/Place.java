package start.project1;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Place {

	@Id
	private String id;
	private String name;
	private String imgUrl;
	
	public String getId() {
		return id;
	}
	
	public void setId(String value) {
		id = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String value) {
		imgUrl = value;
	}
	
	
	public Place() { }
	
	public Place(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
