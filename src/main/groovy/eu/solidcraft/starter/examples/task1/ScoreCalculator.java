package eu.solidcraft.starter.examples.task1;

import eu.solidcraft.starter.examples.task1.detector.FraudDetector;
import eu.solidcraft.starter.examples.task1.detector.FraudException;
import eu.solidcraft.starter.examples.task1.rule.ScoringRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.BinaryOperator;

public class ScoreCalculator {

    private FraudDetector fraudDetector;

    private ScoringRuleProvider scoringRuleProvider;

    @Autowired
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
