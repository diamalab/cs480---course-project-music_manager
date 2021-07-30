playlist.domain
public class Playlist {
	/*
	 * Correspond to the playlist table
	 */
	
	private String id;
	private String song_id;
	
	 public Playlist(String id, String song_id) {
	        this.id = id;
	        this.song_id = song_id;
	    }

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSong_Id() {
		return song_id;
	}

	public void setSong_Id(String song_id) {
		this.song_id = song_id;
	}
	
	@Override
	public String toString() {
		return "Playlist [ id=" + id + ", song id="
				+ song_id + "]";
	}
}
