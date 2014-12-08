package eu.solidcraft.starter.examples.task1.detector;

import org.springframework.stereotype.Component;

@Component
public class EnglishFraudDetector implements FraudDetector {
    @Override
    public Boolean isFraud() {
        return true;
    }
}
