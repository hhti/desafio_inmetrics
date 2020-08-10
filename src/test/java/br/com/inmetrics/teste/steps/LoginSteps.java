package br.com.inmetrics.teste.steps;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import br.com.inmetrics.teste.page.BasePage;
import br.com.inmetrics.teste.page.LoginPage;
import br.com.inmetrics.teste.support.Utils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginSteps extends BasePage {

	LoginPage login = new LoginPage();

	@Dado("que o usuario insira dados invalidos na aplicacao inmrobo")
	public void queOUsuarioAcesseAAplicacaoInmrobo() {
		login.realizarLoginInvalido();

	}

	@Então("^o sistema emite a mensagem \"([^\"]*)\"$")
	public void oSistemaEmiteAmensagem(String texto) throws Exception {
		Utils.esperarPagina(3);
		login.validarMensagem(texto);
	}

	@Então("^o sistema emite o texto \"([^\"]*)\"$")
	public void oSistemaEmiteOtexto(String texto) throws Exception {
		Utils.esperarPagina(2);
		assertTrue(Utils.textoExiste(texto));
	}
		
	@Dado("que o usuario nao preencha nenhum dos campos")
	public void queOUsuarioNaoPreenchaNenhumDosCampos() throws Exception {
		Utils.esperarPagina(1);
	}

	@Dado("que o usuario preenha o campo senha")
	public void queOUsuarioInsiraPreenhaOCampoSenha() {
		login.preencherCampoSenha();
	}

	@Dado("que o usuario preenha o campo usuario")
	public void queOUsuarioInsiraPreenhaOCampoUsuario() {
		login.preencherCampoUsuario();
	}

	@Dado("acione o botao Entre")
	public void acioneOBotaoEntre() throws Exception {
		login.acionarBotaoEntrar();
	}

	@Quando("posicionar o mouse sobre o campo usuario")
	public void posicionarOMouseSobreOCampoUsuario() throws Exception {
		login.moverMouseCampoUsuario();
		Utils.esperarPagina(1);
	}

	@Quando("posicionar o mouse sobre o campo senha")
	public void posicionarOMouseSobreOCampoSenha() throws Exception {
		login.moverMouseCampoSenha();
		Utils.esperarPagina(1);
	}
	
	@Dado("que o usuario preenha o campo usuario com um usuario previamente cadastrado")
	public void queOUsuarioPreenhaOCampoUsuarioComUmUsuarioPreviamenteCadastrado() throws IOException {
		login.preencherCampoUsuarioUsuarioPreviamenteCadastrado();
	}		

}
