package user.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.Album;
import user.domain.Artist;
import user.domain.Song;
import user.domain.User;
import user.service.AlbumService;
import user.service.ArtistService;
import user.service.SongService;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

public class AlbumServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumServletDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Map<String, String> form = new HashMap<String,String>();
		AlbumService userservice = new AlbumService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Album form = new Album();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		form.setAlbum_id(Integer.parseInt((info.get(1))));
	
		try {
			userservice.delete(form);
			
			response.sendRedirect( request.getContextPath() + "/jsps/Album/top-album.jsp");
		} catch (ClassNotFoundException | UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
