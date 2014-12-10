package eu.solidcraft.starter.examples.loan

import eu.solidcraft.starter.examples.example1.SomeEntity
import eu.solidcraft.starter.examples.example1.SomeEntityRepository
import eu.solidcraft.starter.examples.loan.dto.LoanRequest
import eu.solidcraft.starter.examples.loan.dto.LoanResponse
import eu.solidcraft.starter.examples.loan.model.TooManyLoansException
import eu.solidcraft.starter.examples.loan.utils.DateTimeProvider
import org.joda.time.DateTime
import spock.lang.Specification

class LoanServiceTest extends Specification {

    LoanService loanService
    SomeEntityRepository someEntityRepository
    DateTimeProvider dateTimeProvider

    void setup() {
        someEntityRepository = Mock(SomeEntityRepository)
        dateTimeProvider = Stub(DateTimeProvider)
        loanService = new LoanService(someEntityRepository, dateTimeProvider)
    }

    def "should return empty list when none loans for given user"() {

        given:
        def username = "someUser"

        when:
        def loans = loanService.getLoans(username)

        then:
        loans == []
    }

    def "should return loans for given user"() {

        given:
        def username = "someUser"
        def expectedLoans = [
                new LoanResponse(1, username, 20, DateTime.parse("2014-01-01").toDate()),
                new LoanResponse(2, username, 30, DateTime.parse("2014-02-01").toDate())
        ]

        def someEntity1 = new SomeEntity(username, 20, DateTime.parse("2014-01-01").toDate())
        someEntity1.id = 1

        def someEntity2 = new SomeEntity(username, 30, DateTime.parse("2014-02-01").toDate())
        someEntity2.id = 2

        someEntityRepository.findByUsername(username) >> [someEntity1, someEntity2]

        when:
        def loans = loanService.getLoans(username)

        then:
        loans == expectedLoans
    }

    def "should user be able to apply new loan"() {

        given:
        def username = "someUser"
        def loan = new LoanRequest(username, 20, DateTime.parse("2014-01-01").toDate())
        def someEntity = new SomeEntity(username, 20, DateTime.parse("2014-01-01").toDate())

        when:
        loanService.applyForLoan(loan)

        then:
        1 * someEntityRepository.save(someEntity)
    }

    def "should not be allowed to apply new loan when have 3 active"() {

        given:
        dateTimeProvider.now() >> DateTime.parse("2013-12-31").toDate()
        def username = "someUser"
        def loan = new LoanRequest(username, 20, DateTime.parse("2014-01-01").toDate())

        def someEntity1 = new SomeEntity(username, 20, DateTime.parse("2014-01-01").toDate())
        someEntity1.id = 1

        def someEntity2 = new SomeEntity(username, 30, DateTime.parse("2014-01-10").toDate())
        someEntity2.id = 2

        def someEntity3 = new SomeEntity(username, 40, DateTime.parse("2014-01-15").toDate())
        someEntity3.id = 3

        someEntityRepository.findByUsername(username) >> [someEntity1, someEntity2, someEntity3]

        when:
        loanService.applyForLoan(loan)

        then:
        thrown(TooManyLoansException)
    }

    def "should be allow to apply new loan when don't have 3 active loans"() {

        given:
        dateTimeProvider.now() >> DateTime.parse("2014-01-02").toDate()
        def username = "someUser"
        def loan = new LoanRequest(username, 20, DateTime.parse("2014-01-01").toDate())

        def someEntity1 = new SomeEntity(username, 20, DateTime.parse("2014-01-01").toDate())
        someEntity1.id = 1

        def someEntity2 = new SomeEntity(username, 30, DateTime.parse("2014-01-10").toDate())
        someEntity2.id = 2

        def someEntity3 = new SomeEntity(username, 40, DateTime.parse("2014-01-15").toDate())
        someEntity3.id = 3

        someEntityRepository.findByUsername(username) >> [someEntity1, someEntity2, someEntity3]

        when:
        loanService.applyForLoan(loan)

        then:
        notThrown(TooManyLoansException)
    }
}
