import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class JobComparator implements Comparator<Job> {


    @Override
    public int compare(Job o1, Job o2) {
        return o2.profit - o1.profit;
    }
}

public class JobSequencing {


    public static int[] jobScheduling(Job arr[], int n) {
        // Your code here

        boolean[] flags = new boolean[n];
        Arrays.sort(arr, new JobComparator());
        int jobs = 0, profit = 0;
        for (int i = 0; i < n; i++) {
            Job curr = arr[0];
            if (flags[i] == false) {
                flags[i] = true;
                jobs++;
                profit += curr.profit;
                break; //Slot done
            }
        }



        return new int[]{jobs,profit};
    }

    public static void main(String[] args) {

    }

}
