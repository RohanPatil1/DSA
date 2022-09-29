public class DieHard {

    //https://www.spoj.com/problems/DIEHARD/
    //Get max time of survival
    public static int dieHard(int H, int A) {

        int startAir = solve(H + 3, A + 2, 1);
        int startWater = solve(H - 5, A - 10, 2);
        int startFire = solve(H - 20, A + 5, 3);

        return Math.max(startAir, Math.max(startWater, startFire));
    }

    public static int solve(int H, int A, int currArea) {
        if (H <= 0 || A <= 0) {
            return 0;
        }

        int x = 0, y = 0, z = 0;

        if (currArea != 1) x = 1 + solve(H + 3, A + 2, 1);
        if (currArea != 2) y = 1 + solve(H - 5, A - 10, 2);
        if (currArea != 3) z = 1 + solve(H - 20, A + 5, 3);

        return Math.max(x, Math.max(y, z));
    }

}
