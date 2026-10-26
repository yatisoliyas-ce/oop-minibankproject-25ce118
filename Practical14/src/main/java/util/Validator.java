package util;
import java.util.regex.Pattern;
public class Validator {public boolean isValidMobile(String s){return Pattern.matches("[6-9][0-9]{9}",s);}public boolean isValidEmail(String s){return Pattern.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}",s);}public boolean isValidPan(String s){return Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]",s);}public boolean isValidIfsc(String s){return Pattern.matches("[A-Z]{4}0[A-Z0-9]{6}",s);}}
