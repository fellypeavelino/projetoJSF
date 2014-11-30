package gui;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dados.generico.DAOFactory;

/**
 * Servlet Filter implementation class OSIVFilter
 * Open Session In View 
 */
@WebFilter(servletNames="Faces Servlet", filterName="/OSIVFilter")
public class OSIVFilter implements Filter {

	public OSIVFilter() {
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
		DAOFactory.close();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		try {
			
			// Autenticacao
			AutenticacaoUtil.verificarAutorizacaoPagina(req);
			
			

			// pass the request along the filter chain
			chain.doFilter(request, response);

		} catch (LoginInvalidoException logExc){
//			logExc.printStackTrace();
			System.out.println("Login invalido");
			// Redirecionar para pagina inicial
			RequestDispatcher dis = request
					.getRequestDispatcher("/index.xhtml");
			dis.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new ServletException(e.getMessage());
		} finally {
			
			
		}
	}

}
