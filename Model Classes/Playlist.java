// playlist.domain
public class Playlist {
	/*
	 * Correspond to the playlist table
	 */
	
    private int playlist_id;
	private String playlist_name;
	private int user_id;
	
	 public Playlist(int playlist_id, String playlist_name, int user_id) {
	       this.playlist_id = playlist_id;
           this.playlist_name = playlist_name;
           this.user_id = user_id;
	    }

	
	public int getPlaylistId() {
		return playlist_id;
	}

	public void setPlaylistId(int id) {
		this.playlist_id = id;
	}

	public String getPlaylistName() {
		return playlist_name;
	}

	public void setSong_Id(String name) {
		this.playlist_name = name;
	}

    public int getUserID() {
        return user_id;
    }

    public void setUserId(int id) {
        this.user_id = id;
    }

	
	@Override
	public String toString() {
		return "Playlist [ playlist_id=" + playlist_id + ", playlist_name ="
				+ playlist_name + ", user_id =" + user_id +  "]";
	}
}