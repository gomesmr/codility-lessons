package br.com.gomesmr.fundaments;

import java.util.Scanner;

public class BinaryGap {
    public static void main(String[] args) {
//        int N = 1376796946;   101_0010_0001_0000_0100_0001_0001_0010      div 7 resto 3
//                              101 0010 0001 0000 0100 0001 0001 0010
//        int M = 151552257;    1001_0000_1000_1000_0001_0000_0001          div 7 resto 0
//        int M = 151552246;    1001_0000_1000_1000_0000_1111_0110          div 7 resto 0
//        int M = 2368003;      10_0100_0010_0010_0000_0011                 div 5 resto 2
//        int M = 336132;       101_0010_0001_0000_0100                     div 4 resto 3
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int N = scanner.nextInt(); // Lê o próximo número inteiro da entrada
        System.out.println("You typed: " + N);
        scanner.close();

        if (N == -1) N = 8388605;

        System.out.println("Number is: " + N);
        System.out.println("Binary Representation: " + formatBinaryRepresentation(Integer.toBinaryString(N)));
        System.out.println("Solution is: " + solution(N));
    }

    protected static int solution(int N) {
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

    public static String formatBinaryRepresentation(String binaryString) {

        int length = binaryString.length();
        int fullBlocks = length / 4;
        int remainingCharacters = length % 4;

        System.out.println("Length: " + length + ", Num Full Blocks: " + fullBlocks + ", Remaining Chars: " + remainingCharacters);

        if (fullBlocks <= 1 && remainingCharacters == 0) {
            return binaryString;
        }

        int finalLength = calculateFinalLength(length, fullBlocks, remainingCharacters);
        System.out.println("Final Length: " + finalLength);

        char[] formattedArray = new char[finalLength];

        int binaryIndex = 0; // Índice para percorrer binaryString
        int arrayIndex = 0;  // Índice para preencher arrayWithSeparator
        while (binaryIndex < remainingCharacters) {
            formattedArray[arrayIndex++] = binaryString.charAt(binaryIndex++);
        }
        if (remainingCharacters > 0 && binaryIndex < length) { // Adiciona '_' apenas se houver mais caracteres
            formattedArray[arrayIndex++] = '_';
        }

        // Parte principal - processando blocos de 4
        int counter = 0;
        while (binaryIndex < length) {
            formattedArray[arrayIndex++] = binaryString.charAt(binaryIndex++);
            counter++;
            if (counter % 4 == 0 && binaryIndex < length) { // Adiciona '_' após cada bloco de 4
                formattedArray[arrayIndex++] = '_';
            }
        }
        return new String(formattedArray);
    }

    public static int calculateFinalLength(int length, int div, int rest) {
        if (rest > 0) {
            return length + div;
        }
        return length + div - 1;
    }
}