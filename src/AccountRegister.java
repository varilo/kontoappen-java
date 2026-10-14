import java.util.ArrayList;

public class AccountRegister {
    // Registret sparar kontona i en lista.
    private ArrayList<Account> accounts = new ArrayList<>();

    // Skapar ett konto och lägger till det i registret.
    public void createAccount(String owner, double balance) {
        Account account = new Account(owner, balance);
        accounts.add(account);
    }

    public void showAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("Det finns inga konton.");
            return;
        }

        for (Account account : accounts) {
            System.out.println(
                    "Ägare: " + account.getOwner()
                            + " | Saldo: " + account.getBalance() + " kr"
            );
        }
    }

    // Söker efter kontot via ägarens namn.
    public Account findAccount(String owner) {
        for (Account account : accounts) {
            if (account.getOwner().equalsIgnoreCase(owner)) {
                return account;
            }
        }

        return null;
    }
}
