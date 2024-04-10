package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MovieDao;
import dto.Movie;

@WebServlet("/insert-movie")
@MultipartConfig
public class InsertMovie extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("insert.html").forward(req, resp);
		//This is to make sure that the name of the html is not shown in the url- Secured now
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("<h1> This is my Servlet CRUD Operations Project </h1>");
		String movie_name=req.getParameter("movie_name");		
		String movie_lang=req.getParameter("movie_lang");
		Part movie_image=req.getPart("movie_image");
		String movie_genre=req.getParameter("movie_genre");	
		try 
		{
			double movie_rating =Double.parseDouble(req.getParameter("movie_rating"));
			//resp.getWriter().print(movie_name + " " + movie_lang + " " + movie_rating + " "+ movie_image + " " + movie_genre);
			
			Movie movie=new Movie();
			movie.setName(movie_name);
			movie.setLanguage(movie_lang);
			movie.setGenre(movie_genre);
			movie.setRating(movie_rating);
			
			byte[] image=new byte[movie_image.getInputStream().available()];
			movie_image.getInputStream().read(image);
			movie.setPicture(image);
			
			
			MovieDao dao=new MovieDao();
			
			dao.saveMovie(movie);
			//resp.getWriter().print(movie_name + " " + movie_lang + " " + movie_rating + " "+ movie_image + " " + movie_genre);
			
			resp.getWriter().print("<h1 align='center'> Movie Added Successfully </h1>");
			req.getRequestDispatcher("home.html").include(req, resp);		
		
		}
		catch(NumberFormatException e)
		{
			resp.getWriter().print("<h1 align='center'>Enter Proper Rating</h1>");
			req.getRequestDispatcher("insert.html").include(req, resp);					
		}										
	}
	
}


