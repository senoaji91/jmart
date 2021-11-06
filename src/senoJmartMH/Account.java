package senoJmartMH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    // instance variables - replace the example below with your own
    public static final String REGEX_EMAIL = "^(?!\\.)(?!.*?\\.\\.)[a-zA-Z0-9&_*~.]+@(?!-)[a-zA-Z0-9-]+\\.(?!.*\\.$)[a-zA-Z0-9.]+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d](\\S){8,}$";
    public String name;
    public String email;
    public String password;
    public double balance;


    /**
     * Constructor for objects of class Account
     */
    public Account( String name, String email, String password, double balance)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public String toString()
    {
        return "name: " + this.name + "\n"
                + "email: " + this.email + "\n"
                + "password: " + this.password;
    }

    public boolean validate()
    {
        Pattern p1 = Pattern.compile(REGEX_EMAIL);
        Matcher m1 = p1.matcher(this.email);
        Pattern p2 = Pattern.compile(REGEX_PASSWORD);
        Matcher m2 = p2.matcher(this.password);
        return m1.find() && m2.find();
    }

}