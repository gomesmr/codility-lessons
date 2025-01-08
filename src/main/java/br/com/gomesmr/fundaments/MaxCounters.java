package br.com.gomesmr.fundaments;

class MaxCounters {
    public static void main(String[] args) {
        Solution maxCounters = new Solution();
        // Exemplo de entrada
        int N = 5; // Número de contadores
        int[] A = {3, 4, 4, 6, 1, 4, 4, 6, 2, 3, 4, 3, 6, 1}; // Operações

        // Chamar o metodo solution
        int[] result = maxCounters.solution(N, A);

        // Imprimir o resultado
        System.out.println("Resultado:");
        System.out.print("counter = [");
        System.out.print(result[0]);
        for (int i = 1; i < N; i++) {
            System.out.print(", " + result[i]);
        }
        System.out.println("]");

    }
}

class Solution {
    public int[] solution(int N, int[] A) {
        // Implement your solution here
        int[] counter = new int[N];
        int maxGlobal = 0;
        int maxApplied = 0;
        for (int a : A) {
            if (a >= 1 && a <= N) {
                if (maxApplied > counter[a - 1]) {
                    counter[a - 1] = maxApplied;
                }
                counter[a - 1]++;
                maxGlobal = Math.max(maxGlobal, counter[a - 1]);
            } else if (a == N + 1) {
                maxApplied = maxGlobal;
            }
        }

        for (int i = 0; i < N; i++) {
            if (counter[i] < maxApplied) {
                counter[i] = maxApplied;
            }
        }
        return counter;
    }
}