package se.kontek.backend.model.general;

public abstract class InterestRate {

    String interestType;
    public InterestRate(String interest) {
        this.interestType = interest;
    }
    public String getType() {
        return interestType;
    }



}
