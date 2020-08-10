package br.com.inmetrics.teste.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report",
		   "json:target/cucumber-report/cucumber.json"},
		features = "src/test/resources/features/",
		glue = "br.com.inmetrics.teste.steps",
		tags = {"@FE001_CadastroFucionario"},
		strict = false,	
		snippets = SnippetType.CAMELCASE,
		dryRun = false)

public class RunnerTest {
	
}
