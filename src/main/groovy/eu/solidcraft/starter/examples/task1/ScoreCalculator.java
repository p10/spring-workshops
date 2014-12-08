package eu.solidcraft.starter.examples.task1;

import eu.solidcraft.starter.examples.task1.detector.FraudDetector;
import eu.solidcraft.starter.examples.task1.detector.FraudException;
import eu.solidcraft.starter.examples.task1.rule.ScoringRule;

public class ScoreCalculator {

    private FraudDetector fraudDetector;

    private ScoringRuleProvider scoringRuleProvider;

    public ScoreCalculator(FraudDetector fraudDetector, ScoringRuleProvider scoringRuleProvider) {
        this.fraudDetector = fraudDetector;
        this.scoringRuleProvider = scoringRuleProvider;
    }

    public Long calculateLoanApply() {

        if (fraudDetector.isFraud()) {
            throw new FraudException();
        }

        return scoringRuleProvider
                .getRules()
                .stream()
                .map(ScoringRule::getScore)
                .reduce((score1, score2) -> score1 + score2).get();
    }
}
