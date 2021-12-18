package com.senoJmartMH;

/**
 * Class Account - Class untuk mendefinisikan object Account serta validasi input menggunakan REGEX berdasarkan batasan yang telah ditentukan
 *
 * @author Seno Aji Wicaksono
 * @version 18-12-2021
 */

import com.senoJmartMH.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable
{
    // instance variables - replace the example below with your own
    public static final String REGEX_EMAIL = "^(?!\\.)(?!.*?\\.\\.)[a-zA-Z0-9&_*~.]+@(?!-)[a-zA-Z0-9-]+\\.(?!.*\\.$)[a-zA-Z0-9.]+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d](\\S){8,}$";
    public Store store;
    public String name;
    public String email;
    public String password;
    public double balance;
    //public double balance;


    public Account(String name, String email, String password, int i)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        // this.balance = balance;//
    }

    public String toString(){
        return "name: " + this.name + "\n"
                + "email: " + this.email + "\n"
                + "password: " + this.password;
    }

    public boolean validate(){
        Pattern p1 = Pattern.compile(REGEX_EMAIL);
        Matcher m1 = p1.matcher(this.email);
        Pattern p2 = Pattern.compile(REGEX_PASSWORD);
        Matcher m2 = p2.matcher(this.password);
        return m1.find() && m2.find();
    }

}