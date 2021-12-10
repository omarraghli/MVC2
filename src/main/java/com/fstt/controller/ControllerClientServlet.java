package com.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fstt.doa.ClientDao;
import com.fstt.model.Client;
import com.fstt.model.Commande;

/**
 * Servlet implementation class ControllerClientServlet
 */
@WebServlet("/ControllerClientServlet")
public class ControllerClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControllerClientServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// controller with actions MVC 2

				String action = request.getParameter("action");
				Client cl ;
				List<Client> listcl = new ArrayList<Client>();
				
				try {
					
					ClientDao ClientDao = new ClientDao() ;
					
					
					switch (action) {
					case "save":
							String nom = request.getParameter("nom");
							String prenom = request.getParameter("prenom");
							Integer age =  Integer.parseInt(request.getParameter("age")) ;
							cl = new Client(0 , nom ,prenom, age) ;
							ClientDao.save(cl);
							request.getRequestDispatcher("/ControllerClientServlet?action=list").forward(request, response);
						break;
						
					case "list":
						
						listcl = ClientDao.getAll() ;
						
						request.setAttribute("listp", listcl);
						
						
						request.getRequestDispatcher("listClients.jsp").forward(request, response);
						
						break;
						
					case "edit":
						
						int idToUpdate =  Integer.parseInt(request.getParameter("id")) ;
						String newNom=request.getParameter("nom");
						String newPrenom=request.getParameter("prenom");
						int newAge=Integer.parseInt(request.getParameter("age"));
						Client client = new Client(idToUpdate,newNom,newPrenom,newAge);
						
						ClientDao.update(client);
						request.getRequestDispatcher("/ControllerClientServlet?action=list").forward(request, response);
						break;
						
					case "delete":
							
							int id =  Integer.parseInt(request.getParameter("id")) ;
							
							ClientDao.delete(ClientDao.getOne(id));
							
							
							request.getRequestDispatcher("/ControllerClientServlet?action=list").forward(request, response);
							
							break;
					case "addClient":
						request.getRequestDispatcher("addClients.jsp").forward(request, response);
						//response.sendRedirect("addClient.jsp");
						
						break;

					default:
						break;
					}
					
				
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
