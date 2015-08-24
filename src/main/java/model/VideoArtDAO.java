package model;

import java.util.List;

public class VideoArtDAO {

	public void createMovie(Movie movie){
		JPAHelper.beginTransaction();
		JPAHelper.getEntityManager().persist(movie);
		JPAHelper.commitTransaction();
	}
	
	public void createMovie(TVSeries series){
		JPAHelper.beginTransaction();
		JPAHelper.getEntityManager().persist(series);
		JPAHelper.commitTransaction();
	}
	
	public void addDirector(VideoArt videoArt, Celebrity celebrity){
		videoArt.addDirectors(celebrity);
		celebrity.addDirected(videoArt);
		JPAHelper.beginTransaction();
		JPAHelper.getEntityManager().persist(celebrity);
		JPAHelper.getEntityManager().persist(videoArt);
		JPAHelper.commitTransaction();
		
	}
	
	public void addActor(VideoArt videoArt, Celebrity celebrity){
		videoArt.addActors(celebrity);
		celebrity.addActedAt(videoArt);
		JPAHelper.beginTransaction();
		JPAHelper.getEntityManager().persist(celebrity);
		JPAHelper.getEntityManager().persist(videoArt);
		JPAHelper.commitTransaction();
		
	}
	
	public void addReview(Review review, VideoArt videoArt){
		videoArt.addReviews(review);
		review.setReviewed(videoArt);
	}
	
	public void listFilmInYear(int year){
		JPAHelper.beginTransaction();
		List<Movie> movies = JPAHelper.getEntityManager().createQuery("select DISTINCT c FROM Movie c WHERE c.yearOfPublication = :year", Movie.class).setParameter("year", year).getResultList();
		for(Movie movie :  movies){
			System.out.println(movie);
		}
		JPAHelper.commitTransaction();
	}
	
	public void listFilmWithActor(String celebrityName){
		JPAHelper.beginTransaction();
		List<Movie> movies = JPAHelper.getEntityManager().createQuery("select DISTINCT movie FROM Movie as movie JOIN movie.actors as actors WHERE actors.firstName = :celebrityName", Movie.class).setParameter("celebrityName", celebrityName).getResultList();
		for(Movie movie :  movies){
			System.out.println(movie);
		}
		JPAHelper.commitTransaction();
	}
	
	public void countOfAllSerials(){
		int count = 0;
		JPAHelper.beginTransaction();
		List<TVSeries> series = JPAHelper.getEntityManager().createQuery("select c FROM TVSeries c", TVSeries.class).getResultList();
		for(TVSeries serie :  series){
			count++;
		}
		System.out.println("Pocet vsetkych serialov je "+ count);
		JPAHelper.commitTransaction();
	}
	
	public void countOfAllMovies(){
		int count = 0;
		JPAHelper.beginTransaction();
		List<Movie> movies = JPAHelper.getEntityManager().createQuery("select c from Movie c", Movie.class).getResultList();
		for(Movie movie :  movies){
			count ++;
		}
		System.out.println("Pocet filmov v databaze je "+ count);
		JPAHelper.commitTransaction();
	}
	
	public void filmSerialsOfGenres(String genre){
		JPAHelper.beginTransaction();
		List<VideoArt> videos = JPAHelper.getEntityManager().createQuery("select video FROM VideoArt as video JOIN video.genres as genres WHERE genres.name = :genre", VideoArt.class).setParameter("genre", genre).getResultList();
		for(VideoArt video :  videos){
			System.out.println(video);
		}
		
		JPAHelper.commitTransaction();
	}
	
	public void movieWithRating(int rating){
		JPAHelper.beginTransaction();
		List<Movie> movies = JPAHelper.getEntityManager().createQuery("select movie FROM Movie as movie JOIN movie.reviews as reviews WHERE reviews.rating >= :rating", Movie.class).setParameter("rating", rating).getResultList();
		for(Movie movie :  movies){
			System.out.println(movie);
		}
		
		JPAHelper.commitTransaction();
	}
	
	public void countOfFilmGenre(String genre){
		int count = 0;
		JPAHelper.beginTransaction();
		List<Movie> movies = JPAHelper.getEntityManager().createQuery("select movie FROM Movie as movie JOIN movie.genres as genres WHERE genres.name = :genre", Movie.class).setParameter("genre",genre).getResultList();
		for(Movie movie :  movies){
			count ++;
		}
		System.out.println("Pocet filmov zvoleneho zanru je v databaze  "+ count);
		JPAHelper.commitTransaction();
	}
	
	public void movieWithBestRating(){
		JPAHelper.beginTransaction();
		List<Movie> movies = JPAHelper.getEntityManager().createQuery("select movie FROM Movie as movie JOIN movie.reviews as reviews WHERE reviews.rating = (select max(reviews.rating) from Review as reviews)", Movie.class).getResultList();
		for(Movie movie :  movies){
			System.out.println(movie);
		}
		JPAHelper.commitTransaction();
	}
	
}	

