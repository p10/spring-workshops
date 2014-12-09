package eu.solidcraft.starter.examples.task1.rule;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Scope("prototype")
public class UserHistoryScoringRule implements ScoringRule {

    private BigDecimal currentScore = BigDecimal.ONE;

    @Override
    public BigDecimal getScore() {
        currentScore = currentScore.multiply(BigDecimal.valueOf(1.1));
        return currentScore;
    }
}
