<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="ui segment">
	<h3>Add a Vehicle</h3>
	<form:form
		action="${pageContext.request.contextPath}/vehicle/saveVehicle"
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
			<form:radiobuttons path="Type" />
		</div>
		<div class="field">
			<label>Date</label>
			<form:input path="date" />
		</div>

		<div class="field">
			<label>Owner Name</label> <input type="text" name="owner_name"
				value="${customer_name}">
		</div>
		<div class="field">
			<label>Owner Surname</label> <input type="text" name="owner_surname"
				value="${customer_surname}">
		</div>
		<div class="field">
			<label>Owner ID</label> <input type="text" name="customer_id"
				value="${customer_id}" readonly="readonly">
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>
	<form:form action="${pageContext.request.contextPath}/customer/cancel"
		method="POST" class="ui form">
		<button class="ui button" type="submit">Cancel</button>
	</form:form>
	<td><c:if test="${not empty error}">
		Error: ${error}</c:if></td>
	<form method="post" action="list-vehicles.jsp">
		<input type="hidden" name="timestamp" id="timestamp" value="5"/>
	</form>
</div>