//Servlet: Receber requisições HTTP, processá-las e responder ao cliente
package br.com.ebix.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ebix.model.Segurado;
import br.com.ebix.persistence.SeguradoDao;
import br.com.ebix.validation.Validation;

public class SeguradoController extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
		

			Segurado segurado = new Segurado();
			
			segurado.setNome(req.getParameter("nome"));
			segurado.setCpf(req.getParameter("cpf"));
			segurado.setRg(req.getParameter("rg"));
			segurado.setSexo(req.getParameter("sexo"));
			segurado.setSeguros(req.getParameterValues("seguros"));
			segurado.setCorrentista(req.getParameter("correntista"));
			segurado.setDiasVisita(req.getParameterValues("diasVisita"));
			
			Validation validation = new Validation();
			validation.validarCampos(segurado);

			ArrayList<String> error = validation.validarCampos(segurado);

			if (error.size() > 0) {

				StringBuffer erros = new StringBuffer();
				for (String valor : error) {
					erros.append(valor);
					erros.append(", ");
				}

				req.setAttribute("erro", erros.toString());
				req.getRequestDispatcher("/cadastrosegurado.jsp").forward(req, resp);

			} else {
				SeguradoDao dao = new SeguradoDao();
				dao.create(segurado);
				req.setAttribute("mensagem", "Cadastrado com sucesso! :)");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			req.setAttribute("mensagem", "Não foi cadastrado! :" + e.getMessage());
			req.getRequestDispatcher("/cadastrosegurado.jsp").forward(req, resp);

	} 
	
//		finally {
//			req.getRequestDispatcher("index.jsp").forward(req, resp);
//		}
	}
}
