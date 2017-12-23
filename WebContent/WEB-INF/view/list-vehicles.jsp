<div class="ui segment">
	<h3>
		List of Vehicles &emsp;&emsp;<a
			href="${pageContext.request.contextPath}/vehicle/showAddVehicleForm/${customer_id}">
			<i class="fa fa-caret-right" aria-hidden="true"></i>Add Vehicle
		</a>

	</h3>
	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Model</th>
			<th>Registration Number</th>
			<th>Type</th>
			<th>Date</th>
			<th>Owner Name</th>
			<th>Owner Surname</th>
			<th>Actions</th>

		</thead>
		<!-- loop over and print the customer's vehicle -->
		<c:forEach var="tempVehicle" items="${vehicles}">

			<tr>
				<td>${tempVehicle.model}</td>
				<td>${tempVehicle.registration_number}</td>
				<td>${tempVehicle.type}</td>
				<td>${tempVehicle.date}</td>
				<td>${tempVehicle.owner_name}</td>
				<td>${tempVehicle.owner_surname}</td>
				<td><a
					href="${pageContext.request.contextPath}/vehicle/delete/${customer_id}/${tempVehicle.ID}"
					onclick="return confirm('Are you sure you want to delete?')"> <i
						class="fa fa-times" aria-hidden="true"></i> Delete
				</a><br></br> <a
					href="${pageContext.request.contextPath}/vehicle/showUpdateForm/${tempVehicle.ID}"><i
						class="fa fa-refresh" aria-hidden="true"></i> Update</a><br></br>
					<button type="button">
						<a href="">Fee 
					</button>:
					<form action="">
						<input type="text" value="">
					</form></td>
			</tr>
		</c:forEach>
	</table>
</div>