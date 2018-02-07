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
			<th>Time Of Next Check</th>
			<th>Fee</th>
			<th>CC</th>
			<th>Status</th>
			<th>Actions</th>

		</thead>
		<!-- loop over and print the customer's vehicle -->
		<c:forEach var="tempVehicle" items="${vehicles}">

			<tr>
				<td>${tempVehicle.model}</td>
				<td>${tempVehicle.registration_number}</td>
				<td>${tempVehicle.type}</td>
				<td>${tempVehicle.date}</td>
				<td>${tempVehicle.getDate_OF_NEXT_CHECK()}</td>
				<c:if test="${not empty fee}">
					<td>${fee}</td>
				</c:if>
				<c:if test="${empty fee}">
					<td>${tempVehicle.fee}</td>
				</c:if>
				<td>${tempVehicle.cc}</td>
				<td>${tempVehicle.status}</td>

				<td><sec:authorize access="hasRole('ROLE_SECRETARY')">
						<a
							href="${pageContext.request.contextPath}/vehicle/delete/${customer_id}/${tempVehicle.ID}"
							onclick="return confirm('Are you sure you want to delete?')">
							<i class="fa fa-times" aria-hidden="true"></i> Delete
						</a>
					</sec:authorize> <br></br> 
						<a
							href="${pageContext.request.contextPath}/vehicle/showUpdateForm/${customer_id}/${tempVehicle.ID}"><i
							class="fa fa-refresh" aria-hidden="true"></i> Update</a>
					<br></br>
					<form
						action="${pageContext.request.contextPath}/vehicle/fee/${customer_id}/${tempVehicle.ID}"
						method="GET">
						<button type="submit" name="fee">Fee</button>
					</form>
			</tr>
		</c:forEach>
	</table>
</div>