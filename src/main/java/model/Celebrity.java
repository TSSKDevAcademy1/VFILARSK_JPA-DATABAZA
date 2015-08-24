package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Celebrity {
	@Id
	@GeneratedValue
	private long id;
	private String surname;
	private String firstName;
	private Date dateOfBirth;
	@Column(length=3000)
	private String biography;
	@ManyToMany(mappedBy="directors")
	private List<VideoArt> directed = new ArrayList<VideoArt>();
	@ManyToMany(mappedBy="actors")
	private List<VideoArt> actedAt = new ArrayList<VideoArt>();

	public Celebrity(){
		
	}
	public Celebrity(String surname,String firstName, Date dateOfBirth,String biography){
		this.surname = surname;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.biography = biography;
	}
	
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<VideoArt> getDirected() {
		return directed;
	}

	public void setDirected(List<VideoArt> directed) {
		this.directed = directed;
	}

	public List<VideoArt> getActedAt() {
		return actedAt;
	}

	public void setActedAt(List<VideoArt> actedAt) {
		this.actedAt = actedAt;
	}

	public void addDirected(VideoArt videoArt){
		directed.add(videoArt);
	}
	
	public void addActedAt(VideoArt videoArt){
		actedAt.add(videoArt);
	}
	
}
