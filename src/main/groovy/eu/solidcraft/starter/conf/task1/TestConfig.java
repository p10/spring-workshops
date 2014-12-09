package eu.solidcraft.starter.conf.task1;

import com.google.common.collect.ImmutableList;
import eu.solidcraft.starter.examples.task1.ScoringRuleProvider;
import eu.solidcraft.starter.examples.task1.rule.LoansHistoryScoringRule;
import eu.solidcraft.starter.examples.task1.rule.ScoringRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    public ScoringRuleProvider scoringRuleProvider() {
        return new ScoringRuleProvider(
                ImmutableList.<ScoringRule>builder()
                        .add(new LoansHistoryScoringRule())
                        .build()
        );
    }
}
