package user.domain;

public class Song {

	private int song_id;
    private String song_name;
    private int album_id;
    private int artist_id;

    
    public int getSong_id() {
        return this.song_id;
    }
    
    public void setSong_id(final int song_id) {
        this.song_id = song_id;
    }
    
    public String getSong_name() {
        return this.song_name;
    }
    
    public void setSong_name(final String song_name) {
        this.song_name = song_name;
    }
    
    public int getAlbum_id() {
        return this.album_id;
    }
    
    public void setAlbum_id(final int album_id) {
        this.album_id = album_id;
    }
    
    public int getArtist_id() {
        return this.artist_id;
    }
    
    public void setArtist_id(final int artist_id) {
        this.artist_id = artist_id;
    }
   
    
    @Override
    public String toString() {
        return "All Songs [song_id=" + this.song_id + 
        		", song_name=" + this.song_name+
        		", album_id=" + this.album_id + 
        		", artist_id=" + this.artist_id + 
        		"]";
    }
}
