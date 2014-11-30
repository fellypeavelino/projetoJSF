package gui;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dados.Beans.LoginBeans;

public class AutenticacaoUtil {

	private static final String[] arquivosEscape = { "javax.faces.resource",
			"index.xhtml", "novo-usuario.xhtml" };

	/**
	 * 
	 * @param request
	 * @return
	 * @throws LoginInvalidoException
	 */
	public static void verificarAutorizacaoPagina(HttpServletRequest request)
			throws LoginInvalidoException {

		// Verificar se a pagina solicitada eh livre de autenticacao
		String resource = request.getRequestURI();
		for (String esc : arquivosEscape) {
			if (resource.contains(esc)) {
				return;
			}
		}
		System.out.println(resource);

		// Sessao
		HttpSession sessao = request.getSession();

		if (sessao == null
				|| sessao.getAttribute("loginBeans") == null
				|| ((LoginBeans) sessao.getAttribute("loginBeans")).getPessoaFisica().getCpf() == null) {
			
			throw new LoginInvalidoException(resource);
			
		}

	}

}
