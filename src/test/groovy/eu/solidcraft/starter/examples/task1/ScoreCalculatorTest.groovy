package eu.solidcraft.starter.examples.task1

import base.IntegrationSpec
import eu.solidcraft.starter.examples.task1.detector.FraudException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier

class ScoreCalculatorTest extends IntegrationSpec {

    @Autowired
    @Qualifier("polishScoreCalculator")
    ScoreCalculator polishScoreCalculator

    @Autowired
    @Qualifier("englishScoreCalculator")
    ScoreCalculator englishScoreCalculator

    def "should calculate loan apply for PL"() {

        when:
        def result = polishScoreCalculator.calculateLoanApply()

        then:
        result == 7.1
    }

    def "should calculate loan apply for ENG"() {

        when:
        englishScoreCalculator.calculateLoanApply()

        then:
        thrown FraudException
    }
}
