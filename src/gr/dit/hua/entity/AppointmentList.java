package gr.dit.hua.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name = "AppointmentList")
@Component
public class AppointmentList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Appointment> appointmentList;

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

}
