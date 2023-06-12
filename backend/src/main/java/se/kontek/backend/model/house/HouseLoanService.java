package se.kontek.backend.model.house;

import org.springframework.stereotype.Service;

@Service
public class HouseLoanService {

    public String getPlan(HouseLoanDto houseLoanDto) {

        if (houseLoanDto.loanAmount() < 0 || houseLoanDto.paybackTime() < 0 || houseLoanDto.interest() < 0 || houseLoanDto.frequency() < 0) {
            return null;
        }


        HouseLoan getHouseLoanForPlan = new HouseLoan(houseLoanDto.loanAmount(), houseLoanDto.paybackTime(), houseLoanDto.interest());
        return getHouseLoanForPlan.getPlan(houseLoanDto.frequency());
    }
}
