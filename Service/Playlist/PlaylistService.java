package playlist.service;

import java.util.List;

import playlist.dao.PlaylistDao;
import playlist.domain.Playlist;


/**
 * 
 * @author changxin bai
 *
 */
public class PlaylistService {
	private PlaylistDao playlistDao = new PlaylistDao();
	
	/**
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Playlist form) throws PlaylistException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Playlist playlist = PlaylistDao.findById(form.getPlaylistId());
		if(playlist.getPlaylistName()!=null) throw new PlaylistException("This playlist id has been registered!");
		playlistDao.add(form);
	}
	
	
	/**
	 * @param form
	 * @return
	 * @throws PlaylistException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return playlistDao.findall();
		
	}
	
	public void updatePlaylist(Playlist playlist) throws ClassNotFoundException, InstantiationException, IllegalAccessException, PlaylistException {
		Playlist a = playlistDao.findById(playlist.getPlaylistId());
		if(a.getPlaylistName()==null) throw new PlaylistException("The playlist is not in the database");
		playlistDao.updatePlaylist(playlist);
	}
	
	public void deletePlaylist(Playlist playlist) throws ClassNotFoundException, InstantiationException, IllegalAccessException, PlaylistException {
		Playlist a = playlistDao.findById(playlist.getPlaylistId());
		if(a.getPlaylistName() == null) throw new PlaylistException("The playlist is not in the database");
		playlistDao.deletePlaylist(playlist);
	}
	
	
}