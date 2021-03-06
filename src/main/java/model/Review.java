package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Review {
	@Id
	@GeneratedValue
	private long id;
	private Date datetimeOfCreation;
	@ManyToOne(cascade = CascadeType.ALL)
	private VideoArt reviewed;
	private int rating;
	@Column(length=5000)
	private String text;

	public Date getDatetimeOfCreation() {
		return datetimeOfCreation;
	}

	public void setDatetimeOfCreation(Date datetimeOfCreation) {
		this.datetimeOfCreation = datetimeOfCreation;
	}

	public VideoArt getReviewed() {
		return reviewed;
	}

	public void setReviewed(VideoArt reviewed) {
		this.reviewed = reviewed;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
