import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
/**
 * ArtistDao.java
 * This DAO class provides CRUD database operations for the table artist
 * in the database.
 * @author Sai Samarth
 *
 */
public class ArtistDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ArtistDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
     
    public boolean insertArtist(Artist artist) throws SQLException {
        String sql = "INSERT INTO artist (id, name, keyword) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, artist.getId());
        statement.setString(2, artist.getName());
        statement.setString(3, artist.getKeyword());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Artist> listAllArtists() throws SQLException {
        List<Artist> listArtist = new ArrayList<>();
         
        String sql = "SELECT * FROM artist";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String keyword = resultSet.getString("keyword");
             
            Artist artist = new Artist(id, name, keyword);
            listArtist.add(artist);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listArtist;
    }
     
    public boolean deleteArtist(Artist artist) throws SQLException {
        String sql = "DELETE FROM artist where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, artist.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateArtist(Artist artist) throws SQLException {
        String sql = "UPDATE artist
         SET name = ?, keyword = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, artist.getName());
        statement.setString(2, artist.getKeyword());
        statement.setString(3, artist.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Artist getArtist(String id) throws SQLException {
        Artist artist = null;
        String sql = "SELECT * FROM artist WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String keyword = resultSet.getString("keyword");
             
            artist = new Artist(id, name, keyword);
        }
         
        resultSet.close();
        statement.close();
         
        return artist;
    }

}
