/**
  * difficulty: easy
  * url: https://leetcode.com/problems/bulls-and-cows/
  * tag: HashTable
*/

//My first solutions using hashtable and sets
public class Solution {
    public String getHint(String secret, String guess) {
        if(guess == "" || secret == "") return "0A0B";
        HashMap<Integer, HashSet<Integer>> mapS = getMaps(secret);
        HashMap<Integer, HashSet<Integer>> mapG = getMaps(guess);
        int numA = 0; int numB = 0;
        
        for(int key : mapG.keySet()){
            if(mapS.containsKey(key)){
                HashSet<Integer> sNumSet = mapS.get(key);
                HashSet<Integer> gNumSet = mapG.get(key);
                HashSet<Integer> intersection = new HashSet<>(sNumSet); // use the copy constructor
                intersection.retainAll(gNumSet);
                numA += intersection.size();
                numB += (sNumSet.size()-intersection.size() > 0 && gNumSet.size() - intersection.size()>0) ? Math.min(sNumSet.size()-intersection.size(), gNumSet.size() - intersection.size()) : 0;
            }
        }
        
        return numA+"A"+numB+"B";
    }
    
    public HashMap<Integer, HashSet<Integer>> getMaps(String s){
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for(int i = 0; i < s.length(); i++){
            int curr = Integer.parseInt(s.charAt(i)+"");
            if(!map.containsKey(curr)){
                HashSet<Integer> idxAry = new HashSet<>();
                idxAry.add(i);
                map.put(curr, idxAry);
            }else{
                HashSet<Integer> idxAry = map.get(curr);
                idxAry.add(i);
                map.put(curr, idxAry);
            }
        }
        return map;
    }
}

//better solution, don't have to get the acutal set, just count the number will be sufficient

public class Solution {
    public String getHint(String secret, String guess) {
      int temp = 0;
      int bulls = 0;
      int[] nums1 = new int[10];
      int[] nums2 = new int[10];
      for(int i = 0; i < secret.length(); i++){
          char s = secret.charAt(i);
          char g = guess.charAt(i);
          if(s == g){
              bulls++;
          }
          else{
              nums1[s - '0']++;
              nums2[g - '0']++;
          }
      }
      int cows = 0;
      for(int i = 0; i < 10; i++){
          cows += Math.min(nums1[i], nums2[i]);
      }
      String res = bulls + "A" + cows + "B";
      return res;
    }
}
