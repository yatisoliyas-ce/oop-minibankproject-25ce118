import java.lang.annotation.*;import java.lang.reflect.*;import java.util.*;
public class MiniBank {
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface Id {}
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface Positive {String message() default "must be > 0";}
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface MaxLength {int value();}
    static class Account {@Id private final String accountNumber;@MaxLength(30) private final String ownerName;@Positive private long balance;Account(String n,String o,long b){accountNumber=n;ownerName=o;balance=b;}}
    static class AnnotationValidator {static String[] validate(Object obj){List<String> errors=new ArrayList<>();for(Field f:obj.getClass().getDeclaredFields()){try{f.setAccessible(true);Object v=f.get(obj);if(f.isAnnotationPresent(Positive.class)&&v instanceof Number n&&n.longValue()<=0)errors.add(f.getName()+": "+f.getAnnotation(Positive.class).message());if(f.isAnnotationPresent(MaxLength.class)&&v instanceof String s&&s.length()>f.getAnnotation(MaxLength.class).value())errors.add(f.getName()+": maximum length is "+f.getAnnotation(MaxLength.class).value());}catch(IllegalAccessException e){errors.add(f.getName()+": cannot read field");}}return errors.toArray(String[]::new);}}
    public static void main(String[] args){Account a=new Account("AC0001","Aarav",-100);System.out.println(Arrays.toString(AnnotationValidator.validate(a)));}
}
