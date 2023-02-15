package com.silver5;

import java.io.*;

public class P2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String converted = s.replace("c=", "A")
                .replace("c-", "B")
                .replace("dz=", "C")
                .replace("d-", "D")
                .replace("lj", "E")
                .replace("nj", "F")
                .replace("s=", "G")
                .replace("z=", "H");

        // better s.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", " ")
        bw.write(String.valueOf(converted.length()));
        bw.flush();
        bw.close();
        br.close();
    }
}
