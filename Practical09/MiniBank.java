public class MiniBank {
    static class Account {private long balance; synchronized void deposit(long amount){balance+=amount;} long getBalance(){return balance;}}
    static class AccountWorker implements Runnable {private final Account account;private final int times;private final long amount;AccountWorker(Account a,int t,long x){account=a;times=t;amount=x;}public void run(){for(int i=0;i<times;i++)account.deposit(amount);}}
    public static void main(String[] args)throws InterruptedException{Account a=new Account();Thread[] ts=new Thread[10];for(int i=0;i<ts.length;i++){ts[i]=new Thread(new AccountWorker(a,1000,1),"Deposit-"+(i+1));ts[i].start();}for(Thread t:ts)t.join();System.out.println("Final balance: "+a.getBalance());System.out.println("Expected balance: 10000");}
}
