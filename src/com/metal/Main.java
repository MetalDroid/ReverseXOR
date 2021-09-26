package com.metal;

import com.metal.reversexor.ReverseXor;

public class Main {

    public static void main(String[] args) {

        String original = "Hello world";
        String password = "password";
        int rev = 4;

        System.out.printf("Original input: '%s'%n", original);
        String cif = ReverseXor.ReverseXOREnc(original, password, rev);
        System.out.println("Enc. output:");
        System.out.println(cif);
        String dec = ReverseXor.ReverseXORDec(cif, password, rev);
        System.out.printf("Dec. output: '%s'%n", dec);

    }
}
