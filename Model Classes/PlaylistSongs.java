// playlistsongs.domain
public class PlaylistSongs {
	/*
	 * Correspond to the playlist_songs table
	 */
	
    private int playlist_songs_id;
	private int playlist_id;
	private int song_id;
	
	 public Playlist(int playlist_songs_id, int playlist_id, int song_id) {
	       this.playlist_songs_id = playlist_songs_id;
           this.playlist_id = playlist_id;
           this.song_id = song_id;
	    }

	
	public int getPlaylistSongsId() {
		return playlist_songs_id;
	}

	public void setPlaylistSongsId(int id) {
		this.playlist_songs_id = id;
	}

	public int getPlaylistId() {
		return playlist_id;
	}

	public void setPlaylist_Id(int id) {
		this.playlist_id = id;
	}

    public int getSongID() {
        return song_id;
    }

    public void setSongId(int id) {
        this.song_id = id;
    }

	
	@Override
	public String toString() {
		return "PlaylistSongs [ playlist__songs_id=" + playlist_songs_id + ", playlist_id ="
				+ playlist_id + ", song_id =" + song_id +  "]";
	}
}