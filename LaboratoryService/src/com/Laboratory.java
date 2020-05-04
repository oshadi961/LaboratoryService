/**
 * 
 */
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author oshadi
 *
 */
public class Laboratory {

	// DATABASE CONNECTION-----------------
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/laboratory", "root", "root");
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// INSERT-----------------
	public String insertLaboratory(String LabRegID, String LabName, String LabAddress, String LabCity,
			String LabDestrict, String LabProvince, String Email, String LabContactNum, String LabUsername,
			String Password, String OpenTime, String CloseTime) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into lab"
					+ "(`labRegID`,`labName`,`labAddress`,`labCity`,`labDestrict`,`labProvince`,`labEmail`,`labContactNum`,`labUsername`,`labPassword`,`OpenTime`,`CloseTime`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setString(1, LabRegID);
			preparedStmt.setString(2, LabName);
			preparedStmt.setString(3, LabAddress);
			preparedStmt.setString(4, LabCity);
			preparedStmt.setString(5, LabDestrict);
			preparedStmt.setString(6, LabProvince);
			preparedStmt.setString(7, Email);
			preparedStmt.setString(8, LabContactNum);
			preparedStmt.setString(9, LabUsername);
			preparedStmt.setString(10, Password);
			preparedStmt.setString(11, OpenTime);
			preparedStmt.setString(12, CloseTime);
			// execute the statement
			
			preparedStmt.execute();
			
			con.close();
			String newLaboratories = readLaboratories();
			output = "{\"status\":\"success\", \"data\": \"" + newLaboratories + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the Laboratory Details.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// READ--------------------
	public String readLaboratories() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1' class='table table-striped table-dark'><tr><th>LabRegID</th> <th>Lab Name</th><th>Lab Address</th>"
					+ "<th>Lab City</th><th>Lab District</th> <th>Lab Province</th><th>Lab Email</th>"
					+ "<th>Lab Contact Number</th> <th>Lab Username</th><th>Lab Password</th>"
					+ "<th>Lab OpenTime</th> <th>Lab CloseTime</th> <th>Update</th><th>Remove</th></tr>";

			String query = "select * from lab";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String labRegID = rs.getString("labRegID");
				String labName = rs.getString("labName");
				String labAddress = rs.getString("labAddress");
				String labCity = rs.getString("labCity");
				String labDestrict = rs.getString("labDestrict");
				String labProvince = rs.getString("labProvince");
				String labEmail = rs.getString("labEmail");
				String labContactNum = rs.getString("labContactNum");
				String labUsername = rs.getString("labUsername");
				String labPassword = rs.getString("labPassword");
				String OpenTime = rs.getString("OpenTime");
				String CloseTime = rs.getString("CloseTime");
				// Add into the HTML table
				output += "<tr><td><input id='hidLabIDUpdate' name='hidLabIDUpdate' type='hidden' value='" + labRegID
						+ "'>" + labRegID + "</td>";
				output += "<td>" + labName + "</td>";
				output += "<td>" + labAddress + "</td>";
				output += "<td>" + labCity + "</td>";
				output += "<td>" + labDestrict + "</td>";
				output += "<td>" + labProvince + "</td>";
				output += "<td>" + labEmail + "</td>";
				output += "<td>" + labContactNum + "</td>";
				output += "<td>" + labUsername + "</td>";
				output += "<td>" + labPassword + "</td>";
				output += "<td>" + OpenTime + "</td>";
				output += "<td>" + CloseTime + "</td>";
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-laboratoryid='"
						+ labRegID + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Lab Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// UPDATE-----------------------------------------------------------------------------------
	public String updateLaboratory(String LabRegID, String LabName, String LabAddress, String LabCity,
			String LabDestrict, String LabProvince, String Email, String LabContactNum, String LabUsername,
			String Password, String OpenTime, String CloseTime) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE lab SET labName=?,labAddress=?,labCity=?,labDestrict=?,labProvince=?,labEmail=?,labContactNum=?,labUsername=?,labPassword=?,OpenTime=?,CloseTime=? WHERE labRegID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, LabName);
			preparedStmt.setString(2, LabAddress);
			preparedStmt.setString(3, LabCity);
			preparedStmt.setString(4, LabDestrict);
			preparedStmt.setString(5, LabProvince);
			preparedStmt.setString(6, Email);
			preparedStmt.setString(7, LabContactNum);
			preparedStmt.setString(8, LabUsername);
			preparedStmt.setString(9, Password);
			preparedStmt.setString(10, OpenTime);
			preparedStmt.setString(11, CloseTime);
			preparedStmt.setString(12, LabRegID);
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newLaboratories = readLaboratories();
			output = "{\"status\":\"success\", \"data\": \"" + newLaboratories + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the  Laboratory Details.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// DELETE-----------------------------------------
	public String deleteLaboratory(String LabRegID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from lab where labRegID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, LabRegID);
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newLaboratories = readLaboratories();
			output = "{\"status\":\"success\", \"data\": \"" + newLaboratories + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the Laboratory Details.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
