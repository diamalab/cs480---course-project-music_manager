package user.service;


import java.util.List;

import user.dao.AlbumDao;
import user.dao.ArtistDao;
import user.dao.SongDao;
import user.domain.Artist;
import user.domain.Song;

public class SimpleQueries {
private ArtistDao artistDao;
private AlbumDao albumDao;
private SongDao songDao;

    public SimpleQueries() {
        this.artistDao = new ArtistDao();
        this.albumDao = new AlbumDao();
        this.songDao = new SongDao();

    }
    
	public List<Object> SQ1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return artistDao.sq1();
	}
    
    public void regist(final Artist form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.artistDao.add(form);
    }
    
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return artistDao.findallArtist();
		
	}
    
    public void update(final Artist form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.artistDao.update(form);
    }
    
    public void delete(final Artist form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.artistDao.delete(form);
    }
    
}
