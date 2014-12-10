package eu.solidcraft.starter.conf.task1;

import com.google.common.collect.ImmutableList;
import eu.solidcraft.starter.examples.task1.ScoreCalculator;
import eu.solidcraft.starter.examples.task1.ScoringRuleProvider;
import eu.solidcraft.starter.examples.task1.detector.EnglishFraudDetector;
import eu.solidcraft.starter.examples.task1.detector.FraudDetector;
import eu.solidcraft.starter.examples.task1.detector.PolishFraudDetector;
import eu.solidcraft.starter.examples.task1.rule.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private UserHistoryScoringRule userHistoryScoringRule;

    @Bean
    public FraudDetector polishFraudDetector() {
        return new PolishFraudDetector();
    }

    @Bean
    public FraudDetector englishFraudDetector() {
        return new EnglishFraudDetector();
    }

    @Bean
    public ScoreCalculator polishScoreCalculator() {
        return new ScoreCalculator(polishFraudDetector(), scoringRuleProvider());
    }

    @Bean
    public ScoreCalculator englishScoreCalculator() {
        return new ScoreCalculator(englishFraudDetector(), scoringRuleProvider());
    }

    @Bean
    public ScoringRuleProvider scoringRuleProvider() {
        return new ScoringRuleProvider(
                ImmutableList.<ScoringRule>builder()
                    .add(new AgeScoringRule())
                    .add(new JobScoringRule())
                    .add(new LoansHistoryScoringRule())
                    .add(userHistoryScoringRule)
                    .build()
        );
    }
}
