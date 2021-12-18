package com.senoJmartMH;

import com.senoJmartMH.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class Store - Class untuk mendefinisikan object Store serta validasi input menggunakan REGEX berdasarkan batasan yang telah ditentukan
 *
 * @author Seno Aji Wicaksono
 * @version 18-12-2021
 */
public class Store
{
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    public static final String REGEX_NAME = "^[A-Z](?!.*([ ])\1).{3,19}$";
    public String name;
    public double balance;
    public String address;
    public String phoneNumber;
    //constructors
    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.balance = balance;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return ("name: " + name +
                "\naddress: " + address +
                "\nphoneNumber: " + phoneNumber);
    }
    public boolean validate(){
        Pattern pPhone = Pattern.compile(REGEX_PHONE);
        Pattern pName = Pattern.compile(REGEX_NAME);
        Matcher mPhone = pPhone.matcher(phoneNumber);
        Matcher mName = pName.matcher(name);
        if(mPhone.find() && mName.find()){
            return true;
        }else{
            return false;
        }
    }

}