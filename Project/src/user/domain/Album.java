package user.domain;

public class Album {

	private int album_id;
    private String album_name;
    private int artist_id;
    private String genre;

    
    public int getAlbum_id() {
        return this.album_id;
    }
    
    public void setAlbum_id(final int album_id) {
        this.album_id = album_id;
    }
    
    public String getAlbum_name() {
        return this.album_name;
    }
    
    public void setAlbum_name(final String album_name) {
        this.album_name = album_name;
    }
    
    public int getArtist_id() {
        return this.artist_id;
    }
    
    public void setArtist_id(final int artist_id) {
        this.artist_id= artist_id;
    }
    
    public int getGenre() {
        return this.artist_id;
    }
    
    public void setGenre(final String genre) {
        this.genre = genre;
    }
   
    
    @Override
    public String toString() {
        return "All Albums [album_id=" + this.album_id + 
        		", album_name=" + this.album_name+
        		", artist_id=" + this.artist_id + 
        		", genre=" + this.genre + 
        		"]";
    }
}
