package br.com.inmetrics.teste.steps;

import java.io.IOException;

import br.com.inmetrics.teste.page.BasePage;
import br.com.inmetrics.teste.page.CadastrarUsuarioPage;
import br.com.inmetrics.teste.page.LoginPage;
import br.com.inmetrics.teste.support.Utils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;

public class CadastrarUsuarioSteps  extends BasePage{
	
	CadastrarUsuarioPage cup = new CadastrarUsuarioPage();
	
	@Dado("acesse que o usuario acesse menu cadastre-se")
	public void acesseOMenuCadastreSe() {
		cup.acionarLinkDeCadastro();
	}

	@Dado("preencher o campo usuario com o valor {string}")
	public void preencherOCampoUsuarioComOValor(String usuario) {

		cup.preencherCampoUsuario(usuario);
	}

	@Dado("preencher o campo senha com o valor {string}")
	public void preencherOCampoSenhaComOValor(String senha) {

		cup.preencherCampoSenha(senha);
	}

	@Dado("preencher o campo confirmar senha com o valor {string}")
	public void preencherOCampoConfirmarSenhaComOValor(String senha) {

		cup.preencherCampoConfirmarSenha(senha);
	}

	@Quando("acionar o botao Cadastrar")
	public void acionarOBotaoCadastrar() {
		
		cup.acionarBotaoCadastrar();

	}	
	
	@Quando("posicionar o mouse sobre o campo confirmar senha")
	public void posicionarOMouseSobreOCampoSenha() throws Exception {
		cup.moverMouseCampoConfirmarSenha();
		Utils.esperarPagina(1);
	}	
	
	@Dado("que o usuario preenha o campo usuario valido")
	public void queOUsuarioPreenhaOCampoUsuarioValido() throws IOException {
		LoginPage lp = new LoginPage();
		lp.realizarLoginValidoAleatorio();
	}	
	
}
