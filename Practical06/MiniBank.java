import java.util.*;
public class MiniBank {
    interface Transactable {boolean deposit(long amount);boolean withdraw(long amount);}
    interface InterestBearing {double interestRate();default double yearlyInterest(long balance){return balance*interestRate()/100.0;}}
    @FunctionalInterface interface WithdrawRule {boolean allow(long balance,long amount);}
    interface Premium {}
    static class Account implements Transactable,InterestBearing {private final String number;private long balance;Account(String n,long b){number=n;balance=b;}public boolean deposit(long a){if(a<=0)return false;balance+=a;return true;}public boolean withdraw(long a){return withdraw(a,(b,x)->x>0&&x<=b);}public boolean withdraw(long a,WithdrawRule rule){if(!rule.allow(balance,a))return false;balance-=a;return true;}public double interestRate(){return 4.0;}public String toString(){return number+" balance="+balance;}}
    public static void main(String[] args){Account a=new Account("AC0001",5000);a.deposit(500);System.out.println(a);System.out.println("Yearly interest: "+a.yearlyInterest(a.balance));WithdrawRule rule=new WithdrawRule(){public boolean allow(long b,long x){return x>0&&x<=b;}};System.out.println("Withdraw allowed: "+rule.allow(5500,1000));System.out.println("Lambda allowed: "+((WithdrawRule)(b,x)->x>0&&x<=b).allow(5500,1000));}
}
