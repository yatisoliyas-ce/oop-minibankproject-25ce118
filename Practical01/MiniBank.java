import java.util.Scanner;
public class MiniBank {
    record BankInfo(String name, String branch) {}
    enum MenuOption { OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT }
    public static void main(String[] args) {
        BankInfo bank = new BankInfo("MiniBank", "Ahmedabad");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("================================");
            System.out.println(bank.name() + " - " + bank.branch() + " Branch");
            System.out.println("================================");
            boolean running = true;
            while (running) {
                System.out.println("\n===== MiniBank Menu =====");
                System.out.println("1. Open Account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Exit");
                System.out.print("Enter your choice: ");
                String input = sc.nextLine().trim();
                try {
                    int choice = Integer.parseInt(input);
                    MenuOption option = switch (choice) {
                        case 1 -> MenuOption.OPEN_ACCOUNT;
                        case 2 -> MenuOption.DEPOSIT;
                        case 3 -> MenuOption.WITHDRAW;
                        case 4 -> MenuOption.TRANSFER;
                        case 5 -> MenuOption.EXIT;
                        default -> null;
                    };
                    if (option == null) { System.out.println("Invalid menu number. Please enter 1 to 5."); continue; }
                    String message = switch (option) {
                        case OPEN_ACCOUNT -> "Open Account — to be implemented in a later lab";
                        case DEPOSIT -> "Deposit — to be implemented in a later lab";
                        case WITHDRAW -> "Withdraw — to be implemented in a later lab";
                        case TRANSFER -> "Transfer — to be implemented in a later lab";
                        case EXIT -> "Goodbye! Thank you for using MiniBank.";
                    };
                    System.out.println(message);
                    if (option == MenuOption.EXIT) running = false;
                } catch (NumberFormatException e) { System.out.println("Invalid input. Please enter a number from 1 to 5."); }
            }
        }
    }
}
