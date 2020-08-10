package br.com.inmetrics.teste.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.inmetrics.teste.support.Utils;

public class CadastrarUsuarioPage extends BasePage {

	@FindBy(xpath = "//a[contains(text(),'Cadastre-se')][1]")
	private WebElement linkCadastrese;
	
	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement campoUsuario;

	@FindBy(xpath = "//input[@name=\"pass\"]")
	private WebElement campoSenha;
	
	@FindBy(xpath = "//input[@name=\"confirmpass\"]")
	private WebElement campoConfirmaSenha;	
		
	@FindBy(xpath = "//button[contains(text(),'Cadastrar')]")
	private WebElement botaoCadastrar;	
		
	
		
	public void acionarLinkDeCadastro() {
		clicarWebElement(linkCadastrese);
	}
	
	public void preencherCampoUsuario(String usuario) {
		escreverWebElement(campoUsuario, usuario);
	}

	public void preencherCampoSenha(String senha) {
		escreverWebElement(campoSenha,senha);
	}	
	
	public void preencherCampoConfirmarSenha(String senha) {
		escreverWebElement(campoConfirmaSenha,senha);
	}		
	
	public void acionarBotaoCadastrar() {
		clicarWebElement(botaoCadastrar);
	}	
	
	public void moverMouseCampoConfirmarSenha() {
		Utils.mouseHoverElemento(campoConfirmaSenha);
	}	
}
