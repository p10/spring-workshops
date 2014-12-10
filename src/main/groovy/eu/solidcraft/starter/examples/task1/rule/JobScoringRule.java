package eu.solidcraft.starter.examples.task1.rule;

import java.math.BigDecimal;

public class JobScoringRule implements ScoringRule {
    @Override
    public BigDecimal getScore() {
        return BigDecimal.valueOf(2);
    }
}
