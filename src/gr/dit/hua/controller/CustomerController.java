package gr.dit.hua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.dit.hua.entity.Appointment;
import gr.dit.hua.entity.Customer;
import gr.dit.hua.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customer service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

		// get customers from the service
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		model.addAttribute("customers", customers);

		// add page title
		model.addAttribute("pageTitle", "List Customers");
		return "list-customers";
	}

	@GetMapping("/appointments")
	public String listAppointments(Model model) {
		// get the appointments from the service
		List<Appointment> appointments = customerService.getAppointments();
		// add the appointments to the model
		model.addAttribute("appointments", appointments);
		// add page title
		model.addAttribute("pageTitle", "List Appointments");
		return "appointments";
	}

	@GetMapping("/showAppointmentUpdateForm/{ID}")
	public String showAppointmentUpdateForm(@PathVariable("ID") int ID, Model model) {
		Appointment appointment = customerService.getAppointment(ID);
		model.addAttribute("appointment", appointment);
		// add page title
		model.addAttribute("pageTitle", "Update Appointment");
		
		return "appointment-update-form";
	}

	@PostMapping("/updateAppointment/{customer_ID}/{ID}")
	public String updateAppointment(@PathVariable("ID") int appointment_ID,@PathVariable("customer_ID") int customer_ID,@ModelAttribute("appointment") Appointment appointment) {
		appointment.setCustomer_appoint(customerService.getCustomer(customer_ID));
		customerService.updateAppointment(appointment);
		return "redirect:/customer/appointments"; 
	}
	@GetMapping("/{ID}")
	public String getCustomer(Model model, @PathVariable("ID") int ID) {
		// get the customer
		Customer customer = customerService.getCustomer(ID);

		// add the customer to the model
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@GetMapping("/delete/{ID}")
	public String deleteCustomer(@PathVariable("ID") int ID, Model model) {
		customerService.deleteCustomer(ID);
		return "redirect:/customer/list";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		// add page title
		model.addAttribute("pageTitle", "Add Customer");
		return "customer-form";
	}

	@GetMapping("/showUpdateForm/{ID}")
	public String showUpdateForm(@PathVariable("ID") int ID, Model model) {
		// create model attribute to get form data
		Customer customer = new Customer();
		customer = customerService.getCustomer(ID);
		model.addAttribute("customer", customer);
		// add page title
		model.addAttribute("pageTitle", "Update Customer");
		return "customer-update-form";
	}

	@PostMapping("/cancel")
	public String cancelButton() {
		// return to the previous page
		return "redirect:/customer/list";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		// check if the customer we are trying to save,already exists
		if (customerService.exists(customer) == false) {
			// new customer,add using the service
			customerService.saveCustomer(customer);
			return "redirect:/customer/list";
		} else {
			System.out.println("User already exists!");
			model.addAttribute("errorr", "The customer already exists.Please try again!");
			return "customer-form";
		}
	}

	// https://stackoverflow.com/questions/5956897/passing-input-value-to-action-asp-net-mvc-3
	@PostMapping("/updateCustomer/{ID}")
	public String updateCustomer(@PathVariable("ID") int customer_ID, @ModelAttribute("customer") Customer customer,
			Model model) {
		customer.setID(customer_ID);
		// check if the customer we are trying to update,already exists with the same
		// fields given
		if (customerService.exists(customer) == false) {
			// save the customer using the service
			System.out.println(customer.toString());
			customerService.updateCustomer(customer);
			return "redirect:/customer/list";
		} else {
			System.out.println("User already exists!");
			model.addAttribute("errorr", "The customer already exists.Please try again!");
			model.addAttribute("customer.ID", customer.getID());
			return "customer-update-form";
		}
	}

}
