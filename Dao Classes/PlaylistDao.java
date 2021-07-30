import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
/**
 * PlaylistDao.java
 * This DAO class provides CRUD database operations for the table playlist
 * in the database.
 * @author Sai Samarth
 *
 */
public class PlaylistDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public PlaylistDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertPlaylist(Playlist playlist) throws SQLException {
        String sql = "INSERT INTO playlist (id, song_id) VALUES (?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, playlist.getId());
        statement.setString(2, playlist.getSong_Id());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Playlist> listAllPlaylists() throws SQLException {
        List<Playlist> listPlaylist = new ArrayList<>();
         
        String sql = "SELECT * FROM playlist";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String song_id = resultSet.getString("song_id");
             
            Playlist playlist = new Playlist(id, song_id);
            listPlaylist.add(playlist);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listPlaylist;
    }
     
    public boolean deletePlaylist(Playlist playlist) throws SQLException {
        String sql = "DELETE FROM playlist where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, playlist.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updatePlaylist(Playlist playlist) throws SQLException {
        String sql = "UPDATE playlist SET song_id = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, playlist.getSong_Id());
        statement.setString(2, playlist.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Playlist getPlaylist(String id) throws SQLException {
        Playlist playlist = null;
        String sql = "SELECT * FROM playlist WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String song_id = resultSet.getString("song_id");
            playlist = new Playlist(id, song_id);
        }
         
        resultSet.close();
        statement.close();
         
        return playlist;
    }

}