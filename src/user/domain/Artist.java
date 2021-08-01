package user.domain;

public class Artist {
	
	private String artist_id;
	private String artist_name; 
	private String artist_email;
	
	public String getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(final String artist_id) {
		this.artist_id = artist_id;
	}

	public String getArtist_name() {
		return artist_name;
	}

	public void setArtist_name(final String artist_name) {
		this.artist_name = artist_name;
	}

	public String getArtist_email() {
		return artist_email;
	}

	public void setArtist_email(final String artist_email) {
		this.artist_email = artist_email;
	}

	
	@Override
	public String toString() {
		return "Artist List [artist_id=" + this.artist_id + ", artist_name="
				+ this.artist_name + ", artist_email=" + this.artist_email +"]";
	}
	
	
}
