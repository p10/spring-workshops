package eu.solidcraft.starter.examples.loan.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public final class LoanResponse {

    private final Long id;

    private final String username;

    private final BigDecimal someAmount;

    private final Date someDate;

    public LoanResponse(Long id, String username, BigDecimal someAmount, Date someDate) {
        this.id = id;
        this.username = username;
        this.someAmount = someAmount;
        this.someDate = someDate;
    }

    public Long getId() {
        return id;
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
        return Objects.hash(id, username, someAmount, someDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final LoanResponse other = (LoanResponse) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username) && Objects.equals(this.someAmount, other.someAmount) && Objects.equals(this.someDate, other.someDate);
    }
}
