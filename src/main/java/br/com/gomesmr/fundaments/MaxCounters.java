package br.com.gomesmr.fundaments;

public class MaxCounters {
    public static void main(String[] args) {
        // Exemplo de entrada
        int N = 5; // Número de contadores
        int[] A = {3, 4, 4, 6, 1, 4, 4, 6, 2, 3, 4, 3, 6, 1}; // Operações

        // Chamar o metodo solution
        int[] result = solution(N, A);

        // Imprimir o resultado
        System.out.println("Resultado:");
        for (int value : result) {
            System.out.print(value + " ");
        }

    }

    protected static int[] solution(int N, int[] A) {
        // Implement your solution here
        int[] counter = new int[N];
        int max = 0;

        for (int a : A) {
            if (a <= N) {
                increase(counter, a);
                max = Math.max(max, counter[a - 1]);
            } else maxCounter(counter, max);
        }

        return counter;
    }

    public static void increase(int[] counter, int x) {
        counter[x - 1] += 1;
    }

    public static void maxCounter(int[] counter, int max) {
        for (int i = 0; i <= counter.length - 1; i++) {
            counter[i] = max;
        }
    }

    public int findMax(int a, int max) {
        return Math.max(a, max);
    }
}
