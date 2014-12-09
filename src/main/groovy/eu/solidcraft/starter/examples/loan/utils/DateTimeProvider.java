package eu.solidcraft.starter.examples.loan.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateTimeProvider {

    public Date now() {
        return new Date();
    }
}
