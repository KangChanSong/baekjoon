package com.silver5;

import java.util.Scanner;

public class P1343_best {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        String str = c.next().replace("XXXX", "AAAA").replace("XX", "BB");
        if (str.contains("X")) str = "-1";
        System.out.println(str);
    }
}
