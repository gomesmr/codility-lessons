package br.com.gomesmr.fundaments;

import java.util.Scanner;

public class BinaryGap {
    public static int solution(int N) {
        String number = Integer.toBinaryString(N);

        int binaryGap = 0;
        int numberOfZeros = 0;

        for (int i = 0; i < number.length(); i++) {
            char charOfNumber = number.charAt(i);
            if (charOfNumber == '0') {
                numberOfZeros++;
            } else {
                if (binaryGap < numberOfZeros) {
                    binaryGap = numberOfZeros;
                }
                numberOfZeros = 0;
            }
        }
        return binaryGap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita a entrada do usuário
//        System.out.print("Enter an integer: ");
        int N = 336132;

//        int N = 1376796946;   101_0010_0001_0000_0100_0001_0001_0010      div 7 resto 3
//                              101 0010 0001 0000 0100 0001 0001 0010
//        int M = 151552257;    1001_0000_1000_1000_0001_0000_0001          div 7 resto 0
//        int M = 151552246;    1001_0000_1000_1000_0000_1111_0110          div 7 resto 0
//        int M = 2368003;      10_0100_0010_0010_0000_0011                 div 5 resto 2
//        int M = 336132;       101_0010_0001_0000_0100                     div 4 resto 3

        System.out.println("Number is: " + N);
        System.out.println("Binary Representation: " + formatBinaryRepresentation(Integer.toBinaryString(N)));
        System.out.println("Solution is: " + solution(N));
    }

    private static String formatBinaryRepresentation(String binaryString) {

        int length = binaryString.length();
        int div = length / 4;
        int rest = length % 4;

        System.out.println("Length: " + length + ", Div: " + div + ", Resto: " + rest);

        if (div <= 1 && rest == 0) {
            return binaryString;
        }

        int final_length = finalLength(length, div, rest);
        System.out.println("Final Length: " + final_length);

        char[] arrayWithSeparator = new char[final_length];
        System.out.println("Array Length: " + arrayWithSeparator.length);

        int i, j = 0;
        for (i = 0; j <= rest; i++) {
            if (i / rest == 0) {
                arrayWithSeparator[j] = binaryString.charAt(i);
            } else {
                arrayWithSeparator[j] = '_';
            }
            j++;
        }

        i--;

        int internalCounter = 1;
        for (; j < final_length; i++) {
            if (internalCounter % 5 == 0) {
                arrayWithSeparator[j] = '_';
                arrayWithSeparator[j + 1] = binaryString.charAt(i);
                internalCounter = 1;
                i--;
            } else {
                arrayWithSeparator[j] = binaryString.charAt(i);
                internalCounter++;
            }
            j++;
        }
        System.out.println(arrayWithSeparator);

        return "hello";
    }

    private static int finalLength(int length, int div, int rest) {
        if (rest > 0) {
            return length + div;
        }
        return length + div - 1;
    }
}