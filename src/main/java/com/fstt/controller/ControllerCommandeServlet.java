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
import com.fstt.doa.CommandeDao;
import com.fstt.doa.HasManyCommandeProduitDao;
import com.fstt.doa.ProduitDao;
import com.fstt.model.Client;
import com.fstt.model.Commande;
import com.fstt.model.HasManyCommandeProduit;

/**
 * Servlet implementation class ControllerCommandeServlet
 */
@WebServlet("/ControllerCommandeServlet")
public class ControllerCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		Commande com ;
		List<Commande> listcom = new ArrayList<Commande>();
		
		try {
			HasManyCommandeProduitDao hasmany = new HasManyCommandeProduitDao();
			CommandeDao cmdnDao = new CommandeDao();
			ProduitDao prodDao = new ProduitDao();
			
			CommandeDao CommandeDao = new CommandeDao() ;
			
			ClientDao ClientDao = new ClientDao();
			
			switch (action) {
			case "save":
					
					Integer idClient =  Integer.parseInt(request.getParameter("idClient")) ;
					Integer idproduit = Integer.parseInt(request.getParameter("produit")) ;
					
					com = new Commande(0,ClientDao.getOne(idClient)) ;
					CommandeDao.save(com);
					hasmany.save(new HasManyCommandeProduit(0, cmdnDao.getOne(1), prodDao.getOne(idproduit)));
					CommandeDao.save(com);
					request.getRequestDispatcher("/ControllerCommandeServlet?action=list").forward(request, response);
				break;
				
			case "list":
				
				listcom = CommandeDao.getAll() ;
				
				request.setAttribute("listcom", listcom);
				
				
				request.getRequestDispatcher("listCommande.jsp").forward(request, response);
				
				break;
				
			case "edit":
				int idToUpdate =  Integer.parseInt(request.getParameter("id")) ;
				Commande cmnd = new Commande(idToUpdate,CommandeDao.getOne(idToUpdate).getClient());
				CommandeDao.update(cmnd);
				request.getRequestDispatcher("listCommande.jsp").forward(request, response);
				
				break;
				
			case "delete":
					
					int id =  Integer.parseInt(request.getParameter("id")) ;
					
					CommandeDao.delete(CommandeDao.getOne(id));
					
					request.getRequestDispatcher("/ControllerCommandeServlet?action=list").forward(request, response);
					
					break;
			case "addCommande":
				request.getRequestDispatcher("addCommande.jsp").forward(request, response);
				
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
