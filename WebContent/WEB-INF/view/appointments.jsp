<div class="ui segment">
	<h3>List of Appointments</h3>
	<table class="ui celled  striped table">
		<thead>
			<th>ID</th>
			<th>Date</th>
			<th>Status</th>
		</thead>
		<c:forEach var="tempAppointment" items="${appointments}">
			<tr>
			<td>${tempAppointment.ID}</td>
			<td>${tempAppointment.date}</td>
			<td>${tempAppointment.status}</td>
			</tr>
		</c:forEach>
	</table>
</div>