<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Update Vehicle for Customer:${vehicle.getCustomer().name}&emsp; ${vehicle.getCustomer().surname}
		</h3>

	<form:form
		action="${pageContext.request.contextPath}/vehicle/updateVehicle/${vehicle.getCustomer().ID}/${vehicle.ID}"
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
			<label>Insurance</label> <select name="insurance" form="vehicleForm">
				<option value="Valid">Valid</option>
				<option value="Invalid">Invalid</option>
			</select>
		</div>
		<div class="field">
			<label>CC/Tons</label>
			<form:input path="cc" />
		</div>
		<div class="field">
			<label>Status</label> <select name="statusList" form="vehicleForm"
				id="selected">
				<option value="Check Pending">Check Pending</option>
				<option value="Needs to Fix issues">Needs to Fix issues</option>
				<option value="Check Completed">Check Completed</option>
				<option value="Fee's Paid">Fee's Paid</option>
			</select>
		</div>		
		<div class="field">
			<label>Owner ID</label> <input type="number" name="customer_id"
				value="${vehicle.getCustomer().ID}" readonly="readonly">
		</div>
		<div class="field">
			<label>Vehicle ID</label> <input type="number" name="vehicle_id"
				value="${vehicle.ID}" readonly="readonly">
		</div>
		<input name="fee" id="fee_price" type="number" hidden="hidden" value="${vehicle.fee}">
		<button class="ui button" type="submit">Save</button>

	</form:form>
	<form:form
		action="${pageContext.request.contextPath}/vehicle/cancel/${vehicle.getCustomer().ID}"
		method="POST" class="ui form">
		<button class="ui button" type="submit">Cancel</button>
	</form:form>
	<td><c:if test="${not empty errorr}">
		Error: ${errorr}</c:if></td>
</div>