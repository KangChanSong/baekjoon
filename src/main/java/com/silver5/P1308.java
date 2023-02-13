package com.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class P1308 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LocalDate start = toLocalDate(br.readLine().split(" "));
        LocalDate thousandYearsAfterStartDate = start.plusYears(1000);
        LocalDate end = toLocalDate(br.readLine().split(" "));

        long thousandGap = thousandYearsAfterStartDate.toEpochDay() - start.toEpochDay();
        long finishGap = end.toEpochDay() - start.toEpochDay();
        if (thousandGap <= finishGap) System.out.println("gg");
        else System.out.println("D-"+ finishGap);
    }

    private static LocalDate toLocalDate(String[] strArr) {
        return LocalDate.of(toInt(strArr[0]), toInt(strArr[1]), toInt(strArr[2]));
    }

    private static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
