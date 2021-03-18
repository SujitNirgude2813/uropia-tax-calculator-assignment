package com.nelkinda.template.app.acceptance

import io.cucumber.java8.En
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@CucumberOptions(
        publish = false,
        features = ["../features"],
        glue = ["com.nelkinda.template.app.acceptance"]
)
@RunWith(io.cucumber.junit.Cucumber::class)
class AcceptanceTest : En
