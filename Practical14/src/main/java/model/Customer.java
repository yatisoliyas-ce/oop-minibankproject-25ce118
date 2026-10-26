package model;
import java.io.Serializable;import model.annotation.Id;
public class Customer implements Serializable {private static final long serialVersionUID=1L;@Id private final String customerId;private final String name,email,mobile;public Customer(String id,String name,String email,String mobile){customerId=id;this.name=name;this.email=email;this.mobile=mobile;}public String getCustomerId(){return customerId;}public String getName(){return name;}public String toString(){return customerId+" "+name+" "+email+" "+mobile;}}
