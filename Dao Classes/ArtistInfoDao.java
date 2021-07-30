import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
/**
 * ArtistInfoDao.java
 * This DAO class provides CRUD database operations for the table artistInfo
 * in the database.
 * @author Sai Samarth
 *
 */
public class ArtistInfoDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ArtistInfoDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
     
    public boolean insertArtistInfo(ArtistInfo artistInfo) throws SQLException {
        String sql = "INSERT INTO artist_info (name, email) VALUES (?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, artistInfo.getName());
        statement.setString(2, artistInfo.getEmail());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<ArtistInfo> listAllArtistInfo() throws SQLException {
        List<ArtistInfo> listArtistInfo = new ArrayList<>();
         
        String sql = "SELECT * FROM artist_info";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
             
            ArtistInfo artistInfo = new ArtistInfo(name, email);
            listArtistInfo.add(artistInfo);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listArtistInfo;
    }
     
    public boolean deleteArtistInfo(ArtistInfo artistInfo) throws SQLException {
        String sql = "DELETE FROM artist_info where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, artistInfo.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateArtistInfo(ArtistInfo artistInfo) throws SQLException {
        String sql = "UPDATE artist_info SET song_id = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, artistInfo.getSong_Id());
        statement.setString(2, artist_info.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public ArtistInfo getArtistInfo(String id) throws SQLException {
        ArtistInfo artist_info = null;
        String sql = "SELECT * FROM artist_info WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            artist_info = new ArtistInfo(id, song_id);
        }
         
        resultSet.close();
        statement.close();
         
        return artist_info;
    }

}