package eu.solidcraft.starter.examples.loan;

import eu.solidcraft.starter.examples.example1.SomeEntity;
import eu.solidcraft.starter.examples.example1.SomeEntityRepository;
import eu.solidcraft.starter.examples.loan.dto.LoanRequest;
import eu.solidcraft.starter.examples.loan.dto.LoanResponse;
import eu.solidcraft.starter.examples.loan.model.TooManyLoansException;
import eu.solidcraft.starter.examples.loan.utils.DateTimeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanService {

    private SomeEntityRepository someEntityRepository;

    private DateTimeProvider dateTimeProvider;

    @Autowired
    public LoanService(SomeEntityRepository someEntityRepository, DateTimeProvider dateTimeProvider) {
        this.someEntityRepository = someEntityRepository;
        this.dateTimeProvider = dateTimeProvider;
    }

    public List<LoanResponse> getLoans(String username) {

        List<SomeEntity> someEntities = someEntityRepository
                .findByUsername(username);
        if (someEntities == null || someEntities.isEmpty()) {
            return new ArrayList<>();
        }
        return someEntities
                .stream()
                .map(someEntity -> new LoanResponse(
                        someEntity.getId(),
                        someEntity.getUsername(),
                        someEntity.getSomeAmount(),
                        someEntity.getSomeDate()
                        )
                )
                .collect(Collectors.toList());
    }

    public void applyForLoan(LoanRequest loanRequest) {

        if (getLoans(loanRequest.getUsername()).stream().filter(loan -> loan.getSomeDate().compareTo(dateTimeProvider.now()) > 0).count() == 3) {
            throw new TooManyLoansException();
        }

        someEntityRepository.save(new SomeEntity(loanRequest.getUsername(), loanRequest.getSomeAmount(), loanRequest.getSomeDate()));
    }
}
