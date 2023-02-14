package com.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class P1340 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm");
        LocalDateTime ld = LocalDateTime.parse(br.readLine(), formatter);
        LocalDateTime janFirst = LocalDateTime.of(ld.getYear(), 1, 1, 0, 0, 0);
        LocalDateTime decLast = LocalDateTime.of(ld.getYear(), 12, 31, 23, 59, 59);
        double a = getEpochTime(decLast, janFirst);
        double b = getEpochTime(ld, janFirst);
        System.out.println(b / a  * 100.0);
    }
    private static double getEpochTime(LocalDateTime from, LocalDateTime to) {
        long fromSec = from.atZone(ZoneId.of("Asia/Seoul")).toEpochSecond();
        long toSec = to.atZone(ZoneId.of("Asia/Seoul")).toEpochSecond();
        return fromSec - toSec;
    }
}
