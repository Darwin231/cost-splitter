package com.example.billSplit.demo.Utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
    private String email;
    private Integer quantity;
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
