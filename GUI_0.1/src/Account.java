public class Account {
    double balance;
    static double interestRate;

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public void deposit (double value) {
        if (value > 0) balance += value;
        else System.out.println("Wpłacana kwota nie może być mniejsza od zera!");
    }

    public void withdraw (double value) {
        balance -= value;
    }

    public void transfer (Account recipient, double value) {
        balance -= value;
        recipient.balance += value;
    }

    public void addInterest () {
        balance += (balance * (interestRate/100));
    }
}
