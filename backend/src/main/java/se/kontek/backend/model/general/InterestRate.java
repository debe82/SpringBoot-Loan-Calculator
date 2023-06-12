package se.kontek.backend.model.general;

public class InterestRate {
    public enum HouseInterest {
        FIXED(3.5),
        VARIABLE(0.0),
        VARIABLE_WITH_CAP(0.0);

        private double interestRate;

        HouseInterest(double interestRate) {
            this.interestRate = interestRate;
        }

        public double getInterestRate() {
            return interestRate;
        }
    }

    public enum CarInterest {


    }
}
