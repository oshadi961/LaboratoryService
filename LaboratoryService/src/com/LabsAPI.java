package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LabsAPI
 */
@WebServlet("/LabsAPI")
public class LabsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Laboratory Class Object----------------
	Laboratory labObj = new Laboratory();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LabsAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = labObj.insertLaboratory(request.getParameter("LabRegID"), request.getParameter("LabName"),
				request.getParameter("LabAddress"), request.getParameter("LabCity"),
				request.getParameter("LabDestrict"), request.getParameter("LabProvince"), request.getParameter("Email"),
				request.getParameter("LabContactNum"), request.getParameter("LabUsername"),
				request.getParameter("Password"), request.getParameter("OpenTime"), request.getParameter("CloseTime"));
		response.getWriter().write(output);

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = labObj.updateLaboratory(paras.get("hidLabIDSave").toString(), paras.get("LabName").toString(),
				paras.get("LabAddress").toString(), paras.get("LabCity").toString(),
				paras.get("LabDestrict").toString(), paras.get("LabProvince").toString(), paras.get("Email").toString(),
				paras.get("LabContactNum").toString(), paras.get("LabUsername").toString(),
				paras.get("Password").toString(), paras.get("OpenTime").toString(), paras.get("CloseTime").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = labObj.deleteLaboratory(paras.get("labRegID").toString());
		response.getWriter().write(output);
		System.out.println(paras.get("labRegID").toString());
	}

	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {

				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

}
