/**
  * difficulty: medium
  * url: http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/
  * tag: binary search, sorted array
*/
/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */
public class SearchInBigSortAry {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
    	if(reader == null || target < reader.get(0)) return -1;
        
        int L = 0, M = 1, R = 2;
        while(reader.get(R) != -1){
            if(target <= reader.get(R)){
                //do binary search between L,R
                while(L + 1 < R){
                    int mid = L + (R - L) / 2;
                    int num = reader.get(mid);
                    if(target <= num){
                        R = M;
                    }else{
                        L = M;
                    }
                }
                if(reader.get(L) == target) return L;
                else if(reader.get(R) == target) return R;
                else return -1;
            }
            else {
            	L = M;
            	M = R;
                R = M + (M - L);//prevent overflow
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
    	int[] ary = {1,2,3,4,5};
    	ArrayReader ar =  new ArrayReader(ary);
    	int t = 5;
    	SearchInBigSortAry sa = new SearchInBigSortAry();
    	int r = sa.searchBigSortedArray(ar, t);
    	System.out.println(r);
    	
    	int[] ary2 = {2,2,3,4,5,6,8,13,17,18};
    	ArrayReader ar2 =  new ArrayReader(ary2);
    	int t2 = 2;
    	int r2 = sa.searchBigSortedArray(ar2, t2);
    	System.out.println(r2);
    	
    	//1,3,6,9,21
    	int[] ary3 = {1,3,6,9,21};
    	ArrayReader ar3 =  new ArrayReader(ary3);
    	int t3 = 3;
    	int r3 = sa.searchBigSortedArray(ar3, t3);
    	System.out.println(r3);
    }
    
}
