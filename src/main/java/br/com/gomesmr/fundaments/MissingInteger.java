package br.com.gomesmr.fundaments;

class MissingInteger {
    public static void main(String[] args) {
        Solution missingInteger = new Solution();
        int[] A = {-1, 1, 5, 4, 2, 3, 6, 8, 9}; // Operações

        int result = missingInteger.solution(A);
        System.out.println(result);
    }

    static class Solution {
        public int solution(int[] A) {
            boolean allNegative = true;
            boolean hasOne = false;
            int minimum = 1;
            int maximum = 0;
            int diff = 0;
            int greater = 0;

            for (int a : A){
                //verfifica se tem núm positivo para mudar flag
                if(a > 0) allNegative = false;
                if(a > 0 && Math.abs(a - minimum) == 1){
                    minimum = a;
                }
                if(!hasOne && a == 1) hasOne = true;
                maximum = Math.max(maximum, a);
                if((a-maximum) == -1) maximum = a;
                diff = Math.abs(maximum - minimum);
                greater = Math.max(greater, a);

                System.out.println("a: " + a);
                System.out.println("allNegative: " + allNegative);
                System.out.println("hasOne: " + hasOne);
                System.out.println("minimum: " + minimum);
                System.out.println("maximum: " + maximum);
                System.out.println("diff: " + diff);
                System.out.println("greater: " + greater);
                System.out.println("====================\n");
            }
            if(allNegative || !hasOne) return minimum;
            return greater + 1;
        }
    }
}
