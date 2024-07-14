package framework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html",
                "junit:target/cucumber.xml",
                "json:target/cucumber-report.json"},
        //Path to feature files
        features = {"src/test/resources/features"},
        //Specify tags to be executed
        tags = "@webprojecthotels",
        //Specify step definition package name
        glue = {"stepdefinition"}
)

public class TestRunner{
}
