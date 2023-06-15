package se.kontek.backend.model.house;

import org.springframework.stereotype.Service;
import se.kontek.backend.model.general.HouseInterest;

@Service
public class HouseLoanService {

    public String getPlan(HouseLoanDto houseLoanDto) {

        if (houseLoanDto.loanAmount() < 0 || houseLoanDto.paybackTime() < 0 ||
                (houseLoanDto.interestType() == null || houseLoanDto.interestType().equals("")) ||
                houseLoanDto.frequency() < 0) {
            return null;
        }


        HouseInterest houseInterest = new HouseInterest(houseLoanDto.interestType());
        HouseLoan getHouseLoanForPlan = new HouseLoan(houseLoanDto.loanAmount(), houseLoanDto.paybackTime(), 0.0, houseInterest);
        return getHouseLoanForPlan.getPlan(houseLoanDto.frequency());
    }
}
