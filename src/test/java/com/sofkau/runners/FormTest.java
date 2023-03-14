package com.sofkau.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/practiceform.feature"},
        glue = {"com.sofkau.stepdefinitions"},
        publish = true
)


public class FormTest {


}
