package gr.dit.hua.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="CustomerList")
@Component
public class VehicleList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Vehicle> vehicleList;

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

}
