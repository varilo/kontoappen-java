import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountRegister register = new AccountRegister();

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("--- KONTOAPPEN ---");
            System.out.println("1. Skapa konto");
            System.out.println("2. Lista konton");
            System.out.println("3. Sätt in pengar");
            System.out.println("4. Ta ut pengar");
            System.out.println("5. Avsluta");
            System.out.print("Ditt val: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Ägarens namn: ");
                String owner = scanner.nextLine();

                System.out.print("Startsaldo: ");
                double balance = readNumber(scanner);

                register.createAccount(owner, balance);
                System.out.println("Kontot skapades.");

            } else if (choice.equals("2")) {
                register.showAccounts();

            } else if (choice.equals("3")) {
                System.out.print("Ägarens namn: ");
                String owner = scanner.nextLine();

                Account account = register.findAccount(owner);

                if (account == null) {
                    System.out.println("Kontot hittades inte.");
                } else {
                    System.out.print("Belopp att sätta in: ");
                    double amount = readNumber(scanner);

                    account.deposit(amount);
                    System.out.println("Nytt saldo: " + account.getBalance() + " kr");
                }

            } else if (choice.equals("4")) {
                System.out.print("Ägarens namn: ");
                String owner = scanner.nextLine();

                Account account = register.findAccount(owner);

                if (account == null) {
                    System.out.println("Kontot hittades inte.");
                } else {
                    System.out.print("Belopp att ta ut: ");
                    double amount = readNumber(scanner);

                    if (account.withdraw(amount)) {
                        System.out.println("Nytt saldo: " + account.getBalance() + " kr");
                    }
                }

            } else if (choice.equals("5")) {
                running = false;
                System.out.println("Programmet avslutas.");

            } else {
                System.out.println("Ogiltigt val. Försök igen.");
            }
        }

        scanner.close();
    }

    public static double readNumber(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Skriv ett giltigt nummer: ");
            }
        }
    }
}