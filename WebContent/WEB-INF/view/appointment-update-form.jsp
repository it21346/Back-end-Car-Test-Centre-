<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Update Appointment: Status--> ${appointment.status}</h3>

	<form:form
		action="${pageContext.request.contextPath}/customer/updateAppointment/${appointment.ID}"
		modelAttribute="appointment" method="POST" class="ui form">
		<div class="field">
			<label>Name</label>
			<input value="${appointment.customer_appoint.getName()}" />
		</div>
		<div class="field">
			<label>Surname</label>
			<input value="${appointment.customer_appoint.getSurname()}" />
		</div>
		<div class="field">
			<label>Date</label>
			<form:input path="date" />
		</div>
		<div class="field">
			<label>Status</label>
			<form:input path="status" />
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>
	<td><c:if test="${not empty errorr}">
		Error: ${errorr}</c:if></td>
</div>