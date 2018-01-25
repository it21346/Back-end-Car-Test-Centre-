package gr.dit.hua.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
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
	public String updateVehicle(Float fee_price,String statusList,@PathVariable("cust_ID") int cust_ID,@PathVariable("veh_ID") int veh_ID,@ModelAttribute("vehicle") Vehicle vehicle, Model model) {
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
			model.addAttribute("errorr", "The Vehicle already exists.Please try again!");
			Customer cust = customerService.getCustomer(cust_ID);
			vehicle.setCustomer(cust);
			model.addAttribute("vehicle",vehicle);
			model.addAttribute("fee",fee_price);
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

	@GetMapping("/fee/{cust_id}/{veh_id}")
	public String calculateFee(@PathVariable("cust_id") int cust_id, @PathVariable("veh_id") int veh_id, Model model) throws ParseException {
		float calculatedFee=0;
		
		Vehicle vehicle  = vehicleService.getVehicle(veh_id);
//https://stackoverflow.com/questions/10649782/java-cannot-format-given-object-as-a-date
		DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		String inputText = vehicle.getTIME_OF_ARRIVAL();	
		Date date = inputFormat.parse(inputText);		
		String outputText = outputFormat.format(date);
//https://stackoverflow.com/questions/30207693/how-to-check-if-date-exceeds-more-than-seven-days
		LocalDate from = LocalDate.parse(vehicle.getDate());
		LocalDate to = LocalDate.parse(outputText);
		long days = ChronoUnit.DAYS.between(from, to);
		System.out.println("1:"+calculatedFee);
		if (vehicle.getType() == type_of_vehicle.Fortigo ) {
			System.out.println("2:"+calculatedFee);
			if(vehicle.getCc() <= 3 && vehicle.getCc() > 0) {					
				calculatedFee = calculatedFee + 100;
				System.out.println("3:"+calculatedFee);
				if (days > 730) {
					calculatedFee = (float) (calculatedFee + (0.5*100));
					System.out.println("4:"+calculatedFee);
				}
			}else {
				calculatedFee = calculatedFee + 150;
		
			    if (days > 730) {
				calculatedFee = (float) (calculatedFee + (0.5*150));
				System.out.println("6:"+calculatedFee);
			    }
			}    
		}else {
			if(vehicle.getCc() <= 1800 && vehicle.getCc() > 0){
				calculatedFee = calculatedFee + 50;
				System.out.println("7:"+calculatedFee);
				if (days > 730) {
					calculatedFee = (float) (calculatedFee + (0.5*50));
					System.out.println("8:"+calculatedFee);
				}
			}else {
				calculatedFee = calculatedFee + 80;
				System.out.println("9:"+calculatedFee);
		
				if (days > 730) {
					calculatedFee = (float) (calculatedFee + (0.5*80));
					System.out.println("10:"+calculatedFee);
				}
			}
		}	
		
		vehicleService.calculateFee(veh_id,calculatedFee);
		return "redirect:/vehicle/listVehicles/"+cust_id;
	}
}
