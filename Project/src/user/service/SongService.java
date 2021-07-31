package user.service;


import java.util.List;

import user.dao.SongDao;
import user.domain.Song;

public class SongService {
private SongDao songDao;
    
    public SongService() {
        this.songDao = new SongDao();
    }
    
    public void regist(final Song form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.songDao.add(form);
    }
    
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return songDao.findallSongs();
		
	}
    
    public void update(final Song form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.songDao.update(form);
    }
    
    public void delete(final Song form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.songDao.delete(form);
    }
    
}
