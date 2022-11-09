public class Hindex {

    public int hIndex(int[] cts) {

        //A1 sort & h-index2

        //A2 bucket sort to find H-index i.e Most Frequent Max O(N)

        int n = cts.length;
        int[] bucket = new int[n + 1];

        for(int i=0; i<n; i++){

            if(cts[i] > n){
                bucket[n]++; // [3, 0, 5 , 100] so we don't need 100 size coz for 100 to be H-index we need 100 such cts Not Possible so just store in cts[n] so as to calculate >= for other cts
            }
            else bucket[cts[i]]++;
        }

        int count = 0;
        for(int i=n; i>=0; i--){
            count += bucket[i];

            if(count >= i){
                return i;
            }

        }


        return 0;
    }
}
