package gr.dit.hua.entity;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3858123654245947650L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy="customer",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Vehicle> vehicles;
	
	public Customer() {
		
	}

	public Customer(String name, String surname, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Vehicle vehicle) {	
		vehicles.add(vehicle);	
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}
	
	public void addVehicle(Vehicle vehicle) {
		if(vehicles == null) {
			vehicles = new ArrayList<>();
		}
		vehicles.add(vehicle);
	}
	
}
