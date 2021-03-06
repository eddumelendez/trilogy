package io.pivotal.trilogy.testproject

import io.pivotal.trilogy.reporting.TestCaseResult
import io.pivotal.trilogy.reporting.TestResult
import org.jetbrains.spek.api.Spek
import kotlin.test.expect

class TestProjectResultTest : Spek({
    it("is not fatally failed by default") {
        expect(false) { TestProjectResult(emptyList()).hasFatalFailure }
    }

    it("has fatally failed when a failure message is present") {
        expect(true) { TestProjectResult(emptyList(), failureMessage = "message").hasFatalFailure }
    }

    it("is not failed by default") {
        expect(false) { TestProjectResult(emptyList()).hasFailed }
    }

    it("has failed when at least one test is failed") {
        expect(true) { TestProjectResult(listOf(TestCaseResult("", listOf(TestResult("", "ERROR"))))).hasFailed }
    }
})