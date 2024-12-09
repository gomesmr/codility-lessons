package br.com.gomesmr.fundaments;

import java.util.Scanner;

public class BinaryGap {
    private static final int BLOCK_SIZE = 4;
    private static final char SEPARATOR = '_';

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
        if (binaryString == null || binaryString.isEmpty()) {
            throw new IllegalArgumentException("Input binary string cannot be null or empty.");
        }

        int length = binaryString.length();
        int fullBlocks = length / BLOCK_SIZE;
        int remainingCharacters = length % BLOCK_SIZE;

        // If the string is already in the desired format, return it as is
        if (fullBlocks <= 1 && remainingCharacters == 0) {
            return binaryString;
        }

        int finalLength = calculateFinalLength(length, fullBlocks, remainingCharacters);
        char[] formattedArray = new char[finalLength];

        int binaryIndex = 0;
        int arrayIndex = 0;

        // Add remaining characters (if any) before the first separator
        arrayIndex = addRemainingCharacters(binaryString, formattedArray, binaryIndex, remainingCharacters);
        binaryIndex += remainingCharacters;

        // Add separator if there are more characters to process
        if (remainingCharacters > 0 && binaryIndex < length) {
            formattedArray[arrayIndex++] = SEPARATOR;
        }

        // Process full blocks of 4 characters
        addFullBlocks(binaryString, formattedArray, binaryIndex, arrayIndex, length);

        return new String(formattedArray);
    }

    public static int calculateFinalLength(int length, int fullBlocks, int remainingCharacters) {
        int separators = fullBlocks - (remainingCharacters == 0 ? 1 : 0);
        return length + separators;
    }

    private static int addRemainingCharacters(String binaryString, char[] formattedArray, int binaryIndex, int remainingCharacters) {
        for (int i = 0; i < remainingCharacters; i++) {
            formattedArray[i] = binaryString.charAt(binaryIndex++);
        }
        return remainingCharacters;
    }

    private static void addFullBlocks(String binaryString, char[] formattedArray, int binaryIndex, int arrayIndex, int length) {
        int counter = 0;

        while (binaryIndex < length) {
            formattedArray[arrayIndex++] = binaryString.charAt(binaryIndex++);
            counter++;

            // Add separator after every BLOCK_SIZE characters, except at the end
            if (counter % BLOCK_SIZE == 0 && binaryIndex < length) {
                formattedArray[arrayIndex++] = SEPARATOR;
            }
        }

    }

    public String addSeparator(String input, int blockSize, char separator) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i));
            // Add separator after every BLOCK_SIZE characters, except at the end
            if ((i + 1) % blockSize == 0 && i != input.length() - 1) {
                result.append(separator);
            }
        }
        return result.toString();
    }

}

/**
 * Análise de Complexidade
 * Tempo:
 * <p>
 * O loop for percorre todos os caracteres da string de entrada uma vez, resultando em O(n).
 * As operações dentro do loop (como append e a verificação condicional) têm custo constante O(1).
 * Portanto, a complexidade total é O(n).
 * Espaço:
 * <p>
 * O uso de um StringBuilder para construir a string de saída significa que o espaço adicional usado é proporcional ao tamanho da string de entrada, resultando em O(n) de complexidade espacial.
 * Conclusão
 * A complexidade O(n) é eficiente para este tipo de problema, pois o algoritmo processa cada caractere exatamente uma vez e realiza operações simples em cada iteração.
 */



