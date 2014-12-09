package eu.solidcraft.starter.examples.example1

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.validation.constraints.NotNull

@Entity
class SomeEntity {
    @Id
    @SequenceGenerator(name = "SomeSequence", sequenceName = "SEQ_SOME_PK", initialValue=10000)
    @GeneratedValue(generator = "SomeSequence")
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private BigDecimal someAmount;

    @NotNull
    private Date someDate;

    private SomeEntity() {
    }

    SomeEntity(String username, BigDecimal someAmount, Date someDate) {
        this.username = username
        this.someAmount = someAmount
        this.someDate = someDate
    }

    public void setId(Long id) {
        this.id = id
    }

    Long getId() {
        return id
    }

    String getUsername() {
        return username
    }

    BigDecimal getSomeAmount() {
        return someAmount
    }

    Date getSomeDate() {
        return someDate
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof SomeEntity)) return false

        SomeEntity that = (SomeEntity) o

        if (id != that.id) return false
        if (someAmount != that.someAmount) return false
        if (someDate != that.someDate) return false
        if (username != that.username) return false

        return true
    }

    int hashCode() {
        int result
        result = (id != null ? id.hashCode() : 0)
        result = 31 * result + (username != null ? username.hashCode() : 0)
        result = 31 * result + (someAmount != null ? someAmount.hashCode() : 0)
        result = 31 * result + (someDate != null ? someDate.hashCode() : 0)
        return result
    }
}
