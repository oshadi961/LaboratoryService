<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Laboratory Registration</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet" href="Views/bootstrap.min.css">
<link rel="stylesheet" href="Views/main.css">

</head>
<body class="mainbody">
	<div>



		<div class="page-content">
			<form id="formLab" name="formLab">

				<h2>Registration Form</h2>
				<div class="form-v9-content">
					<div class="form-group">
						<input type="text" class="lab" id="LabRegID" name="LabRegID"
							placeholder="ID">
					</div>

					<div class="form-group">
						<input type="text" class="lab" id="LabName" name="LabName"
							placeholder="Labname">
					</div>

					<div class="form-row-total">

						<div class="form-row">
							<input type="text" class="labRow" id="LabAddress"
								name="LabAddress" placeholder="Labaddress">
						</div>


						<div class="form-row">
							<input type="text" class="labRow" id="LabCity" name="LabCity"
								placeholder="City">
						</div>
					</div>
					<div class="form-row-total">
						<div class="form-row">
							<input type="text" class="labRow" id="LabDestrict"
								name="LabDestrict" placeholder="Destrict">
						</div>

						<div class="form-row">
							<input type="text" class="labRow" id="LabProvince"
								name="LabProvince" placeholder="Province">
						</div>
					</div>
					<div class="form-group">
						<input type="email" class="lab" id="Email" name="Email"
							placeholder="Email">
					</div>


					<div class="form-group">
						<input type="text" class="lab" id="LabContactNum"
							name="LabContactNum" placeholder="Contact Number">
					</div>



					<div class="form-group">
						<input type="text" class="lab" id="LabUsername" name="LabUsername"
							placeholder="Username">
					</div>


					<div class="form-group">
						<input type="password" class="lab" id="Password" name="Password"
							placeholder="Password">
					</div>

					<div class="form-group">
						<input type="text" class="lab" id="OpenTime" name="OpenTime"
							placeholder="OpenTime">
					</div>

					<div class="form-group">
						<input type="text" class="lab" id="CloseTime" name="CloseTime"
							placeholder="CloseTime">
					</div>
				</div>


				<input id="btnSave" name="btnSave" type="button" value="Save"
					class="btn btn-outline-success"> <input type="hidden"
					id="hidItemIDSave" name="hidItemIDSave" value=""> <br>
				<br>

			</form>
		</div>

		




	</div>


</body>
</html>