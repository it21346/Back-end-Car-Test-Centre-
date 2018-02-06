package gr.dit.hua.service;

import java.util.List;

import gr.dit.hua.entity.Appointment;
import gr.dit.hua.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer getCustomer(int ID);

	public void deleteCustomer(int iD);

	public boolean exists(Customer customer);

	public List<Appointment> getAppointments();

	public void saveAppointment(Appointment appointment);
	
	public Appointment getAppointment(int ID);
	
	public void updateAppointment(Appointment appointment);

}
