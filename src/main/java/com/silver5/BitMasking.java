package com.silver5;

public class BitMasking {
    public static void main(String[] args) {
        String stringRepresentation = "01000001010000010100000100000011";
        int intRepresentation = Integer.parseUnsignedInt(stringRepresentation, 2);
        System.out.println("intRepresentation = " + intRepresentation);
    }
}
