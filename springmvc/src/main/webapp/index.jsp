<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<script type="text/javascript">
		function getEmployee() {
			$.ajax({
				url: "employee/get", 
				data: {
					empId: $("input[name=empId]").val(),
				},
				success: function(result){
				      $("#result").html(result);
				    }
				}
			);
		}
	</script>
</head>

<body>

<form action="employee/add">
	Employee ID: <input type="text" name="empId"><br>
	Employee Name: <input type="text" name="empName"><br>
	<input type="submit">
	<input type="button" value="Get Employee" onclick="getEmployee()">
	<div id="result"></div>
</form>

</body>
</html>
