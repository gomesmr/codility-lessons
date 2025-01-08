package br.com.gomesmr.fundaments;

class MaxCounterRefacted {
    public static void main(String[] args) {
        Solutions maxCounters = new Solutions();

        // Exemplo de entrada
        int N = 5; // Número de contadores
        int[] A = {3, 4, 4, 6, 1, 4, 4, 6, 2, 3, 4, 3, 6, 1}; // Operações

        // Chamar o método solution
        int[] result = maxCounters.solution(N, A);

        // Imprimir o resultado
        System.out.println("Resultado:");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}

class Solutions {

    public int[] solution(int N, int[] A) {
        int[] counter = new int[N];
        int maxGlobal = 0;
        int maxApplied = 0;

        logInitialState(N, A, maxGlobal, maxApplied, counter);

        for (int a : A) {
            if (isIncreaseOperation(a, N)) {
                counter = handleIncreaseOperation(counter, a, maxApplied);
                maxGlobal = updateMaxGlobal(maxGlobal, counter[a - 1]);
            } else if (isMaxCounterOperation(a, N)) {
                maxApplied = handleMaxCounterOperation(maxGlobal);
            }
        }

        return applyMaxApplied(counter, maxApplied);
    }

    private boolean isIncreaseOperation(int a, int N) {
        return a >= 1 && a <= N;
    }

    private boolean isMaxCounterOperation(int a, int N) {
        return a == N + 1;
    }

    private int[] handleIncreaseOperation(int[] counter, int a, int maxApplied) {
        if (maxApplied > counter[a - 1]) {
            logUpdateCounter(a, maxApplied, counter[a - 1]);
            counter[a - 1] = maxApplied;
        }
        counter[a - 1]++;
        logCounterState(counter, a);
        return counter;
    }

    private int handleMaxCounterOperation(int maxGlobal) {
        logMaxAppliedUpdate(maxGlobal);
        return maxGlobal;
    }

    private int updateMaxGlobal(int maxGlobal, int currentCounter) {
        int updatedMaxGlobal = Math.max(maxGlobal, currentCounter);
        logMaxGlobalUpdate(maxGlobal, updatedMaxGlobal);
        return updatedMaxGlobal;
    }

    private int[] applyMaxApplied(int[] counter, int maxApplied) {
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] < maxApplied) {
                counter[i] = maxApplied;
            }
        }
        return counter;
    }

    private void logInitialState(int N, int[] A, int maxGlobal, int maxApplied, int[] counter) {
        System.out.println();
        System.out.println("===========================");
        System.out.println("Example test");
        System.out.println("N = " + N);
        System.out.print("A = [");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + (i < A.length - 1 ? ", " : "]\n"));
        }
        System.out.println("maxGlobal: " + maxGlobal);
        System.out.println("maxApplied: " + maxApplied);
        System.out.print("counter = [");
        for (int i = 0; i < counter.length; i++) {
            System.out.print(counter[i] + (i < counter.length - 1 ? ", " : "]\n"));
        }
        System.out.println("===========================");
        System.out.println();
    }

    private void logUpdateCounter(int a, int maxApplied, int currentCounter) {
        System.out.println("Atualizando counter[a-1]:");
        System.out.println("Valor antes: " + currentCounter);
        System.out.println("Novo valor: " + maxApplied);
    }

    private void logCounterState(int[] counter, int a) {
        System.out.print("Estado atual do counter após incremento:");
        System.out.print(" [");
        for (int i = 0; i < counter.length; i++) {
            System.out.print(counter[i] + (i < counter.length - 1 ? ", " : "]\n"));
        }
    }

    private void logMaxAppliedUpdate(int maxGlobal) {
        System.out.println("Atualizando maxApplied para: " + maxGlobal);
    }

    private void logMaxGlobalUpdate(int oldMaxGlobal, int newMaxGlobal) {
        System.out.println("Atualizando maxGlobal: de " + oldMaxGlobal + " para " + newMaxGlobal);
    }
}
