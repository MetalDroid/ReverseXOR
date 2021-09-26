package com.metal.reversexor;

public class ReverseXor {

    public static String ReverseXOREnc(String input, String password, int reverseLength){
        return XorString(reverseMod(input, reverseLength), password);
    }

    public static String ReverseXORDec(String input, String password, int reverseLength){
        return reverseMod(XorString(input, password), reverseLength);
    }

    private static char Xor(char inputChar, char passwordChar){
        return (char) (inputChar ^ passwordChar);
    }

    private static String XorString (String input, String password){
        StringBuilder res = new StringBuilder(input);
        for (int i = 0; i < res.length(); i++) {
            res.replace(i,i+1, Character.toString(Xor(res.charAt(i), password.charAt(i % password.length()))));
        }
        return res.toString();
    }

    private static String reverseMod(String input, int reverseLength){
        StringBuilder res = new StringBuilder();
        for (int i = reverseLength; i <= input.length(); i += reverseLength) {
            res.append(new StringBuilder(input.substring(i - reverseLength, i)).reverse());
        }
        res.append(new StringBuilder(input.substring(input.length() - (input.length() % reverseLength))).reverse());
        return res.toString();
    }
}
