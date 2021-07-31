package user.domain;

public class Song {

	private String song_id;
    private String song_name;
    private String album_id;
    private String artist_id;

    
    public String getSong_id() {
        return this.song_id;
    }
    
    public void setSong_id(final String song_id) {
        this.song_id = song_id;
    }
    
    public String getSong_name() {
        return this.song_name;
    }
    
    public void setSong_name(final String song_name) {
        this.song_name = song_name;
    }
    
    public String getAlbum_id() {
        return this.album_id;
    }
    
    public void setAlbum_id(final String album_id) {
        this.album_id = album_id;
    }
    
    public String getArtist_id() {
        return this.artist_id;
    }
    
    public void setArtist_id(final String artist_id) {
        this.artist_id = artist_id;
    }
   
    
    @Override
    public String toString() {
        return "Portfolio [song_id=" + this.song_id + 
        		", song_name=" + this.song_name+
        		", album_id=" + this.album_id + 
        		", artist_id=" + this.artist_id + 
        		"]";
    }
}
