package gr.dit.hua.dao;

import java.util.List;

import gr.dit.hua.entity.Appointment;
import gr.dit.hua.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int iD);

	public void updateCustomer(Customer customer);

	public boolean exists(Customer customer);

	public List<Appointment> getAppointments();

	public void saveAppointment(Appointment appointment);
}
