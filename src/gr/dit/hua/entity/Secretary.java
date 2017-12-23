package gr.dit.hua.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "secretary")
public class Secretary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "id_system")
	private String id_system;


	public Secretary() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public String getId_system() {
		return id_system;
	}

	public void setId_system(String id_system) {
		this.id_system = id_system;
	}

	@Override
	public String toString() {
		return "Secretary [ID=" + ID + ", name=" + name + ", surname=" + surname + ", id_system=" + id_system + "]";
	}
}