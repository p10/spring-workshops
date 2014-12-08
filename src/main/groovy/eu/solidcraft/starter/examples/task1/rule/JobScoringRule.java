package eu.solidcraft.starter.examples.task1.rule;

public class JobScoringRule implements ScoringRule {
    @Override
    public Long getScore() {
        return 2L;
    }
}
