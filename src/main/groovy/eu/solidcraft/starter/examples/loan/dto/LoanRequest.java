package eu.solidcraft.starter.examples.loan.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public final class LoanRequest {

    private final String username;

    private final BigDecimal someAmount;

    private final Date someDate;

    public LoanRequest( String username, BigDecimal someAmount, Date someDate) {
        this.username = username;
        this.someAmount = someAmount;
        this.someDate = someDate;
    }

    public String getUsername() {
        return username;
    }

    public BigDecimal getSomeAmount() {
        return someAmount;
    }

    public Date getSomeDate() {
        return someDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, someAmount, someDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final LoanRequest other = (LoanRequest) obj;
        return Objects.equals(this.username, other.username) && Objects.equals(this.someAmount, other.someAmount) && Objects.equals(this.someDate, other.someDate);
    }
}
