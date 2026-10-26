import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exception.*;import model.Account;
public class BankServiceTest {
    @Test void depositIncreasesBalance() throws Exception {Account a=new Account("AC0001","Test",100);a.deposit(50);assertEquals(150,a.getBalance());}
    @Test void withdrawalOverBalanceThrows() {Account a=new Account("AC0002","Test",100);assertThrows(InsufficientFundsException.class,()->a.withdraw(500));}
    @Test void concurrentDepositsAreSynchronized() throws Exception {Account a=new Account("AC0003","Test",0);Thread[] threads=new Thread[10];for(int i=0;i<threads.length;i++){threads[i]=new Thread(()->{for(int j=0;j<1000;j++)try{a.deposit(1);}catch(InvalidAmountException e){throw new RuntimeException(e);}});threads[i].start();}for(Thread t:threads)t.join();assertEquals(10000,a.getBalance());}
}
