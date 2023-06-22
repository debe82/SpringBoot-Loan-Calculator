package se.kontek.backend.model.house;

import se.kontek.backend.model.general.Loan;


public class HouseLoan extends Loan {

  final int PERCENT = 100;
  final int MONTHS = 12;

  public HouseLoan(int loanAmount, int paybackTime, HouseInterest houseInterest) {
    super(loanAmount, paybackTime, houseInterest.getInterests());
  }

  @Override
  public String getMonthlyFee(int paymentFrequency) {

    double monthInterest = getInterest() / PERCENT / ( (double) MONTHS / paymentFrequency);
    int numberOfPaymentsPerYear  = getPaybackTime() * (MONTHS / paymentFrequency);
    double dividend = monthInterest * Math.pow(1 + monthInterest, numberOfPaymentsPerYear);
    double divisor = Math.pow(1 + monthInterest, numberOfPaymentsPerYear) - 1;

    double monthlyFee = getLoanAmount() * ( dividend / divisor);

    return String.format("%.2f", monthlyFee);
  }
}
