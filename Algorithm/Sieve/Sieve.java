package Algorithm.Sieve;

import java.util.Arrays;

public class Sieve {
    public boolean[] solution(int N) {
        boolean[] sieve = new boolean[N + 1];
        sieve[0] = false;
        sieve[1] = false;

        int i = 2;

        while (i * i <= N) {
            if(sieve[i] == true){
                int k = i * i;
                while (k <= N) {
                    sieve[k] = false;
                    k += i;
                }
            }
            i++;
        }

        return sieve;
    }
    public static void main(String[] args) {
        Sieve obj = new Sieve();
        System.out.println(Arrays.toString(obj.solution(17)));
    }
    
}