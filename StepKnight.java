import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StepKnight {



    public static boolean moveKnight(int x, int y, int d1, int d2, int N, Queue<MyPair> q, boolean[][] visit) {

        int[] tx = {-1, -1, -1, -1, 2, 2, 2, 2};
        int[] ty = {2, 2, 2, 2, -1, -1, -1, -1};

        for (int i = 0; i < 8; i++) {

            //Check & ignore if out of bound or already visited
            if (x + tx[i] < 0 || x + tx[i] >= N || y + ty[i] < 0 || y + ty[i] >= N || visit[x + tx[i]][y + ty[i]]) {
                continue;
            }

            if (x + tx[i] == d1 && y + ty[i] == d2) {
                return true;
            }
            q.add(new MyPair(x + tx[i], y + ty[i]));
            visit[x + tx[i]][y + ty[i]] = true;
        }

        return false;
    }

    public static int stepKnight(int[] knight, int[] dest, int n) {

        int s1 = knight[0] - 1;
        int s2 = knight[1] - 1;
        int d1 = dest[0] - 1;
        int d2 = dest[1] - 1;
        Queue<MyPair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for (boolean[] v : visited) {
            Arrays.fill(v, false);
        }

        queue.add(new MyPair(s1, s2));
        visited[s1][s2] = true;

        boolean flag = false;
        int step = 0;

        while (!queue.isEmpty()) {
            step++;
            int t = queue.size();
            while (t != 0) {
                int x = queue.peek().a;
                int y = queue.peek().b;
                queue.poll();
                moveKnight(x, y, d1, d2, n, queue, visited);
                if (flag) return step;
                t--;
            }
        }


        return -1;
    }

    public static void main(String[] args) {

    }
}
