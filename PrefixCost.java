import java.util.*;

//class DistinctSortComp implements Comparator<Integer> {
//    private final Map<Integer, Integer> freqMap;
//
//    DistinctSortComp(Map<Integer, Integer> tFreqMap) {
//        this.freqMap = tFreqMap;
//    }
//
//    @Override
//    public int compare(Integer k1, Integer k2) {
//        int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));
//
//        int valueCompare = k1.compareTo(k2);
//
//        if (freqCompare == 0)
//            return valueCompare;
//        else
//            return freqCompare;
//    }
//}

public class PrefixCost {

//    public static int getDistinct(List<Integer> arr) {
//        HashSet<Integer> set = new HashSet<>(arr);
//        return set.size();
//    }
//
//    public static long getMinimumCost(List<Integer> arr) {
//        //My Goal to sort according to distinct 1 1 3 3 3 3 2 => 3 3 3 3 1 1 2
//        int ans = 0;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        List<Integer> distinctSortArr = new ArrayList<>();
//        for (int current : arr) {
//            int count = map.getOrDefault(current, 0);
//            map.put(current, count + 1);
//            distinctSortArr.add(current);
//        }
//        DistinctSortComp comp = new DistinctSortComp(map);
//        distinctSortArr.sort(comp);
//        for (int i = 0; i < distinctSortArr.size(); i++) {
//            int j = 0;
//            int k = i + 1;
//            List<Integer> subArr = distinctSortArr.subList(j, k);
//            ans += getDistinct(subArr);
//        }
//        return ans;
//    }

    //NotWorking
    public static long getMinimumCost2(List<Integer> arr) {
        long count = 0L, total = 0L;
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : arr) {
            if (!set.contains(integer)) {
                count += 1;
                set.add(integer);
            }
            total += count;
        }

        return total;
    }


    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        temp.add(2);
        temp.add(2);
        temp.add(3);
        temp.add(1);
        temp.add(1);

//        System.out.println(getMinimumCost(temp));
        System.out.println(getMinimumCost2(temp));
    }
}
