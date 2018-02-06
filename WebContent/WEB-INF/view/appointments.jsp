<div class="ui segment">
	<h3>List of Appointments</h3>
	<table class="ui celled  striped table">
		<thead>
			<th>Name</th>
			<th>SurName</th>
			<th>Date</th>
			<th>Status</th>
			<th>Actions</th>
		</thead>
		<c:forEach var="tempAppointment" items="${appointments}">
			<tr>
			<td>${tempAppointment.getCustomer_appoint().getName()}</td>
			<td>${tempAppointment.getCustomer_appoint().getSurname()}</td>
			<td>${tempAppointment.date}</td>
			<td>${tempAppointment.status}</td>
			<td><a href="${pageContext.request.contextPath}/customer/showAppointmentUpdateForm/${tempAppointment.ID}" >Update</a></td>
			</tr>
		</c:forEach>
	</table>
</div>