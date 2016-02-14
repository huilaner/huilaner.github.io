/**
  * difficulty: medium
  * url: https://leetcode.com/problems/additive-number/
  * ref: https://leetcode.com/discuss/70102/java-recursive-and-iterative-solutions
*/
import java.math.BigInteger;
public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == "") return true;
        if(num.length() < 3) return false;
        for(int i = 1; i <= num.length()/2; i++){
            if(num.charAt(0) == '0' && i>1) return false;
            BigInteger n1 = new BigInteger(num.substring(0, i));
            for(int j = 1; j <= num.length()-Math.max(i,j)-i; j++){
                if(num.charAt(i)=='0' && j > 1) break;//not start with 0X
                BigInteger n2 = new BigInteger(num.substring(i, j+i));
                if(isValid(n1, n2, j+i, num)) return true;
            }
        }
        return false;
    }
    
    private boolean isValid(BigInteger n1, BigInteger n2, int start, String num){
        if(start == num.length()) return true;
        n2 = n1.add(n2); // sum
        n1 = n2.subtract(n1); //n2
        String sum = n2.toString();
        if(!num.startsWith(sum, start)) return false;
        return isValid(n1, n2, start+sum.length(), num);
    }

}

//using Long

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == "") return true;
        if(num.length() < 3) return false;
        for(int i = 1; i <= num.length()/2; i++){
            if(num.charAt(0) == '0' && i>1) return false;
            Long n1 = Long.parseLong(num.substring(0, i));
            for(int j = 1; j <= num.length()-Math.max(i,j)-i; j++){
                if(num.charAt(i)=='0' && j > 1) break;//not start with 0X
                Long n2 = Long.parseLong(num.substring(i, j+i));
                if(isValid(n1, n2, j+i, num)) return true;
            }
        }
        return false;
    }
    
    private boolean isValid(Long n1, Long n2, int start, String num){
        if(start == num.length()) return true;
        n2 = n1 + n2; // sum
        n1 = n2 - n1; //n2
        String sum = n2 + "";
        if(!num.startsWith(sum, start)) return false;
        return isValid(n1, n2, start+sum.length(), num);
    }

}
