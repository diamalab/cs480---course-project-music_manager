// playlistsongs.domain
public class PlaylistSongs {
	/*
	 * Correspond to the playlist_songs table
	 */
	
    private String playlist_songs_id;
	private String playlist_id;
	private String song_id;
	
	 public Playlist(String playlist_songs_id, String playlist_id, String song_id) {
	       this.playlist_songs_id = playlist_songs_id;
           this.playlist_id = playlist_id;
           this.song_id = song_id;
	    }

	
	public String getPlaylistSongsId() {
		return playlist_songs_id;
	}

	public void setPlaylistSongsId(String id) {
		this.playlist_songs_id = id;
	}

	public String getPlaylistId() {
		return playlist_id;
	}

	public void setPlaylist_Id(String id) {
		this.playlist_id = id;
	}

    public String getSongID() {
        return song_id;
    }

    public void setSongId(String id) {
        this.song_id = id;
    }

	
	@Override
	public String toString() {
		return "PlaylistSongs [ playlist__songs_id=" + playlist_songs_id + ", playlist_id ="
				+ playlist_id + ", song_id =" + song_id +  "]";
	}
}
