package userplaylist.domain;

/**
 * User Playlist object
 * 
 * @author Sai Samarth
 * 
 */
public class UserPlaylist {
	/*
	 * Correspond to the user_playlist table
	 */
	
	private int user_id;
	private int playlist;
	
	 public UserPlaylist(int user_id, int playlist) {
	        this.user_id = user_id;
	        this.playlist = playlist;
	    }
	
	public int getUserId() {
		return user_id;
	}

	public void setUsername(int user_id) {
		this.user_id = user_id;
	}

	public int getPlaylist() {
		return playlist;
	}

	public void setPlaylist(int playlist) {
		this.playlist = playlist;
	}

	
	@Override
	public String toString() {
		return "User Playlist [ user_id=" + user_id + ", playlist=" + playlist +"]";
	}
}
