package eu.solidcraft.starter.examples.task1;

import com.google.common.collect.ImmutableList;
import eu.solidcraft.starter.examples.task1.rule.ScoringRule;

import java.util.List;

public class ScoringRuleProvider {

    private List<ScoringRule> rules;

    public ScoringRuleProvider(List<ScoringRule> rules) {
        this.rules = ImmutableList.copyOf(rules);
    }

    public List<ScoringRule> getRules() {
        return rules;
    }
}
