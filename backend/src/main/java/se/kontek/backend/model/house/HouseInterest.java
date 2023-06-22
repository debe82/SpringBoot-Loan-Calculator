package se.kontek.backend.model.house;

import se.kontek.backend.model.general.InterestRate;

public class HouseInterest extends InterestRate {

    public HouseInterest(String interestType) {
        super(interestType);
    }

    @Override
    public String getType() {
        return super.getType();
    }



    public double getInterests() {
        double interestPerType = 0.0;
        switch (getType()) {
            case "fixed":
                interestPerType = 3.5;
                break;
            case "variable":
                interestPerType = setVariableInterest();
                break;
        }

        return interestPerType;
    }


    public double setVariableInterest() {
        return 1.0;
    }
}
