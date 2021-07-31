// artist.domain
/**
 * Artist object
 * 
 * @author Sai Samarth
 * 
 */
public class Artist {
	/*
	 * Correspond to the artist table
	 */
	
	private String artist_id;
	private String artist_name; 
	private String artist_email;
	
	 public Artist(String artist_id, String artist_name, String artist_email) {
	        this.artist_id = artist_id;
	        this.artist_name = artist_name;
		this.artist_email = artist_email;
	    }
	
	public String getArtistID() {
		return id;
	}

	public void setArtistID(String id) {
		this.id = id;
	}

	public String getName() {
		return artist_name;
	}

	public void setName(String artist_name) {
		this.artist_name = artist_name;
	}

	public String getEmail() {
		return artist_email;
	}

	public void setEmail(String artist_email) {
		this.artist_email = artist_email;
	}

	
	@Override
	public String toString() {
		return "Artist [ artist_id=" + artist_id + ", artist_name="
				+ artist_name + ", artist_email=" + artist_email +"]";
	}
}
