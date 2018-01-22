package gr.dit.hua.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "model")
	private String model;

	@Column(name = "registration_number")
	private String registration_number;

	public enum type_of_vehicle {
		Fortigo, Epivatigo
	}

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private type_of_vehicle Type;

	@Column(name = "date")
	private String date;

	@Column(name = "owner_name")
	private String owner_name;

	@Column(name = "owner_surname")
	private String owner_surname;
		
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "TIME_OF_ARRIVAL")
	private String TIME_OF_ARRIVAL;

	@Column(name = "Fee")
	private float fee;

	@Column(name = "CC")
	private int cc;

	@Column(name = "STATUS")
	private String status;

	public Vehicle() {

	}

	public Vehicle(String model, String registration_number, type_of_vehicle type, String date, String owner_name,
			String owner_surname, Customer customer_id) {
		super();
		this.model = model;
		this.registration_number = registration_number;
		Type = type;
		this.date = date;
		this.owner_name = owner_name;
		this.owner_surname = owner_surname;
		this.customer = customer_id;
	}

	public int getCC() {
		return cc;
	}

	public void setCC(int cc) {
		this.cc = cc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String Status) {
		this.status = Status;
	}
	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public String getTIME_OF_ARRIVAL() {
		return TIME_OF_ARRIVAL;
	}

	public void setTIME_OF_ARRIVAL(String tIME_OF_ARRIVAL) {
		TIME_OF_ARRIVAL = tIME_OF_ARRIVAL;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistration_number() {
		return registration_number;
	}

	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}

	public type_of_vehicle getType() {
		return Type;
	}

	public void setType(type_of_vehicle type) {
		Type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getOwner_surname() {
		return owner_surname;
	}

	public void setOwner_surname(String owner_surname) {
		this.owner_surname = owner_surname;
	}

	public Customer getCustomer_id() {
		return customer;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer = customer_id;
	}

	@Override
	public String toString() {
		return "Vehicle [ID=" + ID + ", model=" + model + ", registration_number=" + registration_number + ", Type="
				+ Type + ", date=" + date + ", owner_name=" + owner_name + ", owner_surname=" + owner_surname
				+ ", customer_id=" + customer + ", TIME_OF_ARRIVAL=" + TIME_OF_ARRIVAL + ", fee=" + fee + "]";
	}

}
