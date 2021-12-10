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

import com.fstt.doa.ProduitDao;
import com.fstt.model.Produit;

/**
 * Servlet implementation class ControllerProduitServlet
 */
@WebServlet("/ControllerProduitServlet")
public class ControllerProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Produit prod ;
		List<Produit> listprod = new ArrayList<Produit>();
		
		try {
			
			ProduitDao ProduitDao = new ProduitDao() ;
			
			switch (action) {
			case "save":
					String nom_produit = request.getParameter("nom_produit");
					Integer prix_produit	 = Integer.parseInt(request.getParameter("prix_produit"));
					prod = new Produit(0 , nom_produit ,prix_produit) ;
					ProduitDao.save(prod);
					request.getRequestDispatcher("/ControllerProduitServlet?action=list").forward(request, response);
				break;
				
			case "list":
				
				listprod = ProduitDao.getAll() ;
				
				request.setAttribute("listp", listprod);
				
				request.getRequestDispatcher("listProduit.jsp").forward(request, response);
				
				break;
				
			case "edit":
			
				int idToUpdate =  Integer.parseInt(request.getParameter("id")) ;
				String newNomProduit=request.getParameter("nom_produit");
				int newPrix=Integer.parseInt(request.getParameter("prix_produit"));
				
				Produit prd = new Produit(idToUpdate,newNomProduit,newPrix);
				ProduitDao.update(prd);
				request.getRequestDispatcher("/ControllerProduitServlet?action=list").forward(request, response);
				break;
				
			case "delete":
					
					int id =  Integer.parseInt(request.getParameter("id")) ;
					
					ProduitDao.delete(ProduitDao.getOne(id));
					
					request.getRequestDispatcher("/ControllerProduitServlet?action=list").forward(request, response);
					
					break;
			case "addProduit":
				request.getRequestDispatcher("addProduit.jsp").forward(request, response);
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
