package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.page.BasePage;
import br.com.inmetrics.teste.page.CadastrarFuncionarioPage;
import br.com.inmetrics.teste.page.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastrarFuncionarioSteps extends BasePage {

	CadastrarFuncionarioPage cfp = new CadastrarFuncionarioPage();
	@Dado("acionar o botao Novo Funcionario")
	public void acionarOBotaoNovoFuncionario() {			
		cfp.acionarLinkNovoFuncionario();
	}
	
	
	@Quando("acionar o botao Enviar")
	public void acionarOBotaoEnviar() {
		cfp.acionarBotaoSubmit();
	}	
	
	@Dado("preencher todos campos")
	public void preencherTodosCampos() throws Exception {
		cfp.preencherCampoNome("Juliano Martins");
		cfp.preencherCampoCpf();
		cfp.preencherCampoCargo("Analista de Sistemas");
		cfp.preencherCampoSalario("800000");
		cfp.selecionarSexoMasculino();
		cfp.selecionarOpcaoClt();	
		cfp.escreverCampoAdmissao("22081990");
	}	
	
	@Entao("o sistema emite a mensagem de sucesso {string}")
	public void oSistemaEmiteAMensagemDeSucesso(String texto) {
		
		LoginPage login = new LoginPage();
		login.validarMensagemSucesso(texto);
	}	
	

}
