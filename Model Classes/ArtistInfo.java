package artistinfo.domain;

/**
 * Artist_info object
 * 
 * @author Sai Samarth
 * 
 */
public class ArtistInfo {
	/*
	 * Correspond to the artist_info table
	 */
	
	private String name;
	private String email;
	
	 public ArtistInfo(String name, String email) {
	        this.name = name;
	        this.email = email;
	    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Artist Info [ name=" + name + ", email=" + email +"]";
	}
}
