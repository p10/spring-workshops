package eu.solidcraft.starter.examples.task1.rule;

public class LoansHistoryScoringRule implements ScoringRule {
    @Override
    public Long getScore() {
        return 3L;
    }
}
