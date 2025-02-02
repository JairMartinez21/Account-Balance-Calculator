public class CheckingAccount extends Account {
  private double monthlyFee;

  public CheckingAccount(double initialBalance, double monthlyFee) {
      super(initialBalance);
      this.monthlyFee = monthlyFee;
  }

  public void subtractMonthlyFee() {
      balance -= monthlyFee;
  }

  public double getMonthlyFee() {
      return monthlyFee;
  }
}
