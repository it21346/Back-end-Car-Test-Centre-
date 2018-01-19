package gr.dit.hua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.dit.hua.entity.Customer;
import gr.dit.hua.entity.Vehicle;
import gr.dit.hua.service.CustomerService;
import gr.dit.hua.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	// inject the vehicle service
	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/listVehicles/{ID}")
	public String listVehicles(Model model, @PathVariable("ID") int ID) {
		// get vehicles from the service
		List<Vehicle> vehicles = vehicleService.getVehicles(ID);
		// add the vehicles to the model
		model.addAttribute("vehicles", vehicles);

		// add page title
		model.addAttribute("pageTitle", "List Vehicles");
		model.addAttribute("customer_id",ID);
		return "list-vehicles";
	}

	@GetMapping("/showAddVehicleForm/{ID}")
	public String showAddVehicleForm(@PathVariable("ID") int ID, Model model) {
		// create model attribute to get form data
		Customer customer = customerService.getCustomer(ID);
		Vehicle vehicle = new Vehicle();
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("customer_name", customer.getName());
		model.addAttribute("customer_surname", customer.getSurname());
		model.addAttribute("customer_id", customer.getID());
		// add page title
		model.addAttribute("pageTitle", "Add Vehicle");
		return "vehicle-form";
	}

	@GetMapping("delete/{customer_id}/{vehicle_id}")
	public String deleteVehicle(@PathVariable("vehicle_id") int vehicle_id,@PathVariable("customer_id") int customer_id, Model model) {		
		vehicleService.deleteVehicle(vehicle_id);
		
		return "redirect:/vehicle/listVehicles/"+customer_id;
	}

	@GetMapping("showUpdateForm/{ID}")
	public String showUpdateForm(@PathVariable("ID") int ID, Model model) {
		// create model attribute to get form data
		Vehicle vehicle = new Vehicle();
		vehicle = vehicleService.getVehicle(ID);
		model.addAttribute("vehicle", vehicle);
		// add page title
		model.addAttribute("pageTitle", "Update Vehicle");
		return "vehicle-update-form";
	}

	@PostMapping("/updateVehicle")
	public String updateVehicle(int vehicle_id, @ModelAttribute("vehicle") Vehicle vehicle, Model model) {
		vehicle.setID(vehicle_id);
		if (vehicle.getDate() == "") {
			vehicle.setDate(null);
		}
		if (vehicleService.exists(vehicle) == false) {	
			// save the vehicle using the service
			vehicleService.updateVehicle(vehicle);
			return "redirect:/vehicle/listVehicles/" + vehicle.getCustomer_id();
		} else {
			System.out.println("Vehicle already exists!");
			model.addAttribute("error", "The Vehicle already exists.Please try again!");
			model.addAttribute("vehicle.ID", vehicle.getID());
			return "vehicle-update-form";
		}

	}

	@PostMapping("/saveVehicle")
	public String saveVehicle(int customer_id,@ModelAttribute("vehicle") Vehicle vehicle, Model model) {
		vehicle.setCustomer_id(customer_id);
		if (vehicle.getDate() == "") {
			vehicle.setDate(null);
		}
		if (vehicleService.exists(vehicle) == false) {
			// new customer,add using the service
			vehicleService.saveVehicle(vehicle);
			return "redirect:/vehicle/listVehicles/" + vehicle.getCustomer_id();
		} else {
			System.out.println("Vehicle already exists!");
			model.addAttribute("error", "The Vehicle already exists.Please try again!");
			model.addAttribute("customer_id", vehicle.getCustomer_id());
			model.addAttribute("customer_name", vehicle.getOwner_name());
			model.addAttribute("customer_surname", vehicle.getOwner_surname());
			return "vehicle-form";
		}

	}
	@PostMapping("/fee/{cust_id}/{veh_id}")
	public String calculateFee(@PathVariable("cust_id") int cust_id,@PathVariable("veh_id") int veh_id,Model model) {
		float calculatedFee;
		calculatedFee=25;
		vehicleService.calculateFee(veh_id,calculatedFee);
		return "redirect:/vehicle/listVehicles/"+cust_id;
	}
}
