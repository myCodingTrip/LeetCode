package contest.wc371.p2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String> res = new ArrayList<>();
        Map<String, List<List<String>>> atMap = access_times.stream().collect(Collectors.groupingBy(at -> at.get(0)));
        for (String name : atMap.keySet()) {
            List<List<String>> atList = atMap.get(name);
            atList.sort(new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    return o1.get(1).compareTo(o2.get(1));
                }
            });
            int size = atList.size();
            int i = 0, j = 0;
            while (true) {
                j++;
                if (j == size) {
                    break;
                }
                while (getTime(atList.get(j).get(1)) - getTime(atList.get(i).get(1)) >= 60) {
                    i++;
                }
                if (j - i + 1 >= 3) {
                    res.add(name);
                    break;
                }
            }
        }
        return res;
    }

    public int getTime(String at) {
        return Integer.parseInt(at.substring(0, 2)) * 60 + Integer.parseInt(at.substring(2, 4));
    }
}
