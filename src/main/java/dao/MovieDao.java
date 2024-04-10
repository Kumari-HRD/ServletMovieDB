package dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;
import dto.Movie;

public class MovieDao 
{

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dbservlet");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void saveMovie(Movie movie)
	{
		transaction.begin();
		manager.persist(movie);
		transaction.commit();
	}
	
	public List<Movie> ViewAllMovies() {
	    List<Movie> l = manager.createQuery("select m from Movie m").getResultList();
	    return l;
	}

	public Movie ViewByMovieName(int movie_id) {
		Movie m=manager.find(Movie.class, movie_id);
	    return m;
	}
	
}
