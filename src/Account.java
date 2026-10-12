// Den här klassen beskriver ett bankkonto.
public class Account {
    // private betyder att andra klasser inte får ändra dessa direkt.
    private String owner; // Namnet på personen som äger kontot.
    private double balance; // Pengarna som finns på kontot.

    // Konstruktorn används när ett nytt konto skapas.
    public Account(String owner, double balance) {
        this.owner = owner; // Sparar namnet i kontot.
        this.balance = balance; // Sparar startsaldot.
    }

    // Skickar tillbaka namnet på kontots ägare.
    public String getOwner() {
        return owner;
    }

    // Skickar tillbaka det aktuella saldot.
    public double getBalance() {
        return balance;
    }

    // Sätter in pengar. void betyder att metoden inte skickar tillbaka ett svar.
    public void deposit(double amount) {
        // Vi lägger bara till belopp som är större än noll.
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    // Försöker ta ut pengar och svarar true eller false.
    public boolean withdraw(double amount) {
        // Båda villkoren måste stämma: positivt belopp och tillräckligt saldo.
        if (amount > 0 && amount <= balance) {
            balance = balance - amount; // Drar pengarna från saldot.
            return true; // Uttaget lyckades.
        }

        // Om villkoret inte stämde ändras inte saldot.
        System.out.println("Det finns inte tillräckligt med pengar på kontot.");
        return false; // Uttaget gick inte att göra.
    }
}
