import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Range {
    int start;
    int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

class RangeComparator implements Comparator<Range> {

    @Override
    public int compare(Range o1, Range o2) {
        return o1.start - o2.start;
//        return o2.start - o1.start;
    }
}

public class WaterThePlants {


    public static int waterThePlants(int[] arr) {

        int n = arr.length;

        List<Range> rangeList = new ArrayList<>();

        //Fill the range for every index
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) continue;
            int start = Math.max(0, i - arr[i]);
            int end = Math.min(n - 1, i + arr[i]);

            rangeList.add(new Range(start, end));
        }

        //Sort according start from 0 to ascending order
        Collections.sort(rangeList, new RangeComparator());

        //Print
        for (Range r : rangeList) {
            System.out.println("[" + r.start + "," + r.end + "]");
        }

        //Compute
        int start = 0;
        int i = 0; //Our current position
        int sprinklerCount = 0;


        while (start < n) {
            int currReach = Integer.MIN_VALUE;
            //For eg if 0, we will search which is 0 or less than 0
            while (i < rangeList.size()) {
                if (rangeList.get(i).start > start)
                    break;

                currReach = Math.max(currReach, rangeList.get(i).end);
                i++;
            }

            //[1,4] ,[2,3], [6,8] if our currReach = 3 & next element is [6,8] so our start(6) > currReach(3) so return -1
            if (currReach == Integer.MIN_VALUE || currReach < start) return -1; //No element to reach

            sprinklerCount++;
            start = currReach + 1; //Next Start for next iteration
        }


        return sprinklerCount;
    }


    public static void main(String[] args) {
        waterThePlants(new int[]{-1, 2, 2, -1, 0, 0});
        //               0   1  2   3  4  5
    }
}
