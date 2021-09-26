package com.metal.reversexor;

public class ReverseXor {

    /**
     * @param input Text input to encrypt
     * @param password Password used in xor
     * @param reverseLength Maximum size of each group of characters to reverse
     * @return Encrypted string
     */
    public static String ReverseXOREnc(String input, String password, int reverseLength){
        return XorString(reverseMod(input, reverseLength), password);
    }

    /**
     * @param input Text input to decrypt
     * @param password Password used in xor
     * @param reverseLength Maximum size of each group of characters to reverse
     * @return Decrypted string
     */
    public static String ReverseXORDec(String input, String password, int reverseLength){
        return reverseMod(XorString(input, password), reverseLength);
    }

    /**
     * @param inputChar original char
     * @param passwordChar password char
     * @return encrypted char
     */
    private static char Xor(char inputChar, char passwordChar){
        return (char) (inputChar ^ passwordChar);
    }

    /**
     * Simple xor encryption
     * @param input Priginal string
     * @param password Password string
     * @return Encrypted string
     */
    public static String XorString (String input, String password){
        StringBuilder res = new StringBuilder(input);
        for (int i = 0; i < res.length(); i++) {
            res.replace(i,i+1, Character.toString(Xor(res.charAt(i), password.charAt(i % password.length()))));
        }
        return res.toString();
    }

    /**
     * @param input Text input
     * @param reverseLength Maximum size of each group of characters to reverse
     * @return Reversed (mod) text: Hello World -> Hello World -> lleHow odlr
     */
    public static String reverseMod(String input, int reverseLength){
        StringBuilder res = new StringBuilder();
        for (int i = reverseLength; i <= input.length(); i += reverseLength) {
            res.append(new StringBuilder(input.substring(i - reverseLength, i)).reverse());
        }
        res.append(new StringBuilder(input.substring(input.length() - (input.length() % reverseLength))).reverse());
        return res.toString();
    }
}
