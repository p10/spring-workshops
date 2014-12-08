package eu.solidcraft.starter.examples.task1;

import com.google.common.collect.ImmutableList;
import eu.solidcraft.starter.examples.task1.rule.ScoringRule;

import java.util.Collection;
import java.util.List;

/**
 * Created by kamil.piska on 2014-12-08.
 */
public class ScoringRuleProvider {
    private List<ScoringRule> rules;

    public ScoringRuleProvider(List<ScoringRule> rules) {
        this.rules = ImmutableList.copyOf(rules);
    }

    public List<ScoringRule> getRules() {
        return rules;
    }
}
