package gr.dit.hua.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "date")
	private String date;

	@Column(name = "status")
	private String status;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer_appoint;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer_appoint() {
		return customer_appoint;
	}

	public void setCustomer_appoint(Customer customer_appoint) {
		this.customer_appoint = customer_appoint;
	}

	@Override
	public String toString() {
		return "Appointment [ID=" + ID + ", date=" + date + ", status=" + status + "]";
	}

	public Appointment(int iD, String date, String status, Customer customer_appoint) {
		super();
		ID = iD;
		this.date = date;
		this.status = status;
		this.customer_appoint = customer_appoint;
	}

	public Appointment(String date) {
		super();
		this.date = date;
	}

	
}
	