package problem341;

import java.util.List;

public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested integerList.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested integerList
    public Integer getInteger();

    // @return the nested integerList that this NestedInteger holds, if it holds a nested integerList
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}