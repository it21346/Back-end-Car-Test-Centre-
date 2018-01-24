<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Update Vehicle for Customer:${vehicle.owner_name}
		${vehicle.owner_surname}</h3>

	<form:form
		action="${pageContext.request.contextPath}/vehicle/updateVehicle"
		modelAttribute="vehicle" method="POST" id="vehicleForm"
		class="ui form">
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
			<form:radiobuttons path="Type" />
		</div>
		<div class="field">
			<label>Date</label>
			<form:input path="date" />
		</div>
		<div class="field">
			<label>CC</label>
			<form:input path="cc" />
		</div>
		<div class="field">
			<label>Status</label> <select name="statusList" form="vehicleForm"
				id="selected">
				<option value="Pending">Pending</option>
				<option value="Fix">Needs to Fix issues</option>
				<option value="Insurance">Insurance Invalid</option>
				<option value="Control">Control</option>
			</select>
		</div>		
		<div class="field">
			<label>Owner ID</label> <input type="number" name="customer_id"
				value="${vehicle.customer_id}" readonly="readonly">
		</div>
		<div class="field">
			<label>Vehicle ID</label> <input type="number" name="vehicle_id"
				value="${vehicle.ID}" readonly="readonly">
		</div>

		<button class="ui button" type="submit">Save</button>

	</form:form>
	<form:form
		action="${pageContext.request.contextPath}/vehicle/cancel/${vehicle.customer_id}"
		method="POST" class="ui form">
		<button class="ui button" type="submit">Cancel</button>
	</form:form>
	<td><c:if test="${not empty errorr}">
		Error: ${errorr}</c:if></td>
</div>