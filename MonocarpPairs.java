//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class MonocarpPairs {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int test = sc.nextInt();
//        for (int t = 0; t < test; ++t) {
//            int n = sc.nextInt();
//
//            double sum = 0;
//            HashMap<Integer, Long> map = new HashMap<>();
//
//            for (int i = 0; i < n; i++) {
//
//                int num = sc.nextInt();
//                sum += num;
//                map.put(num, map.getOrDefault(num, 0L) + 1L);
//            }
//
//            double sum2 = sum - (2 * (sum / n));
//
//            int targetSumOfPairs = (int) (sum - sum2);
//
//            long ans = 0;
//
//            //Check if integer
//            if ((int) targetSumOfPairs != targetSumOfPairs) {
//                System.out.println(ans);
//                continue;
//            }
//
//
//            for (Map.Entry<Integer, Long> entry : map.entrySet()) {
//                int currFirst = entry.getKey();
//                long currFirstFreq = entry.getValue();
//                int complement = targetSumOfPairs - currFirst;
//
//                if (currFirst == complement) {
//                    ans += (int) (currFirstFreq*(currFirstFreq-1))/2;
//                } else if (map.containsKey(complement)) {
//                    ans += currFirstFreq * map.get(complement);
//                    map.put(currFirst, 0L);
//                }
//            }
//
//
//            System.out.println(ans);
//
//        }
//
//    }
//}