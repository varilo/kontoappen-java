public class Account {
    // Inkapsling: ägare och saldo är privata och nås via metoder.
    private String owner;
    private double balance;

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    // Insättning fungerar bara med ett positivt belopp.
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    // Uttag kräver ett positivt belopp och tillräckligt saldo.
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            return true;
        }

        System.out.println("Det finns inte tillräckligt med pengar på kontot.");
        return false;
    }
}
