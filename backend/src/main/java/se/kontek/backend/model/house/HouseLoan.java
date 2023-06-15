package se.kontek.backend.model.house;

import se.kontek.backend.model.general.Loan;


public class HouseLoan extends Loan {

  public HouseLoan(int loanAmount, int paybackTime, double interest) {
    super(loanAmount, paybackTime, interest);
  }
  public HouseLoan(int loanAmount, int paybackTime, HouseInterest houseInterest) {
    super(loanAmount, paybackTime, 0.0);
    setInterest(houseInterest.getInterests());
  }

  @Override
  public String getPlan(int paymentFrequency) {
    /*
    Monthly payment is (https://www.wikihow.com/Calculate-Mortgage-Payments)
    M = loanAmount * ( monthlyInterest * (1 + monthlyInterest) ^ paybackTime / ((1 + monthlyInterest) ^ paybackTime) -1 )
     */
    System.out.println("loanAmount " +loanAmount);
    System.out.println("paybackTime " +paybackTime);
    System.out.println("interest " +interest);
    System.out.println("getInterest() " +getInterest());


    double monthInterest = getInterest() / 100 / (12 / paymentFrequency);
    System.out.println("monthInterest " +monthInterest);
    int numberOfPayments  = getPaybackTime() * (12 / paymentFrequency);
    System.out.println("numberOfPayments " +numberOfPayments);
    double dividend = monthInterest * Math.pow(1 + monthInterest, numberOfPayments);
    System.out.println("dividend " +dividend);
    double divisor = Math.pow(1 + monthInterest, numberOfPayments) -1;
    System.out.println("divisor " +divisor);

//        double compound = getLoanAmount() * (Math.pow(1+(getInterest() / 100 / 12), getPaybackTime() * 12));
//        System.out.println("compound: " + compound); //NumberFormat.getCurrencyInstance().format(compound));

    double monthlyFee = getLoanAmount() * ( dividend / divisor);

    return String.format("%.2f", monthlyFee);  //NumberFormat.getCurrencyInstance().format(monthlyFee);
  }
}
