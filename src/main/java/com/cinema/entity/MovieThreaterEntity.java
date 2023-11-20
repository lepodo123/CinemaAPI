package com.cinema.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie_threater")
public class MovieThreaterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "seat")
	private String seat;
	@Column(name = "time")
	private String time;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    private FilmEntity film;
	
	@OneToMany(mappedBy = "movieThreater", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<TicketEntity> tickets = new ArrayList<>();
	
	public MovieThreaterEntity(long id, String seat, String time) {
		super();
		this.id = id;
		this.seat = seat;
		this.time = time;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public FilmEntity getFilm() {
		return film;
	}
	public void setFilm(FilmEntity film) {
		this.film = film;
	}
	public List<TicketEntity> getTickets() {
		return tickets;
	}
	public void setTickets(List<TicketEntity> tickets) {
		this.tickets = tickets;
	}
	
	
}
