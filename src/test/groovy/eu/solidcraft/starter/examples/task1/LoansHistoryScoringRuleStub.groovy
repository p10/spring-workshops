package eu.solidcraft.starter.examples.task1

import eu.solidcraft.starter.examples.task1.rule.ScoringRule

class LoansHistoryScoringRuleStub implements ScoringRule {

    @Override
    BigDecimal getScore() {
        return 100
    }
}
