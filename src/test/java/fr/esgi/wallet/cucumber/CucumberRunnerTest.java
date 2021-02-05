package fr.esgi.wallet.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"fr.esgi.wallet.cucumber.features"},
        features = {"src/test/resources/fr/esgi/wallet/cucumber/features"},
        plugin = {"json:target/cucumber.json"} //Generate json report for my jenkins
)
public class CucumberRunnerTest {
}
