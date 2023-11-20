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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "phone_nubmer")
	private String phoneNubmer;
	@Column(name = "level")
	private String level;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<TicketEntity> tickets = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "customer_voucher",
      joinColumns = @JoinColumn(name = "custonmer_id"),
      inverseJoinColumns = @JoinColumn(name = "voucher_id")
    )
	private List<VoucherEntity> vouchers = new ArrayList<>();
	
	@OneToOne(mappedBy = "customer")
    private AccountEntity account;

	public CustomerEntity(long id, String name, String phoneNubmer, String level) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNubmer = phoneNubmer;
		this.level = level;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNubmer() {
		return phoneNubmer;
	}

	public void setPhoneNubmer(String phoneNubmer) {
		this.phoneNubmer = phoneNubmer;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<TicketEntity> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketEntity> tickets) {
		this.tickets = tickets;
	}

	public List<VoucherEntity> getVouchers() {
		return vouchers;
	}

	public void setVouchers(List<VoucherEntity> vouchers) {
		this.vouchers = vouchers;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	
}
