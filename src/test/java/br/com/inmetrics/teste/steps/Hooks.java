package br.com.inmetrics.teste.steps;

import static br.com.inmetrics.teste.support.Utils.acessarSistema;
import static br.com.inmetrics.teste.support.Utils.capturarScreenshot;
import static br.com.inmetrics.teste.support.Utils.driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void setUp() {
		acessarSistema();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		capturarScreenshot(scenario);
		driver.close();
		driver.quit();
	}

}

