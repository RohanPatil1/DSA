import java.util.List;

public class OliverAndBob {

    int[] inTime = new int[10001];
    int[] outTime = new int[10001];

    int timer = 0;

    boolean isSubTree(int x, int y) {
        if (inTime[x] > outTime[y] && outTime[x] < inTime[y]) {
            return true;
        }
        return false;
    }

    public void canBobFindOliver(int n, List<List<Integer>> adj, int oliver, int bob, int direction) {

        //Fill inTime & outTime using dfs on tree
        dfs(1, 0, adj);


        //Check if O is subtree of B or vice versa
        boolean checkOB = isSubTree(oliver, bob);

        //Check if B is subtree of O or vice versa
        boolean checkBO = isSubTree(bob, oliver);

        if (!checkBO && !checkOB) {
            //Not possible
            System.out.println("NO");
        }

        if (direction == 0) {
            if (checkBO) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            if (checkOB) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private void dfs(int src, int parent, List<List<Integer>> adj) {
        inTime[src] = timer++;
        for (int k : adj.get(src)) {
            if (k != parent) {
                dfs(k, src, adj);
            }
        }
        outTime[src] = timer++;
    }
}
