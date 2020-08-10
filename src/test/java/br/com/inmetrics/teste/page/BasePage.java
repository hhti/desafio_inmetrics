package br.com.inmetrics.teste.page;

import static br.com.inmetrics.teste.support.Utils.driver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.inmetrics.teste.support.Utils;

public class BasePage {

	public BasePage() {
		PageFactory.initElements(driver, this);
	}


	public void escrever(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}

	public void escreverPorXpath(String xpath_campo, String texto) {
		escrever(By.xpath(xpath_campo), texto);
	}

	public void escreverWebElement(WebElement xpath_campo, String texto) {
		xpath_campo.sendKeys(texto);
	}

	public void clicarWebElement(WebElement xpath_campo) {
		xpath_campo.click();
	}

	public void clicarWebElementWait(WebElement xpath_campo, int time) {
		WebDriverWait wait = new WebDriverWait(Utils.driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(xpath_campo)).click();

	}

	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}

	public void clicarRadio(By by) {
		driver.findElement(by).click();
	}

	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}

	public boolean isRadioMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	public void clicarCheck(String id) {
		driver.findElement(By.id(id)).click();
	}

	public boolean isCheckMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	public void selecionarComboWebElement(WebElement elemento, String valor) {
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valor);
	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void deselecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public List<String> obterValoresCombo(String id) {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}

	public int obterQuantidadeOpcoesCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}

	public boolean verificarOpcaoCombo(String id, String opcao) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(opcao)) {
				return true;
			}
		}
		return false;
	}

	public void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='" + radical + "_input']/../..//span"));
		clicarRadio(By.xpath("//*[@id='" + radical + "_items']//li[.='" + valor + "']"));
	}

	public void clicarBotao(By by) {
		driver.findElement(by).click();
	}

	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}

	public void clicarBotaoPorTexto(String texto) {
		clicarBotao(By.xpath("//button[.='" + texto + "']"));
	}

	public String obterValueElemento(String id) {
		return driver.findElement(By.id(id)).getAttribute("value");
	}


	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}


	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}


	public String alertaObterTexto() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public String alertaObterTextoEAceita() {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;

	}

	public String alertaObterTextoENega() {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;

	}

	public void alertaEscrever(String valor) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}


	public void entrarFrame(String id) {
		driver.switchTo().frame(id);
	}

	public void sairFrame() {
		driver.switchTo().defaultContent();
	}

	public void trocarJanela(String id) {
		driver.switchTo().window(id);
	}


	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
	}


	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		// procurar coluna do registro
		WebElement tabela = driver.findElement(By.xpath("//*[@id='" + idTabela + "']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		// encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		// procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

		// clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		return celula;
	}

	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();

	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}
}
