package eu.solidcraft.starter.examples.task1.rule;

import org.springframework.stereotype.Component;

@Component
public class LoansHistoryScoringRule implements ScoringRule {
    @Override
    public Long getScore() {
        return 3L;
    }
}
