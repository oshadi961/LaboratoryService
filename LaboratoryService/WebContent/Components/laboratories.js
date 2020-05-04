/**
 * 
 */


$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
});








// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateLaboratoryForm();

	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	// If valid------------------------
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "LabsAPI",
		type : type,
		data : $("#formLab").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
			alert(response.responseText);
		}
	});
	

});

function onItemSaveComplete(response, status) {
	
	
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#formLab")[0].reset();

}

//UPDATE==========================================
$(document).on(	"click",".btnUpdate",function(event) {

			$("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
			$("#LabRegID").val($(this).closest("tr").find('td:eq(0)').text());
			$("#LabName").val($(this).closest("tr").find('td:eq(1)').text());
			$("#LabAddress").val($(this).closest("tr").find('td:eq(2)').text());
			$("#LabCity").val($(this).closest("tr").find('td:eq(3)').text());
			$("#LabDestrict").val($(this).closest("tr").find('td:eq(4)').text());
			$("#LabProvince").val($(this).closest("tr").find('td:eq(5)').text());
			$("#Email").val($(this).closest("tr").find('td:eq(6)').text());
			$("#LabContactNum").val($(this).closest("tr").find('td:eq(7)').text());
			$("#LabUsername").val($(this).closest("tr").find('td:eq(8)').text());
			$("#Password").val($(this).closest("tr").find('td:eq(9)').text());
			$("#OpenTime").val($(this).closest("tr").find('td:eq(10)').text());
			$("#CloseTime").val($(this).closest("tr").find('td:eq(11)').text());

		});










$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "LabsAPI",
		type : "DELETE",
		data : "labRegID=" + $(this).data("laboratoryid"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
			alert(response);
		}
	});
});

function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
	
}














//CLIENTMODEL=========================================================================
function validateLaboratoryForm() {

	// LAB REGISTRATION NUMBER--------------------------
	if ($("#LabRegID").val().trim() == "") {
		return "Insert Laboratory Registration Number.";
	}

	// LAB NAME------------------------------
	if ($("#LabName").val().trim() == "") {
		return "Insert Laboratory Name.";
	}

	// ADDRRESS-------------------------------
	if ($("#LabAddress").val().trim() == "") {
		return "Insert Address.";
	}
	
	// CITY-------------------------------
	if ($("#LabCity").val().trim() == "") {
		return "Insert City.";
	}
	
	// DESTRICT-------------------------------
	if ($("#LabDestrict").val().trim() == "") {
		return "Insert Destrict.";
	}
	
	// PROVINCE-----------------------------------
	if ($("#LabProvince").val().trim() == "") {
		return "Insert Province.";
	}

	// EMAIL-------------------------------
	if ($("#Email").val().trim() == "") {
		return "Insert Email.";
	}
	
	// CONTACT NUMBER-------------------------------
	if ($("#LabContactNum").val().trim() == "") {
		return "Insert Contact Number.";
	}
	
	// USERNAME-------------------------------
	if ($("#LabUsername").val().trim() == "") {
		return "Insert User Name.";
	}

	// PASSWORD------------------------
	if ($("#Password").val().trim() == "") {
		return "Insert Password.";
	}
	
	// OPENTIME-------------------------------
	if ($("#OpenTime").val().trim() == "") {
		return "Insert Open Time.";
	}

	// CLOSETIME------------------------
	if ($("#CloseTime").val().trim() == "") {
		return "Insert Close Time.";
	}

	return true;
}