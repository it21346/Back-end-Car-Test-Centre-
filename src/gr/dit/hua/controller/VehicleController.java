package gr.dit.hua.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.dit.hua.entity.Customer;
import gr.dit.hua.entity.Vehicle;
import gr.dit.hua.entity.Vehicle.type_of_vehicle;
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
		model.addAttribute("customer_id", ID);
		return "list-vehicles";
	}

	@PostMapping("/cancel/{ID}")
	public String cancelButton(@PathVariable("ID") int ID) {
		// return to the previous page
		return "redirect:/vehicle/listVehicles/" + ID;

	}

	@GetMapping("/showAddVehicleForm/{ID}")
	public String showAddVehicleForm(@PathVariable("ID") int ID, Model model) {
		// create model attribute to get form data
		Vehicle vehicle = new Vehicle();
		Customer customer = customerService.getCustomer(ID);
		vehicle.setCustomer(customer);
		model.addAttribute("vehicle", vehicle);		
		// add page title
		model.addAttribute("pageTitle", "Add Vehicle");
		return "vehicle-form";
	}

	@GetMapping("/delete/{customer_id}/{vehicle_id}")
	public String deleteVehicle(@PathVariable("vehicle_id") int vehicle_id,
			@PathVariable("customer_id") int customer_id, Model model) {
		vehicleService.deleteVehicle(vehicle_id);

		return "redirect:/vehicle/listVehicles/" + customer_id;
	}

	@GetMapping("/showUpdateForm/{cust_ID}/{veh_ID}")
	public String showUpdateForm(@PathVariable("cust_ID") int cust_ID,@PathVariable("veh_ID") int veh_ID,Model model) {
		// create model attribute to get form data
		Vehicle vehicle = new Vehicle();
		vehicle = vehicleService.getVehicle(veh_ID);
		Customer customer = customerService.getCustomer(cust_ID);
		vehicle.setCustomer(customer);
		model.addAttribute("vehicle", vehicle);
		// add page title
		model.addAttribute("pageTitle", "Update Vehicle");
		return "vehicle-update-form";
	}

	@PostMapping("/updateVehicle/{cust_ID}/{veh_ID}")
	public String updateVehicle(String statusList,@PathVariable("cust_ID") int cust_ID,@PathVariable("veh_ID") int veh_ID,@ModelAttribute("vehicle") Vehicle vehicle, Model model) {
		System.out.println("THE LIST SELECTED THE :"+statusList);
		vehicle.setStatus(statusList);
		vehicle.setID(veh_ID);
		if (vehicle.getDate() == "") {
			vehicle.setDate(null);
		}
		if (vehicleService.exists(vehicle) == false) {
			// save the vehicle using the service
			Customer cust = customerService.getCustomer(cust_ID);
			vehicle.setCustomer(cust);
			vehicleService.updateVehicle(vehicle);
			return "redirect:/vehicle/listVehicles/" + vehicle.getCustomer().getID();
		} else {
			System.out.println("Vehicle already exists!");
			model.addAttribute("error", "The Vehicle already exists.Please try again!");
			model.addAttribute("vehicle",vehicle);
			return "vehicle-update-form";
		}

	}

	@PostMapping("/saveVehicle/{ID}")
	public String saveVehicle(@PathVariable("ID") int cust_ID,@ModelAttribute("vehicle") Vehicle vehicle, Model model) {
		vehicle.setStatus("Pending");
		if (vehicle.getDate() == "") {
			vehicle.setDate(null);
		}
		if (vehicleService.exists(vehicle) == false) {
			Customer cust = customerService.getCustomer(cust_ID);
			vehicle.setCustomer(cust);
			// new customer,add using the service
			vehicleService.saveVehicle(vehicle);
			return "redirect:/vehicle/listVehicles/" + cust_ID;
		} else {
			System.out.println("Vehicle already exists!");
			model.addAttribute("error", "The Vehicle already exists.Please try again!");
			model.addAttribute("customer_id", vehicle.getCustomer().getID());
			return "vehicle-form";
		}
	}

	@PostMapping("/fee/{cust_id}/{veh_id}")
	public String calculateFee(@PathVariable("cust_id") int cust_id, @PathVariable("veh_id") int veh_id, Model model) {
		System.out.println(cust_id);
		float calculatedFee=0;
//		Vehicle vehicle  = vehicleService.getVehicle(veh_id);
//		String newDate = new SimpleDateFormat("yyyy.MM.dd").format(vehicle.getTIME_OF_ARRIVAL());
//		System.out.println(newDate);
//		if (vehicle.getType() == type_of_vehicle.Fortigo ) {
//			if(vehicle.getCc() <= 3 && vehicle.getCc() > 0) {					
//				calculatedFee = calculatedFee + 100;					
//			}else
//				calculatedFee = calculatedFee + 150;
//		}else 
//			if(vehicle.getCc() <= 1800 && vehicle.getCc() > 0){
//				calculatedFee = calculatedFee + 50;
//			}else 
//				calculatedFee = calculatedFee + 80;
//		
//		vehicleService.calculateFee(veh_id,calculatedFee);
		return "redirect:/vehicle/listVehicles/"+cust_id;
	}
}
