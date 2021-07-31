// playlist.domain
public class Playlist {
/**
 * Playlist object
 * 
 * @author Sai Samarth
 * 
 */
	
        private String playlist_id;
	private String playlist_name;
	private String user_id;
	
	 public Playlist(String playlist_id, String playlist_name, String user_id) {
	       this.playlist_id = playlist_id;
           this.playlist_name = playlist_name;
           this.user_id = user_id;
	    }

	
	public String getPlaylistId() {
		return playlist_id;
	}

	public void setPlaylistId(String id) {
		this.playlist_id = id;
	}

	public String getPlaylistName() {
		return playlist_name;
	}

	public void setSong_Id(String name) {
		this.playlist_name = name;
	}
	
	public String getUserID() {
        return user_id;
	}

    public void setUserId(String id) {
        this.user_id = id;
    }

	
	@Override
	public String toString() {
		return "Playlist [ playlist_id=" + playlist_id + ", playlist_name ="
				+ playlist_name + ", user_id =" + user_id +  "]";
	}
}
