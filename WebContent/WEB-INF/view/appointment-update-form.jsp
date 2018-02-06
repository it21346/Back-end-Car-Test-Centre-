<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Update Appointment: Status--> ${appointment.status}</h3>

	<form:form
		action="${pageContext.request.contextPath}/customer/updateAppointment/${appointment.customer_appoint.getID()}/${appointment.ID}"
		modelAttribute="appointment" method="POST" class="ui form">
		<div class="field">
			<label>Name</label>
			<form:input path="customer_appoint.name" value="${appointment.customer_appoint.getName()}" readonly="true"/>
		</div>
		<div class="field">
			<label>Surname</label>
			<form:input path="customer_appoint.surname" value="${appointment.customer_appoint.getSurname()}" readonly="true"/>
		</div>
		<div class="field">
			<label>Date</label>
			<form:input path="date" />
		</div>
		<div class="field">
			<label>Status</label>
			<form:radiobutton name="checked" value="Checked" path="status"/>Checked
			<form:radiobutton  name="unchecked" value="Unchecked" path="status"/>Unchecked
			<form:radiobutton  name="completed" value="Completed" path="status"/>Completed
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>
</div>