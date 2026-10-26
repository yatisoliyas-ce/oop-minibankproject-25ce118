public class MiniBank {
    static class Customer implements Cloneable {
        private final String customerId; private String name; private Address address;
        Customer(String id,String name,Address address){this.customerId=id;this.name=name;this.address=address;}
        public Address getAddress(){return address;}
        @Override public Customer clone(){try{return (Customer)super.clone();}catch(CloneNotSupportedException e){throw new AssertionError(e);}}
        static class Address {private final String line,city,pincode; Address(String line,String city,String pincode){this.line=line;this.city=city;this.pincode=pincode;} public String getLine(){return line;}public String getCity(){return city;}public String getPincode(){return pincode;} public String toString(){return line+", "+city+" "+pincode;}}
    }
    static class Account {
        private final String accountNumber; private final String ownerName; private long balance;
        Account(String no,String owner,long balance){accountNumber=no;ownerName=owner;this.balance=balance;}
        public String getAccountNumber(){return accountNumber;} public long getBalance(){return balance;}
        @Override public String toString(){return "Account{"+accountNumber+", owner='"+ownerName+"', balance="+balance+"}";}
        @Override public boolean equals(Object o){return o instanceof Account a && accountNumber.equals(a.accountNumber);}
        @Override public int hashCode(){return accountNumber.hashCode();}
    }
    public static void main(String[] args){Account a=new Account("AC0001","Aarav",5000),b=new Account("AC0001","Other",900);System.out.println(a);System.out.println("Accounts equal: "+a.equals(b));System.out.println("instanceof Account: "+(a instanceof Account));Customer c=new Customer("CUST101","Diya",new Customer.Address("12 Main Road","Ahmedabad","380001"));System.out.println(c.getAddress());System.out.println("Clone name: "+c.clone().name);}
}
