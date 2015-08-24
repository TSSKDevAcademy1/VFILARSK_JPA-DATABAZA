package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Inheritance
@DiscriminatorColumn(name="VIDEO_TYPE")
@Table(name="VIDEO")
public abstract class VideoArt {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int yearOfPublication;
	@ManyToMany
	private List<Genre> genres = new ArrayList<Genre>();
	@JoinTable(name="directors")
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Celebrity> directors = new ArrayList<Celebrity>();
	@JoinTable(name="actors")
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Celebrity> actors = new ArrayList<Celebrity>();
	@Override
	public String toString() {
		return "VideoArt [id=" + id + ", name=" + name + ", yearOfPublication=" + yearOfPublication + ", genres="
				+ genres + ", directors=" + directors + ", actors=" + actors + ", reviews=" + reviews
				+ ", additionalInfo=" + additionalInfo + "]";
	}

	@OneToMany(mappedBy="reviewed")
	private List<Review> reviews = new ArrayList<Review>();
	@ElementCollection(fetch = FetchType.LAZY)
	private List<String> additionalInfo = new ArrayList<String>();
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Celebrity> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Celebrity> directors) {
		this.directors = directors;
	}

	public List<Celebrity> getActors() {
		return actors;
	}

	public void setActors(List<Celebrity> actors) {
		this.actors = actors;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<String> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(List<String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	public void addDirectors(Celebrity celebrity){
		directors.add(celebrity);
	}
	
	public void addGenres(Genre genre){
		genres.add(genre);
	}
	
	public void addActors(Celebrity celebrity){
		actors.add(celebrity);
	}
	
	public void addReviews(Review review){
		reviews.add(review);
	}
	
	public void addAdditionalInfo(String string){
		additionalInfo.add(string);
	}
	
}
