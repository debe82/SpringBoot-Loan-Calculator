package se.kontek.backend.model.general;

public abstract class Loan {
  public double loanAmount;
  public int paybackTime;
  public double interest;

  protected Loan(int loanAmount, int paybackTime, double interest) {
    this.loanAmount = loanAmount;
    this.paybackTime = paybackTime;
    this.interest = interest;
  }

  public double getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  public int getPaybackTime() {
    return paybackTime;
  }

  public void setPaybackTime(int paybackTime) {
    this.paybackTime = paybackTime;
  }

  public double getInterest() {
    return interest;
  }

  public void setInterest(double interest) {
    this.interest = interest;
  }

  public abstract String getPlan(int paymentFrequency);

}
