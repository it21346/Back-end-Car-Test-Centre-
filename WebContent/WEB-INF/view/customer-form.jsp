<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Customer</h3>

	<form:form action="saveCustomer" modelAttribute="customer"
		method="POST" class="ui form">
		<div class="field">
			<label>First Name</label>
			<form:input path="name" />
		</div>
		<div class="field">
			<label>Last Name</label>
			<form:input path="surname" />
		</div>
		<div class="field">
			<label>Email</label>
			<form:input path="email" />
		</div>
		<button class="ui button" type="submit">Save</button>
		<td><c:if test="${not empty error}">
		Error: ${error}</c:if></td>
	</form:form>
	<form:form action="cancel" method="POST" class="ui form">
		<button class="ui button" type="submit">Cancel</button>
	</form:form>
	
</div>