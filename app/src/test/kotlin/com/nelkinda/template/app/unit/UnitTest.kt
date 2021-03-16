package com.nelkinda.template.app.unit

import io.cucumber.java8.En
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@CucumberOptions(
        publish = false,
        features = ["src/test/resources/features"],
        glue = ["com.nelkinda.template.app.unit"]
)
@RunWith(io.cucumber.junit.Cucumber::class)
class UnitTest : En
