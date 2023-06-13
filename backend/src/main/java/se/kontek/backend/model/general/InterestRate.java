package se.kontek.backend.model.general;

public abstract class InterestRate {

    String interestType;

    public String getType() {
        return interestType;
    }

    public InterestRate(String interest) {
        this.interestType = interest;
    }

}
