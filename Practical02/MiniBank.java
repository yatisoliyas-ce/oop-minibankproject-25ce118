public class MiniBank {
    static class Customer {
        private static long customerCounter = 100;
        private final String customerId;
        private String name, email, mobile;
        Customer(String name, String email, String mobile) { this.customerId = generateCustomerId(); this.name=name; this.email=email; this.mobile=mobile; }
        private static String generateCustomerId() { return "CUST" + (++customerCounter); }
        public String getCustomerId(){return customerId;} public String getName(){return name;} public String getEmail(){return email;} public String getMobile(){return mobile;}
    }
    static class Account {
        private static int accountCounter=0;
        private final String accountNumber;
        private final String ownerName;
        private long balance;
        private boolean active=true;
        Account(String ownerName,long openingBalance){this.accountNumber=String.format("AC%04d",++accountCounter);this.ownerName=ownerName;this.balance=Math.max(0,openingBalance);}
        Account(String ownerName){this(ownerName,0);}
        public String getAccountNumber(){return accountNumber;} public String getOwnerName(){return ownerName;} public long getBalance(){return balance;} public boolean isActive(){return active;}
        public void deposit(long amount){if(amount>0)balance+=amount;else System.out.println("Amount must be positive.");}
        public boolean withdraw(long amount){if(amount<=0){System.out.println("Amount must be positive.");return false;}if(amount<=balance){balance-=amount;return true;}return false;}
        public String toString(){return accountNumber+" | "+ownerName+" | Balance: "+balance;}
    }
    public static void main(String[] args){
        Account[] accounts={new Account("Aarav",5000),new Account("Diya"),new Account("Kabir",1000)};
        accounts[0].deposit(2000); accounts[0].withdraw(3000); boolean success=accounts[0].withdraw(10000);
        System.out.println("Withdraw 10000 successful: "+success);
        for(Account a:accounts)System.out.println(a);
    }
}
