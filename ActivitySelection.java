import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Activity {
    int a;
    int b;

    Activity(int a, int b) {
        this.a = a;
        this.b = b;
    }

}


class ActivityComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity p1, Activity p2) {

        if (p1.b == p2.b) {
            return p1.a - p2.a;
        }

        return p1.b - p2.b;
    }
}


public class ActivitySelection {


    public static int activitySelection(int[] start, int[] end, int n) {

        int count = 0;

        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], end[i]);
        }

        //Sort according to the end timing of the activity object
        Arrays.sort(activities, new ActivityComparator());

        int dest = activities[0].b;
        for (int i = 1; i < n; i++) {
            if (activities[i].a > dest) {
                count++;
                dest = activities[i].b;
            }
        }
        return count;
    }


    public static int activitySelectionUsingPQ(int[] start, int[] end, int n) {
        // add your code here
        int res = 0;
        PriorityQueue<Activity> pq = new PriorityQueue<>((p1, p2) -> p1.a - p2.b);
        for (int i = 0; i < n; i++) {
            pq.offer(new Activity(end[i], start[i]));
        }

        Activity temp1 = pq.poll();
        int s = temp1.b;
        int e = temp1.a;
        res++;

        while (!pq.isEmpty()) {
            Activity temp = pq.poll();
            if (temp.b > e) {
                s = temp.b;
                e = temp.a;
                res++;
            }
        }

        return res;
    }


}
