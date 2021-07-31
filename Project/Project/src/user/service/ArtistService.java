package user.service;


import java.util.List;

import user.dao.ArtistDao;
import user.domain.Artist;
import user.domain.Song;

public class ArtistService {
private ArtistDao artistDao;
    
    public ArtistService() {
        this.artistDao = new ArtistDao();
    }
    
    public void regist(final Artist form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.artistDao.add(form);
    }
    
	public List<Object> SQ1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return artistDao.sq1();
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
