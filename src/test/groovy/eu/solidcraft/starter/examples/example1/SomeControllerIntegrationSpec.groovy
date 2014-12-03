package eu.solidcraft.starter.examples.example1
import base.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired

class SomeControllerIntegrationSpec extends IntegrationSpec {
    @Autowired SomeController someController
    @Autowired SomeEntityRepository someEntityRepository
    BigDecimal amount = new BigDecimal(1000)

    def "add should save entity to DB"() {
        when:
            someController.add(amount)

        then:
            List<SomeEntity> entities = someEntityRepository.findByUsername(user.username)
            entities.size() == 1
            firstEntityIsCorrect(entities)
    }

    def "should show my entities"() {
        given:
            someController.add(amount)

        when:
            Map response = someController.mine()

        then:
            firstEntityIsCorrect(response.entities)
    }


    private void firstEntityIsCorrect(List<SomeEntity> entities) {
        SomeEntity someEntity = entities.first()
        someEntity.someAmount == amount
        someEntity.username == user.username
    }
}
