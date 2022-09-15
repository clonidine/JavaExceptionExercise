import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Number: ");
            int accountNumber = sc.nextInt();

            System.out.print("Holder: ");
            sc.nextLine();
            String accountHolder = sc.nextLine();

            System.out.print("Initial balance: ");
            double accountInitialBalance = sc.nextDouble();

            System.out.print("Withdraw limit: ");
            double accountWithDrawLimit = sc.nextDouble();

            Account account = new Account(accountNumber, accountHolder, accountInitialBalance, accountWithDrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            double withDrawAmount = sc.nextDouble();
            account.withDraw(withDrawAmount);

            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
        }

        catch (DomainException exception) {
            System.out.println("Withdraw error: " + exception.getMessage());
        }
    }
}
