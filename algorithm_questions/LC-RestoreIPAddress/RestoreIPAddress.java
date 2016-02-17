/**
  * difficulty: medium
  * url: https://leetcode.com/problems/restore-ip-addresses/
  * tag: backtracking, string
  * other way: https://leetcode.com/discuss/12790/my-code-in-java (iterative method)
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
       List<String> list = new ArrayList<>();
       if(s.equals("") || s.length() < 4 || s.length() > 12) return list;

       String[] currIp = new String[4];
       getIp(list, s, 0, currIp);
       return list;
    }

    private void getIp(List<String> list, String s, int domain, String[] currIp){
        if(s.equals("")) return;
        if(domain == 3 && !s.equals("")){
            if(s.charAt(0)=='0' && s.length() > 1) return;
            if(s.length() > 3) return;
            int d = Integer.parseInt(s);
            if(d >= 0 && d <= 255){
                list.add(currIp[0]+"."+currIp[1]+"."+currIp[2]+"."+d);
            }else return;
        }

        if(domain != 3){
            for(int i = 1; i <=Math.min(3, s.length()); i++){
                if(i > 1 && s.charAt(0)=='0') break; 
                int num = Integer.parseInt(s.substring(0,i));
                if(num >= 0 && num <= 255){
                    currIp[domain] = num+"";
                    getIp(list, s.substring(i), domain+1, currIp);
                }
            }
        }
        

    }
}
