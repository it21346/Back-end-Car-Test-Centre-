<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="ui segment">
	<h3>Add a Vehicle</h3>
	<form:form
		action="${pageContext.request.contextPath}/vehicle/saveVehicle/${vehicle.getCustomer().ID}"
		modelAttribute="vehicle" method="POST" id="vehicleForm" class="ui form">
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
			<form:radiobuttons path="Type"  checked="checked" />
		</div>
		<div class="field">
			<label>Date</label>
			<form:input path="date" placeholder="YYYY-MM-DD" />
		</div>
		<div class="field">
			<label>CC</label>
			<form:input path="cc" />
		</div>
		<div class="field">
			<label>Insurance</label> <select id="option" name="insurance" form="vehicleForm">
				<option value="Valid">Valid</option>
				<option value="Invalid">Invalid</option>
			</select>
		</div>
		<div class="field">
			<label>Owner ID</label> <input type="number" name="customer_id"
				value="${vehicle.getCustomer().getID()}" readonly="readonly">
		</div>
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