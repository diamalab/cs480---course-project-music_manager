package user.service;


import java.util.List;

import user.dao.AlbumDao;
import user.dao.SongDao;
import user.domain.Album;

public class AlbumService {
private AlbumDao albumDao;

    
    public AlbumService() {
        this.albumDao = new AlbumDao();
    }
    
    public void regist(final Album form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.albumDao.add(form);
    }
    
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return albumDao.findallAlbums();
		
	}
	
	public List<Object> SQ3() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return albumDao.sq3();
		
	}
    
    public void update(final Album form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.albumDao.update(form);
    }
    
    public void delete(final Album form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.albumDao.delete(form);
    }
    
}
