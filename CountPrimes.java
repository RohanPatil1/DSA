import java.util.Arrays;

public class CountPrimes {

    public static int countPrimes(int n) {

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i; j * i < n; j++) {
                    primes[j * i] = false;
                }
            }
        }

        int primeCount = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) primeCount++;
        }

        return primeCount;
    }

}
