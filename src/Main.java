import java.util.Scanner; // Läser det användaren skriver i konsolen.

// Här startar programmet och här finns menyn.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Tar emot text från tangentbordet.
        AccountRegister register = new AccountRegister(); // Skapar ett register för kontona.

        boolean running = true; // Bestämmer om menyn ska fortsätta visas.

        // Loopen fortsätter så länge running är true.
        while (running) {
            // Skriver ut menyn.
            System.out.println();
            System.out.println("--- KONTOAPPEN ---");
            System.out.println("1. Skapa konto");
            System.out.println("2. Lista konton");
            System.out.println("3. Sätt in pengar");
            System.out.println("4. Ta ut pengar");
            System.out.println("5. Avsluta");
            System.out.print("Ditt val: ");

            String choice = scanner.nextLine(); // Läser menyvalet som text.

            if (choice.equals("1")) { // Skapa konto.
                System.out.print("Ägarens namn: ");
                String owner = scanner.nextLine(); // Läser namnet.

                System.out.print("Startsaldo: ");
                double balance = readNumber(scanner); // Läser ett tal.

                register.createAccount(owner, balance); // Registret skapar och sparar kontot.
                System.out.println("Kontot skapades.");

            } else if (choice.equals("2")) { // Lista konton.
                register.showAccounts(); // Ber registret visa alla konton.

            } else if (choice.equals("3")) { // Sätt in pengar.
                System.out.print("Ägarens namn: ");
                String owner = scanner.nextLine();

                Account account = register.findAccount(owner); // Söker efter rätt konto.

                if (account == null) { // null betyder att inget konto hittades.
                    System.out.println("Kontot hittades inte.");
                } else {
                    System.out.print("Belopp att sätta in: ");
                    double amount = readNumber(scanner);

                    account.deposit(amount); // Försöker sätta in beloppet.
                    System.out.println("Nytt saldo: " + account.getBalance() + " kr");
                }

            } else if (choice.equals("4")) { // Ta ut pengar.
                System.out.print("Ägarens namn: ");
                String owner = scanner.nextLine();

                Account account = register.findAccount(owner); // Söker efter rätt konto.

                if (account == null) {
                    System.out.println("Kontot hittades inte.");
                } else {
                    System.out.print("Belopp att ta ut: ");
                    double amount = readNumber(scanner);

                    // withdraw svarar true om uttaget lyckades.
                    if (account.withdraw(amount)) {
                        System.out.println("Nytt saldo: " + account.getBalance() + " kr");
                    }
                }

            } else if (choice.equals("5")) { // Avsluta programmet.
                running = false; // Då avslutas while-loopen.
                System.out.println("Programmet avslutas.");

            } else { // Om användaren skriver något annat än 1 till 5.
                System.out.println("Ogiltigt val. Försök igen.");
            }
        }

        scanner.close(); // Stänger inläsningen när programmet avslutas.
    }

    // Läser ett tal och låter användaren försöka igen om texten inte är ett tal.
    public static double readNumber(Scanner scanner) {
        while (true) { // Fortsätter tills ett giltigt tal har skrivits.
            String input = scanner.nextLine();

            try {
                return Double.parseDouble(input); // Försöker göra text till ett decimaltal.
            } catch (NumberFormatException e) { // Körs om texten inte går att göra till ett tal.
                System.out.print("Skriv ett giltigt nummer: ");
            }
        }
    }
}
