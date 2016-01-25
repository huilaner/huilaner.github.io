/**
  * difficulty: meidium
  * url: https://leetcode.com/problems/peeking-iterator/
  * tag:design
  * ref: https://github.com/google/guava/blob/703ef758b8621cfbab16814f01ddcc5324bdea33/guava-gwt/src-super/com/google/common/collect/super/com/google/common/collect/Iterators.java#L1125
*/
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer next = null;
    private Iterator<Integer> it;

public PeekingIterator(Iterator<Integer> iterator) {
   // initialize any member here.
   this.it = iterator;
   if(it.hasNext()) next = it.next();
}

    // Returns the next element in the iteration without advancing the iterator.
public Integer peek() {
        return this.next;
}

// hasNext() and next() should behave the same as in the Iterator interface.
// Override them if needed.
@Override
public Integer next() {
   int r = this.next;
   this.next = (this.it.hasNext()) ? it.next() : null;
   return r;
}

@Override
public boolean hasNext() {
   return this.next != null;
}
}
