import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RussianDollEnvelopes {
    class Envelope {
        int width;
        int height;

        public Envelope(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    class EnvelopeComparator implements Comparator<Envelope> {
        @Override
        public int compare(Envelope o1, Envelope o2) {
            if (o1.width == o2.width) {
                return o2.height - o1.height;
            }
            return o1.width - o2.width;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {

        List<Envelope> envelopeList = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            Envelope envelope = new Envelope(envelopes[i][0], envelopes[i][1]);
            envelopeList.add(envelope);
        }

        Collections.sort(envelopeList, new EnvelopeComparator());

        List<Integer> envHeights = new ArrayList<>();
        for (Envelope envelope : envelopeList) {
            envHeights.add(envelope.height);
        }

        int lisOfHeights = lis(envHeights);

        return lisOfHeights;
    }


    public static int lis(List<Integer> nums) {
        ArrayList<Integer> lisList = new ArrayList<>();

        for (int i = 0; i < lisList.size(); i++) {
            if (lisList.isEmpty()) {
                lisList.add(nums.get(i));
            } else {
                int last = lisList.size() - 1;
                if (nums.get(i) > lisList.get(last)) {
                    lisList.add(nums.get(i));
                } else {
                    int lowerBound = getLowerBound(nums, nums.get(i));
                    lisList.set(lowerBound, nums.get(i));
                }

            }
        }

        return lisList.size();
    }

    private static int getLowerBound(List<Integer> nums, int key) {

        int low = 0;
        int high = nums.size() - 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = nums.get(mid);
            if (val == key) {
                return mid;
            } else if (val < key) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

}
