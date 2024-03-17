package contest.wc366.p2;

import java.util.Collections;
import java.util.List;

class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);
        int res = 0;
        for (int i = 0; i < tasks.size(); i++) {
            int j = processorTime.size() - 1 - i / 4;
            res = Math.max(res, processorTime.get(j) + tasks.get(i));
        }
        return res;
    }
}
