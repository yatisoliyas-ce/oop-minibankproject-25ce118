public class MiniBank {
    static class BankException extends Exception {BankException(String m){super(m);}}
    static class InvalidAmountException extends BankException {InvalidAmountException(){super("Amount must be positive");}}
    static class InsufficientFundsException extends BankException {private final long shortfall;InsufficientFundsException(long s){super("Insufficient funds; short by "+s);shortfall=s;}long getShortfall(){return shortfall;}}
    static class AccountNotFoundException extends BankException {AccountNotFoundException(String n){super("Account not found: "+n);}}
    static class Account implements AutoCloseable {final String number;long balance;Account(String n,long b){number=n;balance=b;}void deposit(long a)throws InvalidAmountException{if(a<=0)throw new InvalidAmountException();balance+=a;}void withdraw(long a)throws BankException{if(a<=0)throw new InvalidAmountException();if(a>balance)throw new InsufficientFundsException(a-balance);balance-=a;}void transfer(Account to,long a)throws BankException{try{withdraw(a);to.deposit(a);}catch(BankException e){throw e;}finally{System.out.println("Transfer attempt finished.");}}public void close(){System.out.println("Account resource closed.");}}
    public static void main(String[] args){try(Account a=new Account("AC0001",1000)){a.withdraw(5000);}catch(InsufficientFundsException e){System.out.println("Withdrawal failed: short by "+e.getShortfall());}catch(BankException e){System.out.println(e.getMessage());}finally{System.out.println("Operation complete.");}}
}
