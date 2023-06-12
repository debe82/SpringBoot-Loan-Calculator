package se.kontek.backend.model.house;

import se.kontek.backend.model.general.Loan;

import java.text.NumberFormat;


public class HouseLoan extends Loan {

  public HouseLoan(int loanAmount, int paybackTime, double interest) {
    super(loanAmount, paybackTime, interest);
  }

  @Override
  public String getPlan(int paymentFrequency) {
    /*
    Monthly payment is (https://www.wikihow.com/Calculate-Mortgage-Payments)
    M = loanAmount * ( monthlyInterest * (1 + monthlyInterest) ^ paybackTime / ((1 + monthlyInterest) ^ paybackTime) -1 )
     */

    double monthInterest = getInterest() / 100 / (12 / paymentFrequency);
    int numberOfPayments  = getPaybackTime() * (12 / paymentFrequency);
    double dividend = monthInterest * Math.pow(1 + monthInterest, numberOfPayments);
    double divisor = Math.pow(1 + monthInterest, numberOfPayments) -1;

//        double compound = getLoanAmount() * (Math.pow(1+(getInterest() / 100 / 12), getPaybackTime() * 12));
//        System.out.println("compound: " + compound); //NumberFormat.getCurrencyInstance().format(compound));

    double monthlyFee = getLoanAmount() * ( dividend / divisor);

    return NumberFormat.getCurrencyInstance().format(monthlyFee);
  }
}
