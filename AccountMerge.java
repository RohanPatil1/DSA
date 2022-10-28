import java.util.*;

public class AccountMerge {

    public static List<List<String>> accountMerge(List<List<String>> details) {

        int n = details.size();
        DisjointSet.UF uf = new DisjointSet.UF(n);

        Map<String, Integer> map = new HashMap<>();

        //Fill the disjoint set & set the ultimate parents
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details.get(i).size(); j++) {
                String currMail = details.get(i).get(j);
                if (!map.containsKey(currMail)) {
                    map.put(currMail, i);
                } else {
                    uf.union(i, map.get(currMail));
                }
            }
        }

        //Put mails according to their ultimate parents
        List<List<String>> mergedMails = new ArrayList<>();
        for (int i = 0; i < n; i++) mergedMails.add(new ArrayList<>());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int ultimateParent = uf.find(entry.getValue());
            String currMail = entry.getKey();

            mergedMails.get(ultimateParent).add(currMail);
        }

        //Output with name at 0 and the respective mails
        List<List<String>> outputList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMails.get(i).isEmpty()) continue;

            Collections.sort(mergedMails.get(i));
            List<String> currMailList = new ArrayList<>();
            currMailList.add(details.get(i).get(0)); // Add name
            currMailList.addAll(mergedMails.get(i));

            outputList.add(currMailList);
        }

        return outputList;
    }

}
