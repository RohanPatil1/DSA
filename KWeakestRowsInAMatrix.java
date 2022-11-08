import java.util.Comparator;
import java.util.PriorityQueue;

public class KWeakestRowsInAMatrix {

    class Row {
        int soldiers;
        int rowNo;

        public Row(int soldiers, int rowNo) {
            this.soldiers = soldiers;
            this.rowNo = rowNo;
        }
    }

    class RowComparator implements Comparator<Row> {

        @Override
        public int compare(Row r1, Row r2) {

            if (r1.soldiers == r2.soldiers) {
                return r2.rowNo - r1.rowNo;
            }

            return r2.soldiers - r1.soldiers;

        }

    }

    //Time=> mlogk + m*n
    public int[] kWeakestRows(int[][] mat, int k) {


        int n = mat.length;
        int m = mat[0].length;

        PriorityQueue<Row> pq = new PriorityQueue<>(new RowComparator());

        for (int i = 0; i < n; i++) {
            int currSoldiers = 0;

            ///Use BS to reduce this to logN
            //currSoldiers = count1sUsingBS(row);
            //Time=> mLogK + mLogN

            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 1) currSoldiers++;

            }

            pq.add(new Row(currSoldiers, i));
            if (pq.size() > k) {
                pq.poll();
            }

        }

        int[] ans = new int[k];
        int p = k - 1;
        while (!pq.isEmpty()) {
            ans[p] = pq.poll().rowNo;
            p--;
        }


        return ans;
    }

    int count1sUsingBS(int[] row) {
        int left = 0;
        int right = row.length;
        while (left < right) {

            int mid = left + (right - left) / 2;
            if (row[mid] == 1) left = mid + 1;
            else right = mid;
        }
        return left;
    }

}
