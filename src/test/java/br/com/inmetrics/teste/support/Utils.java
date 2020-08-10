package br.com.inmetrics.teste.support;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.Scenario;

public class Utils {
		
	public static ChromeDriver driver;

	public static void acessarSistema() {
				
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/driver/chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/driver/geckodriver.exe");		

		driver = new ChromeDriver();
		
//		driver = new FirefoxDriver();
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get(DataProject.URL);
	}
	
	

	@SuppressWarnings("deprecation")
	public static void capturarScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
	}
	
	public static void esperarPagina(int tempo) throws Exception {
		for (int i = 0; i < tempo; i++) {
			Thread.sleep(1000);
		}
	}	
	
	public static void paginaContemTexto(String texto) throws Exception {
		boolean existe = false;
		for (int i = 0; i < 4; i++) {
			existe = driver.getPageSource().contains(texto);
			if (existe == false) {
				Thread.sleep(1000);
			} else {
				break;
			}
		}
		assertTrue(existe);
	}	
	
	public static boolean textoExiste(String arg1) {
		System.out.println(arg1);
		boolean existe = driver.getPageSource().contains(arg1);
		return existe;
	}

	public static void validaMensagem(String mensagem) {
		assertTrue(driver.getPageSource().contains(mensagem));
//		System.out.println(driver.getPageSource().contains(mensagem));
	}	
	
	public static boolean elementoExiste(String elemento) {
		boolean existe = false;
		try {
			existe = Utils.driver.findElement(By.xpath(elemento)).isEnabled();
		} catch (NoSuchElementException e) {
			existe = false;
		}
		return existe;
	}	
	
	public static String projectDir() {
		String diretorio = System.getProperty("user.dir");
		return diretorio;
	}	
	
	public static void gravarLogin(String texto) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(DataProject.PATH_lOGIN));
		buffWrite.append(texto + "\n");
		buffWrite.close();
	}	
	
	public static void gravarLogLogin(String texto) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(DataProject.PATH_LOGIN_LOGIN, true));
		buffWrite.append(texto + " - " + getCurrentData() + "\n");
		buffWrite.close();
	}	

	
	public static String getCurrentData() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}	
	
	public static String lerLogin(String file) throws IOException {

		String ultimo = "";
		try {
			InputStream is = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line = "";
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					ultimo = line;
				}
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ultimo;
	}	
	
	public static String gerarNomeAleatorio(String nome) {
		
			String[] a = { "GANDALF MARTINS","GOLLUM MARTINS", "LEGOLAS MARTINS", "GIMLI MARTINS", "GALADRIEL MARTINS", "ELROND", "SARUMAN MARTINS", "NAZGUL MARTINS" };
			
			List<String> listaNomes = new ArrayList<String>();
			
			Random r = new Random();			
			int i = r.nextInt(a.length);
			
			for (int j = 0; j < 50; j++) {
				listaNomes.add(Integer.toString(i));
			}

			int j = r.nextInt(listaNomes.size());
			return nome + j + "." + a[i];
		}
	
	
	
	public static void mouseHoverElemento(WebElement elemento) {
		Actions action = new Actions(driver);
		action.moveToElement(elemento).perform();
	}	
	
	public static String retornaCpfAleatorio() {
		String[] a = { "53936540144", "60562609172", "00206962134" };
		Random r = new Random();
		int i = r.nextInt(a.length);
		return a[i];
	}	
	
	
	public static String geraCPF() throws Exception {

		int digito1 = 0, digito2 = 0, resto = 0;
		String nDigResult;
		String numerosContatenados;
		String numeroGerado;

		Random numeroAleatorio = new Random();

		// numeros gerados
		int n1 = numeroAleatorio.nextInt(10);
		int n2 = numeroAleatorio.nextInt(10);
		int n3 = numeroAleatorio.nextInt(10);
		int n4 = numeroAleatorio.nextInt(10);
		int n5 = numeroAleatorio.nextInt(10);
		int n6 = numeroAleatorio.nextInt(10);
		int n7 = numeroAleatorio.nextInt(10);
		int n8 = numeroAleatorio.nextInt(10);
		int n9 = numeroAleatorio.nextInt(10);

		int soma = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

		int valor = (soma / 11) * 11;

		digito1 = soma - valor;

		// Primeiro resto da divisão por 11.
		resto = (digito1 % 11);

		if (digito1 < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		int soma2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

		int valor2 = (soma2 / 11) * 11;

		digito2 = soma2 - valor2;

		// Primeiro resto da divisão por 11.
		resto = (digito2 % 11);

		if (digito2 < 2) {
			digito2 = 0;
		}

		else {
			digito2 = 11 - resto;
		}

		// Concatenando os numeros
		numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4)
				+ String.valueOf(n5) + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8)
				+ String.valueOf(n9);

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		numeroGerado = numerosContatenados + nDigResult;

		return numeroGerado;
	}	
	}

