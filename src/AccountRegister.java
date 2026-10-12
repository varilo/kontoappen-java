import java.util.ArrayList; // Används för att spara flera konton i en lista.

// Den här klassen sköter listan med bankkonton.
public class AccountRegister {
    // Listan är private så att den bara ändras genom registrets metoder.
    private ArrayList<Account> accounts = new ArrayList<>();

    // Skapar ett nytt konto och sparar det i listan.
    public void createAccount(String owner, double balance) {
        Account account = new Account(owner, balance); // Skapar kontoobjektet.
        accounts.add(account); // Lägger till kontot i listan.
    }

    // Visar alla konton som finns i listan.
    public void showAccounts() {
        // Om listan är tom visas ett meddelande i stället.
        if (accounts.isEmpty()) {
            System.out.println("Det finns inga konton.");
            return; // Avslutar metoden här.
        }

        // Går igenom ett konto i taget.
        for (Account account : accounts) {
            // Hämtar ägare och saldo genom kontots metoder.
            System.out.println(
                    "Ägare: " + account.getOwner()
                            + " | Saldo: " + account.getBalance() + " kr"
            );
        }
    }

    // Söker efter ett konto med ägarens namn.
    public Account findAccount(String owner) {
        // Går igenom kontona ett i taget.
        for (Account account : accounts) {
            // Jämför namnen utan att bry sig om stora och små bokstäver.
            if (account.getOwner().equalsIgnoreCase(owner)) {
                return account; // Skickar tillbaka kontot som hittades.
            }
        }

        return null; // Inget konto med det namnet hittades.
    }
}
