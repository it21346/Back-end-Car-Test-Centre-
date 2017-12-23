<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Update Vehicle for Customer:${vehicle.owner_name}  ${vehicle.owner_surname}</h3>

	<form:form
		action="${pageContext.request.contextPath}/vehicle/updateVehicle"
		modelAttribute="vehicle" method="POST" class="ui form">
		<div class="field">
			<label>Model</label>
			<form:input path="model" />
		</div>
		<div class="field">
			<label>Registration Number</label>
			<form:input path="registration_number" />
		</div>
		<div class="field">
			<label>Type of Vehicle</label>
			<form:radiobuttons path="Type"/>
		</div>
		<div class="field">
			<label>Date</label>
			<form:input path="date" />			
		</div>
		
		<div class="field">
			<label>Owner Name</label>
			<input type="text" name="owner_name" value="${vehicle.owner_name}" readonly="readonly">			
		</div>
		<div class="field">
			<label>Owner Surname</label>
			<input type="text" name="owner_surname" value="${vehicle.owner_surname}" readonly="readonly">			
		</div>
		<div class="field">
			<label>Owner ID</label>
			<input type="number" name="customer_id" value="${vehicle.customer_id}" readonly="readonly">			
		</div>
		<div class="field">
			<label>Vehicle ID</label>
			<input type="number" name="vehicle_id" value="${vehicle.ID}" readonly="readonly">			
		</div>

		<button class="ui button" type="submit">Save</button><c:if test="${not empty error}">
		Error: ${error}</c:if></td>
	</form:form>

</div>