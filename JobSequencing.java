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

        int deadMax = Integer.MIN_VALUE;
        for(Job j:arr){
            deadMax = Math.max(deadMax,j.deadline);
        }
        boolean[] flags =new boolean[deadMax+1];
        Arrays.sort(arr, new JobComparator());
        int jobCount = 0,profit = 0;
        for(int i=0;i<n;i++){

            Job curr = arr[i];


            for(int j=curr.deadline;j>0;j--){
                if(flags[j]==false){
                    flags[j] = true;
                    jobCount++;
                    profit += curr.profit;
                    break;
                }
            }

        }

        return new int[]{jobCount, profit};
    }

    public static void main(String[] args) {

    }

}
