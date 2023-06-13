package se.kontek.backend.model.general;

public class HouseInterest extends InterestRate {

    public HouseInterest(String interestType) {
        super(interestType);
    }

    double interest = 0.0;

    @Override
    public String getType() {
        return super.getType();
    }

    public double getInterests() {

        switch (getType()) {
            case "fixed":
                interest = 3.5;
                break;
            case "variable":
                interest = setVariableInterest();
                break;
        }

        return interest;
    }


    public double setVariableInterest() {
        return 1.0;
    }
}
