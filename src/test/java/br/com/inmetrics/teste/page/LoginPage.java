package br.com.inmetrics.teste.page;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.inmetrics.teste.support.DataProject;
import br.com.inmetrics.teste.support.Utils;


public class LoginPage extends BasePage {

	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement campoUsuario;

	@FindBy(xpath = "//input[@name=\"pass\"]")
	private WebElement campoPassword;

	@FindBy(xpath = "//button[contains(text(),'Entre')]")
	private WebElement BotaoEntrar;

	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible fade show\"]")
	private WebElement mensagem;
		
	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible fade show\"]")
	private WebElement mensagemSucesso;	
	

	public void realizarLoginInvalido() {
		String nome = Utils.gerarNomeAleatorio("FRODO");
		System.out.println(nome);
		escreverWebElement(campoUsuario, nome);
		escreverWebElement(campoPassword, "inmrobo123");
		clicarWebElement(BotaoEntrar);
	}
	
	public void realizarLoginValidoAleatorio() throws IOException {
		String nome = Utils.gerarNomeAleatorio("FRODO");
		System.out.println(nome);
		escreverWebElement(campoUsuario, nome);
		Utils.gravarLogin(nome);
		Utils.gravarLogLogin(nome);
	}	
	
	public void preencherCampoUsuarioUsuarioPreviamenteCadastrado() throws IOException {
		escreverWebElement(campoUsuario, buscarLogin());
	}	


	public void preencherCampoUsuario() {
		escreverWebElement(campoUsuario, "Joao");
	}

	public void preencherCampoSenha() {
		escreverWebElement(campoPassword, "inmrobo123");
	}

	public void acionarBotaoEntrar() {
		clicarWebElement(BotaoEntrar);
	}

	public void moverMouseCampoUsuario() {
		Utils.mouseHoverElemento(campoUsuario);
	}

	public void moverMouseCampoSenha() {
		Utils.mouseHoverElemento(campoPassword);
	}

	public void validarMensagem(String texto) {
		assertTrue(texto.trim().toUpperCase().toString().equals(
				mensagem.getText().substring(0, mensagem.getText().length() - 1).trim().toUpperCase().toString()));
	}
	
	public void validarMensagemSucesso(String texto) {
		assertTrue(texto.trim().toUpperCase().toString().equals(
				mensagemSucesso.getText().substring(0, mensagemSucesso.getText().length() - 1).trim().toUpperCase().toString()));
	}	
	
	
	
		
	public String buscarLogin() throws IOException {
		return Utils.lerLogin(DataProject.PATH_lOGIN);
	}

}
