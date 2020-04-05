package ads.pipoca.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.pipoca.model.entity.Filme;
import ads.pipoca.model.entity.Genero;
import ads.pipoca.model.service.FilmeService;
import ads.pipoca.model.service.GeneroService;

@WebServlet("/manter_filmes.do")
public class ManterFilmesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "mostrar":
			String id_filme = request.getParameter("id_filme");
			int idFilme = Integer.parseInt(id_filme);
			FilmeService fService = new FilmeService();
			Filme filme = fService.buscarFilme(idFilme);
			System.out.println(filme);

			request.setAttribute("filme", filme);

			RequestDispatcher view = request.getRequestDispatcher("Filme.jsp");
			view.forward(request, response);
			break;
		case "inserir":
			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			double popularidade = Double.parseDouble(request.getParameter("popularidade"));
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
			// dizendo o formato da data que será digitada

			Date dataLanc = null;
			try {
				dataLanc = formatter.parse(request.getParameter("datalanc"));
			} catch (ParseException e) {
				//Mensagem de erro
				e.printStackTrace();
			}
			
			String poster = request.getParameter("poster");
			String diretor = request.getParameter("diretor");
			int idGenero = Integer.parseInt(request.getParameter("idgenero"));
			GeneroService generoservice = new GeneroService(); //instanciar para chamar o método do Genero Service
			Genero genero = generoservice.buscarGenero(idGenero); 
			//Recebe um genero do banco e coloca na variável genero 
			//Para executar um método de outra classe, 
			//instacio ela numa viariável e chamo ela pelo nome da variável com ponto na frente
			
			Filme filmeMontado = new Filme();
			filmeMontado.setTitulo(titulo);
			filmeMontado.setDescricao(descricao);
			filmeMontado.setPopularidade(popularidade);
			filmeMontado.setDataLancamento(dataLanc);
			filmeMontado.setPosterPath(poster);
			filmeMontado.setDiretor(diretor);
			filmeMontado.setGenero(genero);
			
			
			
			break;
		case "atualizar":
			break;
		case "excluir":
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
