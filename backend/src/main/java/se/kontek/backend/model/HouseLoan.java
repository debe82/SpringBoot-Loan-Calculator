package se.kontek.backend.model;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;


public class HouseLoan extends Loan{

  public HouseLoan(String type, int loanAmount, int paybackTime, double interest) {
    super(type, loanAmount, paybackTime, interest);
  }

  @Override
  public String getPlan() {
    /*
    Monthly payment is
    M = loanAmount * ( monthlyInterest * (1 + monthlyInterest) ^ paybackTime / ((1 + monthlyInterest) ^ paybackTime) -1 )
     */

    double monthlyInterest = interest / 100 / 12;
    int numberOfPayments  = paybackTime * 12;
    double upperPart = monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments);
    double lowerPart = Math.pow(1 + monthlyInterest, numberOfPayments) -1;
    double monthlyPayment = loanAmount * ( upperPart / lowerPart);


    String monthlyPlan =
            "The plan is: \n" +
            "Total loan amount: " + loanAmount + "\n" +
            "Payback time (in years): " + paybackTime + "\n" +
            "Interest rate: " + interest + "\n" +
            "Monthly amount to pay: " + NumberFormat.getCurrencyInstance().format(monthlyPayment);

    return monthlyPlan;
  }
}
