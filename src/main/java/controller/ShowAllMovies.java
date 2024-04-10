package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


import dao.MovieDao;
import dto.Movie;


@WebServlet("/showall-movies")
public class ShowAllMovies extends HttpServlet 
{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	MovieDao dao = new MovieDao();
        List<Movie> list = dao.ViewAllMovies();
        if(list.isEmpty())
        {
        	resp.getWriter().print("<h1 style 'color:red' align='center'> No Movies added Yet </h1>");
        	req.getRequestDispatcher("home.html").include(req, resp); 
        }
        else
        {
        	resp.getWriter().print("<html><body><div align='center' <table border='1'>");
    		resp.getWriter().print("<tr>");
    		resp.getWriter().print("<th> Name </th>");
    		resp.getWriter().print("<th> Image </th>");
    		resp.getWriter().print("<th> Genre </th>");
    		resp.getWriter().print("<th> Language </th>");
    		resp.getWriter().print("<th> Rating </th>");
    		resp.getWriter().print("<th> Edit</th>");
    		resp.getWriter().print("<th> Delete </th>");
        	for (Movie movie : list) 
        	{
        		
        		
        		
        		resp.getWriter().println("Movie Name " +movie.getName() + " Movie Language " + movie.getLanguage() + " Movie Rating "+  movie.getRating() + " Movie Genre=" + movie.getGenre());;
        		resp.getWriter().println(" ");
        	}
			resp.getWriter().print("<h1> Movie Added Successfully </h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	     
    }
   
    
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
    {
    	
    }
}
    		





