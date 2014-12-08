package eu.solidcraft.starter.examples.task1

import base.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired

class ScoreCalculatorTest extends IntegrationSpec {

    @Autowired
    ScoreCalculator scoreCalculator

    def "should calculate loan apply"() {

        when:
        def result = scoreCalculator.calculateLoanApply()

        then:
        result == 6
    }
}
