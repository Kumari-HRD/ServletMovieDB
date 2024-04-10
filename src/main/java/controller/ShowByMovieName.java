package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MovieDao;
import dto.Movie;

@WebServlet("/showby-moviename")
public class ShowByMovieName extends HttpServlet
{

	 public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	    {
		    resp.getWriter().print("<h1 align='center'> This is View by Movie Name </h1>");
			int movie_id=Integer.parseInt(req.getParameter("movie_name"));	
			resp.getWriter().print("movie id=" + movie_id);
			MovieDao dao = new MovieDao();
	        Movie movie = dao.ViewByMovieName(movie_id);
	    
	        resp.getWriter().println("Movie Name " +movie.getName() + " Movie Language " + movie.getLanguage() + " Movie Rating "+  movie.getRating() + " Movie Genre=" + movie.getGenre());;
	        resp.getWriter().println(" ");
	        
			resp.getWriter().print("<h1 align='center'> Movie Added Successfully </h1>");
			req.getRequestDispatcher("home.html").include(req, resp);		
			
	    }
	
}



