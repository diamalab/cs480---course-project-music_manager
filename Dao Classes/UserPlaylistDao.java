import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
/**
 * UserPlaylistDao.java
 * This DAO class provides CRUD database operations for the table user_playlist
 * in the database.
 * @author Sai Samarth
 *
 */
public class UserPlaylistDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public UserPlaylistDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
     
    public boolean insertUserPlaylist(UserPlaylist user_playlist) throws SQLException {
        String sql = "INSERT INTO user_playlist (user_id, playlist) VALUES (?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user_playlist.getUserId());
        statement.setString(2, user_playlist.getPlaylist());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<UserPlaylist> listAllUserPlaylists() throws SQLException {
        List<UserPlaylist> listUserPlaylist = new ArrayList<>();
         
        String sql = "SELECT * FROM user_playlist";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int user_id = resultSet.getInt("user_id");
            int playlist = resultSet.getInt("playlist");
             
            UserPlaylist user_playlist = new UserPlaylist(user_id, playlist);
            listUserPlaylist.add(user_playlist);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listUserPlaylist;
    }
     
    public boolean deleteUserPlaylist(UserPlaylist user_playlist) throws SQLException {
        String sql = "DELETE FROM user_playlist where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, user_playlist.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateUserPlaylist(UserPlaylist user_playlist) throws SQLException {
        String sql = "UPDATE user_playlist SET song_id = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user_playlist.getSong_Id());
        statement.setString(2, user_playlist.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public UserPlaylist getUserPlaylist(String id) throws SQLException {
        UserPlaylist user_playlist = null;
        String sql = "SELECT * FROM user_playlist WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String song_id = resultSet.getString("song_id");
            user_playlist = new UserPlaylist(id, song_id);
        }
         
        resultSet.close();
        statement.close();
         
        return user_user_playlist;
    }

}