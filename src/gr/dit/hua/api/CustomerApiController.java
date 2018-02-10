package gr.dit.hua.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.dit.hua.entity.Appointment;
import gr.dit.hua.entity.AppointmentList;
import gr.dit.hua.entity.Customer;
import gr.dit.hua.entity.CustomerList;
import gr.dit.hua.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerApiController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerList customerList;

	@Autowired
	private AppointmentList appointmentList;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Customer getCustomer(@PathVariable("id") int id) {

		Customer customer = customerService.getCustomer(id);
		System.out.println("customer :" + customer);

		return customer;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = { "application/json",
			"application/xml" })
	public ResponseEntity deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public CustomerList getCustomers() {

		List<Customer> customers = customerService.getCustomers();
		System.out.println("customers :" + customers);
		this.customerList.setCustomerList(customers);
		return this.customerList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Customer createCustomer(@RequestParam("name") String firstName, @RequestParam("surname") String lastName,
			@RequestParam("email") String email) {
		Customer customer = new Customer(firstName, lastName, email);
		customerService.saveCustomer(customer);
		return customer;
	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public Customer createCustomerfromJson(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}

	@RequestMapping(value = "/appointment", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public Appointment createAppointment(@RequestParam("customer_id") int customer_ID, @RequestParam("date") String date) {
		Appointment appointment = new Appointment(date);
		appointment.setCustomer_appoint(customerService.getCustomer(customer_ID));
		appointment.setStatus("Unckecked");
		customerService.saveAppointment(appointment);
		return appointment;
	}

	@RequestMapping(value = "/allAppointments", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public AppointmentList getAppointments() {

		List<Appointment> appointments = customerService.getAppointments();
		System.out.println("appointments :" + appointments);
		this.appointmentList.setAppointmentList(appointments);
		return this.appointmentList;
	}
	
	@RequestMapping(value = "/loginCredentials", method = RequestMethod.POST , produces = {"application/json", "application/xml"})
	public Customer checkCredentials(@RequestParam("username") String username,@RequestParam("password") String password) {
		Customer customer = new Customer();
		customer.setName(username);
		customer.setSurname(password);
		int checkID = customerService.existsLogin(customer);
		if ( checkID != 0) {
			return customerService.getCustomer(checkID);
		}else {
			Customer customerNull = new Customer();
			return customerNull;
		}
	}
}