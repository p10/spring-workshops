package eu.solidcraft.starter.examples.task1.rule;

import java.math.BigDecimal;

public class AgeScoringRule implements ScoringRule {
    @Override
    public BigDecimal getScore() {
        return BigDecimal.ONE;
    }
}
