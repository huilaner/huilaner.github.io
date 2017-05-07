/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
/**
  * http://www.lintcode.com/en/problem/read-characters-from-file-multiple-calls/
*/
public class Solution extends Reader4 {
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    char[] tmpBuf = new char[4];
    int readNum = 0, i4 = 0;
    
    public int read(char[] buf, int n) {
        int i = 0;
        while(i < n){
            if(i4 == readNum){//finished reading, or just start
                readNum = read4(tmpBuf);
                i4 = 0;//start again
                if(readNum == 0) break;//no more thing to read, and already read all exisiting stuff
            }
            if(i4 < readNum){//still have unread in tmpBuf
                buf[i++] = tmpBuf[i4++];
            }
            
        }
        return i;
    }
}
