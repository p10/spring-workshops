package eu.solidcraft.starter
import base.IntegrationSpec
import eu.solidcraft.starter.domain.SomeService
import org.springframework.beans.factory.annotation.Autowired

class ScoreCalculatorSpec extends IntegrationSpec {
    @Autowired
    SomeService someService

    def "score calculator should be injected"() {
        expect:
            someService != null
    }
}
