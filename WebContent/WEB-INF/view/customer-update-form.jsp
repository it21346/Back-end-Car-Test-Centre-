<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Update Customer:${customer.name} ${customer.surname}</h3>

	<form:form
		action="${pageContext.request.contextPath}/customer/updateCustomer/${customer.ID}"
		modelAttribute="customer" method="POST" class="ui form">
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
		<div class="field">
			<label>ID</label> <input name="customer_ID" value="${customer.ID}"
				type="number" readonly="readonly" />
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>
	<form:form action="${pageContext.request.contextPath}/customer/cancel" method="POST" class="ui form">
		<button class="ui button" type="submit">Cancel</button>
	</form:form>
	<td><c:if test="${not empty errorr}">
		Error: ${errorr}</c:if></td>
</div>