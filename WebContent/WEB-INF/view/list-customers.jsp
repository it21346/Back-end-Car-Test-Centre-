

<div class="ui segment">
	<h3>
		List of Customers <input type="text" id="search"> <input
			type="button" id="button"
			onmousedown="doSearch(document.getElementById('search').value)"
			value="Find">
	</h3>
	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Vehicles</th>
			<th>Action</th>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempCustomer" items="${customers}">

			<tr>
				<td>${tempCustomer.name}</td>
				<td>${tempCustomer.surname}</td>
				<td>${tempCustomer.email}</td>
				<td>${tempCustomer.vehicles.size()}<br><br> <a
					href="${pageContext.request.contextPath}/vehicle/listVehicles/${tempCustomer.ID}"> <i class="fa fa-search-plus" aria-hidden="true"></i> Details </a>
				</td>			
				<td><a
					href="${pageContext.request.contextPath}/customer/delete/${tempCustomer.ID}" onclick="return confirm('Are you sure you want to delete?')">
						<i class="fa fa-times" aria-hidden="true"></i> Delete </a><br></br><a
					href="${pageContext.request.contextPath}/vehicle/showAddVehicleForm/${tempCustomer.ID}">
						<i class="fa fa-car" aria-hidden="true"></i> AddVehicle </a><br></br><a href="${pageContext.request.contextPath}/customer/showUpdateForm/${tempCustomer.ID}" > <i class="fa fa-refresh" aria-hidden="true"></i> Update</a></td>
			</tr>
		</c:forEach>
	</table>

</div>
