package problem341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    List<Integer> integerList;
    int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        integerList = new ArrayList<>();
        dfs(nestedList);
    }

    private void dfs(List<NestedInteger> nestedList) {
        if (nestedList == null) return;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                integerList.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return integerList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < integerList.size();
    }
}