package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/featureFiles",glue = {"stepDefinationsFiles"},
        plugin= {"pretty","html:target/cucuber/c.html","json:target/cucumber/json.json"}
       ,monochrome=true
		)
public class TestrunnerFile1 {

}