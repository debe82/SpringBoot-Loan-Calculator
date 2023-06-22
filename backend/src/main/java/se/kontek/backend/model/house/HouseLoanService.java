package se.kontek.backend.model.house;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class HouseLoanService {
    Logger log = Logger.getLogger(HouseLoanService.class.getName());
    public String getMonthlyPayment(HouseLoanDto houseLoanDto) {

        if (houseLoanDto.loanAmount() < 0 || houseLoanDto.paybackTime() < 0 ||
                (houseLoanDto.interestType() == null || houseLoanDto.interestType().equals("")) ||
                houseLoanDto.frequency() < 0) {
            return null;
        }

        HouseInterest houseInterest = new HouseInterest(houseLoanDto.interestType());
        HouseLoan getHouseLoanForPlan = new HouseLoan(houseLoanDto.loanAmount(), houseLoanDto.paybackTime(), houseInterest);

        return getHouseLoanForPlan.getMonthlyFee(houseLoanDto.frequency());
    }
}
