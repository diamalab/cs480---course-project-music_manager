package playlistsongs.service;

import java.util.List;

import playlistsongs.dao.PlaylistSongsDao;
import playlistsongs.domain.PlaylistSongs;


/**
 * 
 * @author changxin bai
 *
 */
public class PlaylistSongsService {
	private PlaylistSongsDao playlistSongsDao = new PlaylistSongsDao();
	
	/**
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(PlaylistSongs form) throws PlaylistSongsException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		PlaylistSongs playlistSongs = PlaylistSongsDao.findById(form.getPlaylistSongsId());
		if(genre.getPlaylistId()!=null) throw new PlaylistSongsException("This playlist_songs id has been registered!");
		playlistSongsDao.add(form);
	}
	
	
	/**
	 * @param form
	 * @return
	 * @throws PlaylistSongsException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return playlistSongsDao.findall();
		
	}
	
	public void updatePlaylistSongs(PlaylistSongs playlistSongs) throws ClassNotFoundException, InstantiationException, IllegalAccessException, PlaylistSongsException {
		PlaylistSongs p = playlistSongsDao.findById(playlistSongs.getPlaylistSongsId());
		if(p.getPlaylistId() ==null) throw new PlaylistSongsException("The playlist_songs is not in the database");
		playlistSongsDao.updatePlaylist(playlistSongs);
	}
	
	public void deletePlaylist(PlaylistSongs playlistSongs) throws ClassNotFoundException, InstantiationException, IllegalAccessException, PlaylistSongsException {
		PlaylistSongs p = playlistSongsDao.findById(playlistSongs.getPlaylistSongsId());
		if(p.getPlaylistId() == null) throw new PlaylistSongsException("The playlist_songs is not in the database");
		playlistSongsDao.deletePlaylist(playlistSongs);
	}
	
	
}