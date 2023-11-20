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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class TicketEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "ticket_code")
	private String ticketCode;
	@Column(name = "date")
	private String date;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "tickets")
	private List<FilmEntity> films = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_schedule_id", nullable = false)
    private MovieScheduleEntity movieSchedule;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_threater_id", nullable = false)
    private MovieThreaterEntity movieThreater;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "tickets")
	private List<FoodsEntity> foods = new ArrayList<>();
	
	@OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<VoucherEntity> vouchers = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;
	
	public TicketEntity(long id, String ticketCode, String date) {
		super();
		this.id = id;
		this.ticketCode = ticketCode;
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTicketCode() {
		return ticketCode;
	}
	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<FilmEntity> getFilms() {
		return films;
	}
	public void setFilms(List<FilmEntity> films) {
		this.films = films;
	}
	public MovieScheduleEntity getMovieSchedule() {
		return movieSchedule;
	}
	public void setMovieSchedule(MovieScheduleEntity movieSchedule) {
		this.movieSchedule = movieSchedule;
	}
	public MovieThreaterEntity getMovieThreater() {
		return movieThreater;
	}
	public void setMovieThreater(MovieThreaterEntity movieThreater) {
		this.movieThreater = movieThreater;
	}
	public List<FoodsEntity> getFoods() {
		return foods;
	}
	public void setFoods(List<FoodsEntity> foods) {
		this.foods = foods;
	}
	public List<VoucherEntity> getVouchers() {
		return vouchers;
	}
	public void setVouchers(List<VoucherEntity> vouchers) {
		this.vouchers = vouchers;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	
}
