package artist.service;

import java.util.List;

import artist.dao.ArtistDao;
import artist.domain.Artist;


/**
 * 
 * @author changxin bai
 *
 */
public class ArtistService {
	private ArtistDao artistDao = new ArtistDao();
	
	/**
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Artist form) throws GenreException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Artist artist = ArtistDao.findById(form.getArtistId());
		if(genre.getName()!=null) throw new GenreException("This artist id has been registered!");
		ArtistDao.add(form);
	}
	
	
	/**
	 * @param form
	 * @return
	 * @throws ArtistException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return ArtistDao.findall();
		
	}
	
	public void updateGenre(Artist artist) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ArtistException {
		Artist a = artistDao.findById(genre.getId());
		if(artist.getName()==null) throw new GenreException("The artist is not in the database");
		artistDao.updateArtist(artist);
	}
	
	public void deleteArtist(Artist artist) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ArtistException {
		Artist a = artistDao.findById(artist.getArtistId());
		if(artist.getName() == null) throw new GenreException("The artist is not in the database");
		artistDao.deleteArtist(artist);
	}
	
	
}