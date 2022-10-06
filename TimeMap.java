import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TimeMap {

    public class TimeValue {
        String value;
        int time;

        public TimeValue(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }


    HashMap<String, List<TimeValue>> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            List<TimeValue> list = new ArrayList<>();
            list.add(new TimeValue(value, timestamp));
            map.put(key, list);
        } else {

            map.get(key).add(new TimeValue(value, timestamp));
        }
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) return "";

        String answer = "";
        List<TimeValue> values = map.get(key);
        int low = 0;
        int high = values.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            TimeValue curr = values.get(mid);

            if (curr.time <= timestamp) {
                answer = curr.value;
                low = mid + 1;
            } else {

                high = mid - 1;
            }

        }

        return answer;

    }
}