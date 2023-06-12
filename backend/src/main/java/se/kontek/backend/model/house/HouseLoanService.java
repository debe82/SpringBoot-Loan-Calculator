package se.kontek.backend.model.house;

import org.springframework.stereotype.Service;

@Service
public class HouseLoanService {

    public String getPlan(HouseLoanDto houseLoanDto) {

        if (houseLoanDto.loanAmount() < 0 || houseLoanDto.paybackTime() < 0 ||
                (houseLoanDto.interestType() == null || houseLoanDto.interestType().equals("")) ||
                houseLoanDto.frequency() < 0) {
            return null;
        }


        HouseLoan getHouseLoanForPlan = new HouseLoan(houseLoanDto.loanAmount(), houseLoanDto.paybackTime(), houseLoanDto.interest(), houseLoanDto.interestType());
        return getHouseLoanForPlan.getPlan(houseLoanDto.frequency());
    }
}
