package user.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.Song;
import user.dao.SongDao;
import user.dao.UserDao;
import user.domain.User;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

public class UserServerSongManagement extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SongDao songDAO;
 
    public UserServerSongManagement() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertSong(request, response);
                break;
            case "/delete":
                deleteSong(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateSong(request, response);
                break;
            default:
            	listSong(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
	private void listSong(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Song> listSongs = songDAO.listAllSongs();
        request.setAttribute("list", listSongs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Song_CRUD.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("SongForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Song_ID"));
        Song existingBook = songDAO.getSong(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SongForm.jsp");
        request.setAttribute("song", existingBook);
        dispatcher.forward(request, response);
 
    }
 
    private void insertSong(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int song_id= Integer.parseInt(request.getParameter("Song_ID"));
        String name = request.getParameter("Song_Name");
        int artist = Integer.parseInt(request.getParameter("Artist_ID"));
 
        Song newSong = new Song(song_id, name, artist);
        songDAO.insertSong(newSong);
        response.sendRedirect("list");
    }
 
    private void updateSong(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("Song_ID"));
        String name = request.getParameter("Song_Name");
        int artist = Integer.parseInt(request.getParameter("Artist_ID"));
 
        Song song = new Song(id, name, artist);
        SongDao.updateSong(song);
        response.sendRedirect("list");
    }
 
    private void deleteSong(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("Song_ID"));
 
        Song book = new Song(id);
        SongDao.deleteBook(book);
        response.sendRedirect("list");
 
    }

}
