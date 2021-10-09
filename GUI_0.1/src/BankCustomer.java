public class BankCustomer {
    Person customer;
    Account account = new Account();

    @Override
    public String toString() {
        return "Klient: " +
                customer.name + " stan konta " +
                account.balance
                ;
    }

    public BankCustomer(Person customer) {
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }
}
