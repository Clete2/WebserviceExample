package sf.example;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"cucumber.runtime.java.spring.contextconfig",
		"cucumber.runtime.java.spring.commonglue",
		"cucumber.api.spring",
		"sf.example"})
public class RunTest {
}
