package eu.solidcraft.starter.examples.task1.rule;

import org.springframework.stereotype.Component;

@Component
public class JobScoringRule implements ScoringRule {
    @Override
    public Long getScore() {
        return 2L;
    }
}
