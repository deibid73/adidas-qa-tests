package com.adidas.qa.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/cucumber-html-reports", "json:target/cucumber-json/report.json"},
        features = {"classpath:featurefiles"},
        tags = {"@UI", "~@TODO", "~@SKIP"},
        glue = {"classpath:com/adidas/qa/stepdef"},
        strict = true)
public class RunUITest {
}
