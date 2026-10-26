import java.util.Scanner;
import exception.BankException;
import model.Account;
import service.BankService;

public class MiniBank {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BankService bank = new BankService();
            boolean running = true;
            System.out.println("================================\nMiniBank - Ahmedabad Branch\n================================");
            while (running) {
                System.out.println("\n===== MiniBank Menu =====\n1. Open Account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Statement\n6. List Accounts\n7. End-of-day Report\n8. Batch Deposits\n9. Exit");
                System.out.print("Enter your choice: ");
                String input = sc.nextLine().trim();
                try {
                    switch (input) {
                        case "1" -> {
                            System.out.print("Owner name: ");
                            String name = sc.nextLine().trim();
                            System.out.print("Opening balance: ");
                            long amount = Long.parseLong(sc.nextLine().trim());
                            Account a = bank.openAccount(name, amount);
                            System.out.println("Account opened: " + a);
                        }
                        case "2" -> {
                            System.out.print("Account number: "); String id = sc.nextLine().trim();
                            System.out.print("Deposit amount: "); long amount = Long.parseLong(sc.nextLine().trim());
                            bank.deposit(id, amount); System.out.println("Deposit successful. " + bank.statement(id));
                        }
                        case "3" -> {
                            System.out.print("Account number: "); String id = sc.nextLine().trim();
                            System.out.print("Withdrawal amount: "); long amount = Long.parseLong(sc.nextLine().trim());
                            bank.withdraw(id, amount); System.out.println("Withdrawal successful. " + bank.statement(id));
                        }
                        case "4" -> {
                            System.out.print("From account: "); String from = sc.nextLine().trim();
                            System.out.print("To account: "); String to = sc.nextLine().trim();
                            System.out.print("Transfer amount: "); long amount = Long.parseLong(sc.nextLine().trim());
                            bank.transfer(from, to, amount); System.out.println("Transfer successful.");
                        }
                        case "5" -> { System.out.print("Account number: "); System.out.println(bank.statement(sc.nextLine().trim())); }
                        case "6" -> { for (Account a : bank.listAccounts()) System.out.println(a); }
                        case "7" -> System.out.println(bank.report());
                        case "8" -> {
                            System.out.print("Account number: "); String id = sc.nextLine().trim();
                            System.out.print("Amount per deposit: "); long amount = Long.parseLong(sc.nextLine().trim());
                            System.out.print("Number of deposits: "); int count = Integer.parseInt(sc.nextLine().trim());
                            bank.runBatchDeposit(id, amount, count);
                            System.out.println("Batch completed. " + bank.statement(id));
                        }
                        case "9" -> { bank.close(); running = false; System.out.println("Goodbye! Thank you for using MiniBank."); }
                        default -> System.out.println("Invalid choice. Enter 1 to 9.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid whole number.");
                } catch (BankException e) {
                    System.out.println("Banking error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Operation failed: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("MiniBank could not start: " + e.getMessage());
        }
    }
}
