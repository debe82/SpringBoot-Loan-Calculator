package se.kontek.backend.model.house;

import se.kontek.backend.model.general.Loan;


public class HouseLoan extends Loan {

  final int PERCENT = 100;
  final int MONTHS = 12;

  public HouseLoan(int loanAmount, int paybackTime, HouseInterest houseInterest) {
    super(loanAmount, paybackTime, 0.0, houseInterest);
    setInterest(houseInterest.getInterests());
  }

  @Override
  public String getPlan(int paymentFrequency) {
    /*
    Monthly payment is (https://www.wikihow.com/Calculate-Mortgage-Payments)
    M = loanAmount * ( monthlyInterest * (1 + monthlyInterest) ^ paybackTime / ((1 + monthlyInterest) ^ paybackTime) -1 )
     */

    double monthInterest = getInterest() / PERCENT / ( (double) MONTHS / paymentFrequency);
    int numberOfPaymentsPerYear  = getPaybackTime() * (MONTHS / paymentFrequency);
    double dividend = monthInterest * Math.pow(1 + monthInterest, numberOfPaymentsPerYear);
    double divisor = Math.pow(1 + monthInterest, numberOfPaymentsPerYear) - 1;

//  double compound = getLoanAmount() * (Math.pow(1+(getInterest() / 100 / 12), getPaybackTime() * 12));

    double monthlyFee = getLoanAmount() * ( dividend / divisor);

    return String.format("%.2f", monthlyFee);  //NumberFormat.getCurrencyInstance().format(monthlyFee);
  }
}
