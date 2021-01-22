package fr.esgi.wallet.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/fr/esgi/wallet/cucumber/features"}
        ,glue = {"fr.esgi.wallet.cucumber.features"}
)
public class CucumberRunnerTest {
}
