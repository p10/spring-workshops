package eu.solidcraft.starter.examples.task1.rule;

import org.springframework.stereotype.Component;

@Component
public class AgeScoringRule implements ScoringRule {
    @Override
    public Long getScore() {
        return 1L;
    }
}
