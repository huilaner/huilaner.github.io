
/**
 * difficulty: medium
 * url: http://www.lintcode.com/en/problem/heapify/
 * tag: heap
 */
public class Heapify {
    public void heapify(int[] A) {
        if(A == null || A.length == 0){
            return;
        }
        for(int i = 0; i < A.length; i++){
            siftup(A, i);
        }
    }

    private void siftup(int[] A, int i){
        if(2*i+2 < A.length) siftup(A, 2*i+2);
        if(2*i+1 < A.length) siftup(A, 2*i+1);
        if(2 * i + 2 < A.length){
            if(A[i] < Math.min(A[2*i+2], A[2*i+1])){
                return;
            }else{
                if(A[2*i+2] < A[2*i+1]) {
                    swap(A, i, 2*i+2);
                }
                else {
                    swap(A, i, 2*i+1);
                }
            }

        }else if (2 * i + 1 < A.length){
            if(A[i] > A[2*i+1]) {
                swap(A, i, 2*i+1);
            }
        }
        //if no child no need to check
    }

    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void printAry(int[] A){
        for(int i = 0; i < A.length; i++){
            if(i != A.length-1) System.out.print(A[i]+", ");
            else System.out.print(A[i]);
        }
        System.out.println();
    }
    public static void main(String[] args){
        Heapify h = new Heapify();
        int[] ary = {45,39,32,11};
        h.heapify(ary);
        h.printAry(ary);
    }
}
