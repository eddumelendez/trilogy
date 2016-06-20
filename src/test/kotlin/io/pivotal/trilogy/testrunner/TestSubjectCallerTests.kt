package io.pivotal.trilogy.testrunner


import io.pivotal.trilogy.DatabaseHelper
import org.jetbrains.spek.api.Spek
import org.springframework.jdbc.core.simple.SimpleJdbcCall
import java.math.BigDecimal
import kotlin.test.expect

class TestSubjectCallerTests : Spek ({
    val procedureCall = SimpleJdbcCall(DatabaseHelper.dataSource())

    it("returns the result of the execution") {
        val returnValue = mapOf(Pair("V_OUT", BigDecimal.ONE))
        val actualReturnValue = TestSubjectCaller(procedureCall, "degenerate", listOf("V_IN")).call(listOf("1"))
        expect(returnValue) { actualReturnValue }
    }

    it("accepts NULL values as arguments") {
        val returnValue = mapOf(Pair("V_OUT", null))
        val actualReturnValue = TestSubjectCaller(procedureCall, "degenerate", listOf("V_IN")).call(listOf("__NULL__"))
        expect(returnValue) { actualReturnValue }
    }

})