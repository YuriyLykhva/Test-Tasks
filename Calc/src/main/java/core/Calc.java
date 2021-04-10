package core;

//  accepts numbers from -20 to 20, if more than 20 or less -20 - returns a warning message.
//  Build application using maven
//  write results to a file with date/time of calculation
//  arrange application structure according to OOP
//  Create your personal Git repo with the results and application sources

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Calc {

    public static void main(String[] args) throws IOException {

        boolean isNotInRange = true;
        double pow;
        int n, startIndex, signIndex = -1, numA = 0, numB = 0;
        char[] value = new char[20];
        int[] signPosition = new int[2];

        while (isNotInRange) {
            System.out.println("Enter expression in the format \"a?b\", where " +
                    "\n\ta & b - integer numbers between -20 and 20, " +
                    "\n\t? - arithmetical action and press Enter:");

            Scanner s = new Scanner(System.in);
            value = s.nextLine().toCharArray();

            int j = 0;

            for (int i = 0; i < value.length; i++) {
                int digit = Character.digit(value[i], 10);

                if (digit == -1) {
                    signPosition[j] = i;
                    j++;
                }
            }
            numA = 0;
            numB = 0;
            if (value[0] == '-') {
                signIndex = signPosition[1];
                startIndex = 1;
            } else {
                signIndex = signPosition[0];
                startIndex = 0;
            }

            for (int i = signIndex - 1; i >= startIndex; i--) {
                n = Character.getNumericValue(value[i]);
                pow = Math.pow(10, signIndex - i - 1);
                numA += n * pow;
            }

            for (int i = value.length - 1; i > signIndex; i--) {
                n = Character.getNumericValue(value[i]);
                pow = Math.pow(10, value.length - i - 1);
                numB += n * pow;
            }
            isNotInRange = isNotInRange(numA, numB);
        }
        String s2 = null;

        if (value[0] == '-')
            numA = -1 * numA;

        if (value[signIndex] == '+') {
            s2 = (numA + " + " + numB + " = " + (numA + numB));
        }

        if (value[signIndex] == '-') {
            s2 = (numA + " - " + numB + " = " + (numA - numB));
        }

        if (value[signIndex] == '*') {
            s2 = (numA + " * " + numB + " = " + (numA * numB));
        }

        if (value[signIndex] == '/') {
            s2 = (numA + " / " + numB + " = " + (numA / numB));
        }


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        File data = new File(
                "C:\\Users\\Yurii_Lykhva\\IdeaProjects\\Calc\\src\\main\\resources\\result.txt");
        FileOutputStream file = new FileOutputStream(data);
        FilterOutputStream filter = new FilterOutputStream(file);
        String s1 = dtf.format(now);

        String s = s1 + "\n" + s2;
        byte[] b = s.getBytes();
        filter.write(b);
        filter.flush();
        filter.close();
        file.close();

    }

    public static boolean isNotInRange(int a, int b) {
        boolean x = false;
        if (a > 20 || b > 20) {
            System.out.println("Some number is out of range");
            x = true;
        }
        return (x);
    }
}
