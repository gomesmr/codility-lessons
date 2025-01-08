package br.com.gomesmr.fundaments;

class MaxCountersDepurative {
    public static void main(String[] args) {
        SolutionDepurative maxCounters = new SolutionDepurative();
        // Exemplo de entrada
        int N = 7; // Número de contadores
        int[] A = {3, 4, 4, 6, 1, 4, 4, 6, 2, 3, 4, 3, 6, 1, 8, 5, 1, 3, 4, 3, 3, 3, 3, 8, 4, 6, 2, 3, 4, 3, 6, 8, 5, 5, 1, 3}; // Operações

        // Chamar o metodo solution
        int[] result = maxCounters.solution(N, A);

        // Imprimir o resultado
        System.out.println("Resultado:");
        for (int value : result) {
            System.out.print(value + " ");
        }

    }
}

class SolutionDepurative {
    public int[] solution(int N, int[] A) {
        // Implement your solution here
        int[] counter = new int[N];
        int maxGlobal = 0;
        int maxApplied = 0;
        System.out.println();
        System.out.println("===========================");
        System.out.println("Example test");
        System.out.println("N = 5");
        System.out.println("A = [3, 4, 4, 6, 1, 4, 4, 6, 2, 3, 4, 3, 6, 1, 8, 5, 1, 3, 4, 3, 3, 3, 3, 8, 4, 6, 2, 3, 4, 3, 6, 8, 5, 5, 1, 3])");
        System.out.println("maxGlobal: " + maxGlobal);
        System.out.println("maxApplied: " + maxGlobal);
        System.out.println("counter = [0, 0, 0, 0, 0]");
        System.out.println("===========================");
        System.out.println();

        for (int a : A){
            if(a >= 1 && a <= N){
                System.out.println("============================================================");
                System.out.print("IF 01 " + maxApplied + " > " + counter[a-1]);
                if(maxApplied > counter[a-1]){
                    System.out.println(" -> Sim!");
                    System.out.print("Counter antes do Update:\ncounter = [");
                    System.out.print(counter[0]);
                    if(N > 1){
                        for (int i = 1; i < N; i++){
                            System.out.print(", " + counter[i]);
                        }
                    }
                    System.out.println("]");
                    counter[a-1] = maxApplied;
                    System.out.println("\nUPDATE counter[a-1] = maxApplied -> " + "counter[a-1] -> counter["+a+"-1)"+"] -> counter["+(a-1)+"] = " + maxApplied);
                    System.out.println("\nCounter depois do Update:");

                }
                else{
                    System.out.println(" -> Não!\n");
                }
                System.out.print("counter = [");
                System.out.print(counter[0]);
                if(N > 1){
                    for (int i = 1; i < N; i++){
                        System.out.print(", " + counter[i]);
                    }
                }
                System.out.println("]");

                System.out.println();
                System.out.println("for (int a : A)");
                System.out.println("a = "+a);
                System.out.println("counter[a-1] -> counter["+a+"-1)"+"] -> counter["+(a-1)+"] = "+counter[a-1]);

                System.out.println("Antes de incrementar: counter["+(a-1)+"] = "+counter[a-1]);

                counter[a - 1]++;

                System.out.println("Depois: counter["+(a-1)+"] = "+counter[a-1]);

                System.out.println("maxGlobal = " + maxGlobal + "\nAntes de testar Math.max(" + maxGlobal +", " + counter[a-1] + "): ");

                maxGlobal = Math.max(maxGlobal, counter[a-1]);

                System.out.println("Depois: " + maxGlobal);
                System.out.println();
            }
            else if(a == N+1){
                System.out.println("maxApplied Antes: " + maxApplied);
                maxApplied = maxGlobal;
                System.out.println("maxApplied Depois: " + maxApplied);
            }
        }
        for(int i = 0; i < N; i++){
            System.out.print("Antes:  counter = [");
            System.out.print(counter[0]);
            if(N > 1){
                for (int j = 1; j < N; j++){
                    System.out.print(", " + counter[j]);
                }
            }
            System.out.println("]");
            if(counter[i] < maxApplied){
                counter[i] = maxApplied;
            }
            System.out.print("Depois: counter = [");
            System.out.print(counter[0]);
            if(N > 1){
                for (int k = 1; k < N; k++){
                    System.out.print(", " + counter[k]);
                }
            }
            System.out.println("]");
            System.out.println();
        }
        return counter;
    }
}
