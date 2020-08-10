package br.com.inmetrics.teste.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.inmetrics.teste.support.Utils;

public class CadastrarFuncionarioPage extends BasePage {
	
	@FindBy(id = "inputNome")
	private WebElement campoNome;

	@FindBy(id = "cpf")
	private WebElement campoCpf;
	
	@FindBy(id = "inputCargo")
	private WebElement campoCargo;

	@FindBy(id = "dinheiro")
	private WebElement campoSalario;	

	@FindBy(id = "slctSexo")
	private WebElement campoSexo;
	
	@FindBy(id = "clt")
	private WebElement radioClt;
	
	@FindBy(id = "pj")
	private WebElement radioPj;	
	
	@FindBy(id = "inputAdmissao")
	private WebElement inputAdmissao;		
		
	@FindBy(xpath = "//input[contains(text(),'Submit Query)]")
	private WebElement botaoSbmit;	
	
	@FindBy(xpath = "//a[contains(text(),'Novo Funcionário')]")
	private WebElement LinkNovoFuncionario;	
	
	public void acionarLinkNovoFuncionario() {
		clicarWebElementWait(LinkNovoFuncionario, 40);
	}
	
	public void preencherCampoNome(String nome) {
		
		escreverWebElement(campoNome, nome);
	}
	
	public void preencherCampoCpf() throws Exception {
		
		escreverWebElement(campoCpf, Utils.retornaCpfAleatorio());
	}

	public void preencherCampoCargo(String cargo) {
		
		escreverWebElement(campoCargo, cargo);
	}
	
	public void preencherCampoSalario(String salario) {
		
		escreverWebElement(campoSalario, salario);
	}
	
	
	public void selecionarSexoMasculino() {
		
		selecionarComboWebElement(campoSexo, "Masculino");
	}	
	
	public void selecionarSexoFeminino() {
		
		selecionarComboWebElement(campoSexo, "Feminino");
	}	
	
	
	public void selecionarOpcaoClt() {
		clicarWebElement(radioClt);				
	}
	
	public void selecionarOpcaoPj() {
		clicarWebElement(radioPj);				
	}	
	
	
	public void acionarBotaoSubmit() {
		clicarWebElement(botaoSbmit);		
	}
	
	public void escreverCampoAdmissao(String data) {
		escreverWebElement(inputAdmissao, data);
		
	
	}
	
	
	
}
