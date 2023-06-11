package se.kontek.backend.model;

public abstract class Loan {
  public String type;
  public double loanAmount;
  public int paybackTime;
  public double interest;

  protected Loan(String type, int loanAmount, int paybackTime, double interest) {
    this.type = type;
    this.loanAmount = loanAmount;
    this.paybackTime = paybackTime;
    this.interest = interest;
  }

  public abstract String getPlan();
}
