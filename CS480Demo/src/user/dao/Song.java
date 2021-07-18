package user.dao;

public class Song {
	protected int id;
    protected String name;
    protected int artist;
 
    public Song() {
    }
 
    public Song(int id) {
        this.id = id;
    }
 
    public Song(int id, String name, int artist) {
        this (name, artist);
        this.id = id;
    }
     
    public Song(String name, int artist) {
        this.name = name;
        this.artist= artist;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getArtist() {
        return artist;
    }
 
    public void setArtist(int artist) {
        this.artist = artist;
    }
}
